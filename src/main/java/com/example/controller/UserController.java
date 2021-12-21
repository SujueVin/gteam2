package com.example.controller;


import com.example.annotation.authentication;
import com.example.dto.UserDetailDTO;
import com.example.dto.UserDetailShowDTO;
import com.example.dto.UserMsgDTO;
import com.example.po.User;
import com.example.pojo.RegisterParam;
import com.example.pojo.UUser;
import com.example.pojo.UserToken;
import com.example.service.impl.TokenServiceImpl;
import com.example.service.impl.UserServiceImpl;
import com.example.util.HttpContextUtil;
import com.example.util.Result.Result;
import com.example.util.Result.ResultCode;
import com.example.util.mail.MailUtils;
import com.example.util.token.TokenConstant;
import com.example.util.token.TokenUtil;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author su_jue
 * @since 2021-12-13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    private TokenServiceImpl tokenService;

    //查询用户详细信息，登录后可以查询到别人的信息
    //不需要返回整个user对象，只返回非隐私的数据，返回UserMsgDTO对象
    @GetMapping("/userMsg")
    @authentication
    public Result getUserInfo(Integer userid){

        if (userid==null){
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }

        //调用usersevice获得userMsg
        UserMsgDTO userMsg =userService.findUserMsg(userid);

        //这里需要使用service层查询数据库内对象，然后返回
        if (userMsg!=null){//能够查到，进行返回
            return Result.success(userMsg);
        }
        return Result.error(ResultCode.NOT_FIND);//没有查到，返回空对象user对应的json数据
    }

    //查询自己本身信息，登录后才可使用,不需要鉴权，自身鉴权
    //不需要返回整个user对象，只返回需要的，返回UserDetailShowDTO对象
    @GetMapping("/personal")
    public Result getSelfDetail() throws InvalidJwtException, MalformedClaimException {
        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常

        int userid=Integer.parseInt(TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0));
        //查询数据库,获取为token中对应userid的信息
        //这里需要使用service层查询数据库内对象，然后返回
        UserDetailShowDTO userDetail = userService.findMyDetail(userid);
        if (userDetail != null){//如果数据库中有这个用户，返回
            return Result.success(userDetail);
        }
        return Result.error(ResultCode.NOT_FIND);//没有查到，返回空对象user对应的json数据
    }

    //用户更新数据,只能更新自己的数据，接收UserDetailDTO对象,需要鉴权
    @PutMapping("/personal")
    public Result updateById(@RequestBody UserDetailDTO userDetail) throws InvalidJwtException, MalformedClaimException {

        // 从 request header 中获取当前 token
        String accessToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.ACCESS_TOKEN_NAME);
        //检验accesstoken是否过期,是否符合格式，不符合要求或者过期的话util类将会自动抛出异常
        String userid=TokenUtil.getJwtClaims(accessToken, TokenConstant.tokenType.ACCESS_TOKEN).getAudience().get(0);

        //接收到数据之后,修改数据库内信息
        //直接调用server层进行数据的注入
        userService.updateUserDetail(userDetail,Integer.parseInt(userid));
        //如果对密码进行了更改,也就是userDetail中有密码，需要经历注销过程
        if (!"".equals(userDetail.getPassword())||userDetail.getPassword()!=null){
            //在mongodb内消除对应的token
            tokenService.delToken(userid);
            return Result.success(ResultCode.SUCCESS_CHANGE_PASSWORD);
        }
        return Result.success();
    }

    //登录获取token
    //参数需要：password,username，通过post加密传输保证传输信息安全
    @PostMapping("/login")
    public Result login(String userName,String password) throws JoseException {

        if ("".equals(userName)||"".equals(password)){
            //如果传递的参数是空，返回空值
            return Result.error(ResultCode.IS_NULL);
        }

        //从数据库中获取数据，使用username查询password,同时获得userid
        User User = userService.findUserByUsername(userName);
        int userid= User.getUserid();
        String passwordInDB =User.getPassword();
        //这里进行验证密码操作，对得到的密码加盐md5处理，之后验证是否相等
        if (!passwordInDB.equals(password)){
            //不相等，返回错误码参数不正确
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }

        //验证成功，进行token的产生，使用token工具类
        String accessToken = TokenUtil.accessTokenSign(Integer.toString(userid));
        String refreshToken =TokenUtil.refreshTokenSign(Integer.toString(userid));
        String[] tokens = {"",""};
        tokens[0] =accessToken;
        tokens[1] =refreshToken;

        //在mongodb内存好token
        UserToken userToken = new UserToken();
        userToken.setUserid(Integer.toString(userid));
        userToken.setToken(refreshToken);
        tokenService.addTokenToMongo(userToken);

        //返回tokens
        return Result.success(tokens);
    }

    //退出注销token
    @DeleteMapping("/signOut")
    public Result signOut() throws InvalidJwtException, MalformedClaimException {

        //检验refreshtoken是否过期,或者是否不对，是的话util类将会抛出异常，自动处理
        String refreshToken = HttpContextUtil.getHttpServletRequest().getHeader(TokenConstant.REFRESH_TOKEN_NAME);

        //通过验证
        //获取jwt中Jwtclaims,获取其中的userid
        JwtClaims Jwtclaims=TokenUtil.getJwtClaims(refreshToken, TokenConstant.tokenType.REFRESH_TOKEN);
        String useridInToken=Jwtclaims.getAudience().get(0);

        //在mongodb内消除对应的token
        tokenService.delToken(useridInToken);

        //返回注销成功
        return Result.success();
    }

    /**
     * 注册
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "提交表单注册用户")
    public Result register(@RequestBody RegisterParam registerParam){
        try {
            String email = registerParam.getEmail();
            userService.findUUser(registerParam.getCode());
            User user = new User();
            user.setUsername(registerParam.getUsername());
            user.setPassword(registerParam.getPassword());
            user.setEmail(email);
            user.setStat(1);
            user.setCtime(LocalDateTime.now());
            user.setNickname(email);
            userService.addUser(user);
            userService.delUUser(email);
        }catch (Exception e){
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success();
    }

    @GetMapping("/isRegister/{username}")
    @ApiOperation(value = "判断用户名是否被注册")
    public Result checkRegister( @PathVariable String username){
        if(userService.findByUsername(username)){
            return Result.error(ResultCode.USERNAME_IS_INVALID);
        }
        return Result.success();
    }

    @GetMapping("/captcha/{email}")
    @ApiOperation(value = "发送邮箱验证码")
    public Result captcha(@PathVariable String email){
        String code = defaultKaptcha.createText();
        UUser uUser = new UUser();
        uUser.setCode(code);
        uUser.setEmail(email);
        uUser.setCreatedTime(new Date());
        try {
            userService.addUserToMongo(uUser);
            MailUtils sendMail = new MailUtils();
            sendMail.sendMail(email,code);
        }catch (Exception e){
            System.out.println(e);
            return Result.error(ResultCode.PARAM_IS_INVALID);
        }
        return Result.success();
    }
}

