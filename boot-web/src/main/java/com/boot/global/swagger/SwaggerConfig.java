package com.boot.global.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author by tangye1 on 2018/5/18.
 *         Created by tangye1 on 2018/5/18.
 *         swagger注意点
 *         1.只支持80端口
 *         2.只支持.com域名
 */
@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    //构建api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("流量自动化接入管理端API")
                //创建人
                .contact(new Contact("huquanbo", "http://www.jd.com", ""))
                //版本号
                .version("1.0")
                //描述
                .description("流量自动化接入管理端API描述")
                .build();
    }
}