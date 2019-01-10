package com.boot.global.config;


import com.boot.global.inteceptor.WebApplicationInterceptor;
import com.boot.global.swagger.SwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by huquanbo on 2018/10/30.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private WebApplicationInterceptor webApplicationInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webApplicationInterceptor).addPathPatterns("/**").excludePathPatterns("/static/**");
    }

    @Bean
    public SwaggerConfig getSwagger(){
        return new SwaggerConfig();
    }
}
