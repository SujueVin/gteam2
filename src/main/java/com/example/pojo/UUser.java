package com.example.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import java.util.Date;

/**
 * @ClassName UUser
 * @Description 暂存于MongoDB的对象
 * @date 2021/12/16 18:56
 * @Version 1.0
 * @Author HJW
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UUser对象", description="注册验证码集合")
public class UUser {
    @Id
    private String email;
    private String code;
    private Date createdTime;
}