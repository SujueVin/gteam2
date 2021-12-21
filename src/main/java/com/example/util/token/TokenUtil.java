package com.example.util.token;


import org.jose4j.jwa.AlgorithmConstraints;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.ErrorCodes;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

//使用jose4j 生成Token 的工具类
//此类将
// 1. 产生两类token -accessToken和refreshToken
// 2. 对这两类token进行检验，包括过期检验和是否正确检验
// 这两种检验方式如果没有成功将会抛出异常至切面类，切面类按照错误类中的msg进行不同的返回
// 抛出错误之前将会进行一些数据库处理，做成静态方法给外面使用
public class TokenUtil {

    //只生成一个ras key 同时为两个使用
    public static RsaJsonWebKey accessTokenWebKey = null;
    public static RsaJsonWebKey refreshTokenWebKey = null;

    //静态代码块生成ras key
    static {
        // 生成两个RSA密钥对，用于签署和验证JWT，包装在JWK中

            try {
                accessTokenWebKey = RsaJwkGenerator.generateJwk(2048);
                accessTokenWebKey.setKeyId("accessTokenWebKey");
            } catch (JoseException e) {
                e.printStackTrace();
            }
            try {
                refreshTokenWebKey = RsaJwkGenerator.generateJwk(2048);
                refreshTokenWebKey.setKeyId("refreshTokenWebKey");
            } catch (JoseException e) {
                e.printStackTrace();
            }
    }

    //这个方法生成accessToken
    public static String accessTokenSign(String Audience) throws JoseException {
        JwtClaims claims = new JwtClaims();
        //这里设置发放给谁，需要存入一个参数，就是上面传过来的用户名

        claims.setAudience(Audience,""); //给谁
        claims.setExpirationTimeMinutesInTheFuture(TokenConstant.ACCESS_TOKEN_EXPIRES_HOUR); //失效时间，单位分钟
        claims.setIssuedAtToNow();  // 什么时候创建的 (now)
        claims.setJwtId(accessTokenWebKey.getKeyId());

        // JWT是一个JWS和/或一个带有JSON声明的JWE作为有效负载。
        // 在这个例子中，它是一个JWS，所以我们创建一个JsonWebSignature对象.
        JsonWebSignature jws = new JsonWebSignature();

        // JWS的有效负载是JWT声明的JSON内容
        jws.setPayload(claims.toJson());

        // JWT使用私钥签署,生成对应的token
        jws.setKey(accessTokenWebKey.getPrivateKey());

        /*
         * 设置关键ID（kid）头，因为这是一种礼貌的做法。 在这个例子中，我们只有一个键但是使用键ID可以帮助 促进平稳的关键滚动过程
         */
        jws.setKeyIdHeaderValue(accessTokenWebKey.getKeyId());

        // 在jw/jws上设置签名算法,这个算法将会被用于加密B端
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        /*
         * 签署JWS并生成紧凑的序列化或完整的jw/JWS 表示，它是由三个点（'.'）分隔的字符串
         * 在表单头.payload.签名中使用base64url编码的部件 如果你想对它进行加密，你可以简单地将这个jwt设置为有效负载
         * 在JsonWebEncryption对象中，并将cty（内容类型）头设置为“jwt”。
         */
        return jws.getCompactSerialization();
    }

    //这个方法生成refreshToken
    public static String refreshTokenSign(String Audience) throws JoseException {
        JwtClaims claims = new JwtClaims();
        //这里设置发放给谁，需要存入一个参数，就是上面传过来的用户名

        claims.setAudience(Audience,""); //给谁
        claims.setExpirationTimeMinutesInTheFuture(TokenConstant.REFRESH_TOKEN_EXPIRES_HOUR); //失效时间，单位分钟
        claims.setIssuedAtToNow();  // 什么时候创建的 (now)
        claims.setJwtId(refreshTokenWebKey.getKeyId());

        JsonWebSignature jws = new JsonWebSignature();

        jws.setPayload(claims.toJson());

        // JWT使用私钥签署,生成对应的token
        jws.setKey(refreshTokenWebKey.getPrivateKey());

        /*
         * 设置关键ID（kid）头，因为这是一种礼貌的做法。 在这个例子中，我们只有一个键但是使用键ID可以帮助 促进平稳的关键滚动过程
         */
        jws.setKeyIdHeaderValue(refreshTokenWebKey.getKeyId());

        // 在jw/jws上设置签名算法,这个算法将会被用于加密B端
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

        return jws.getCompactSerialization();
    }

    //下面需要写一个抽出，抽出jwt的b端给外面得到信息
    public static JwtClaims getJwtClaims(String jwt, TokenConstant.tokenType tokenType) throws InvalidJwtException {
        /*
         * 使用JwtConsumer builder构建适当的JwtConsumer，它将 用于验证和处理JWT。 JWT的具体验证需求是上下文相关的
         */
        //设定正确的 raskey
        RsaJsonWebKey rsaJsonWebKey=null;
        switch (tokenType) {
            case ACCESS_TOKEN:
                rsaJsonWebKey = accessTokenWebKey;
                break;
            case REFRESH_TOKEN:
                rsaJsonWebKey = refreshTokenWebKey;
                break;
        }

        JwtConsumer jwtConsumer = new JwtConsumerBuilder().setRequireExpirationTime()  //JWT必须有一个有效期时间
                .setAllowedClockSkewInSeconds(30) // 允许在验证基于时间的令牌时留有一定的余地，以计算时钟偏差。单位/秒
                .setExpectedAudience("") // JWT的目的是给谁, 用来验证观众
                .setVerificationKey(rsaJsonWebKey.getKey()) // 用公钥验证签名 ,验证秘钥
                .setJwsAlgorithmConstraints( // 只允许在给定上下文中预期的签名算法,使用指定的算法验证
                        AlgorithmConstraints.ConstraintType.PERMIT, AlgorithmIdentifiers.RSA_USING_SHA256)
                .build(); // 创建JwtConsumer实例

        return jwtConsumer.processToClaims(jwt);
    }

    //下面将是检验方法
    //检验方法会抛出两种错误,需要传入检验的是什么类型token
    public static void checkJwt(String jwt, TokenConstant.tokenType tokenType) throws InvalidJwtException {
        //下面进行可能的错误处理，如果不产生错误，则将会继续
        //注意需要在此类内就向外抛出错误，进入ExceptionHandle类内进行处理
        try {
            // 验证JWT并将其处理为jwtClaims,取出b端
            JwtClaims jwtClaims = getJwtClaims(jwt,tokenType);
            //如果JWT失败的处理或验证，将会抛出InvalidJwtException。
            //System.out.println("JWT validation succeeded! " + jwtClaims);
        } catch (InvalidJwtException e) {
            //System.out.println("Invalid JWT! " + e);

            // 对JWT无效的（某些）特定原因的编程访问也是可能的
            // 在某些情况下，您是否需要不同的错误处理行为。
            // JWT是否已经过期是无效的一个常见原因
            if (e.hasExpired()) {
                throw e;
            }
            // 或者观众是无效的，也就是token本身错误
            if (e.hasErrorCode(ErrorCodes.AUDIENCE_INVALID)) {
                throw e;
            }
            //或者是其他各种错误
            throw e;
        }
    }

}
