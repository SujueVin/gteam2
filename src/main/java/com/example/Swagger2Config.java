package com.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName Swagger2Config
 * @Description Swagger2配置类
 * @date 2021/11/30 18:57
 * @Version 1.0
 * @Author HJW
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定哪个包下面生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    /**
     * 文档基本信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version("1.0")
                .title("gteam2接口文档")
                .description("gteam2接口文档")
                .contact(new Contact("sujue", "http://localhost:8080", "xxx@xxx.com"))
                .build();

    }
}