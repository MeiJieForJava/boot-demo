package com.boot.global;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.boot")
@EnableSwagger2
public class BootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootWebApplication.class, args);
    }
}




//使用外置tomcat

//package com.boot.global;
//
//        import org.springframework.boot.SpringApplication;
//        import org.springframework.boot.autoconfigure.SpringBootApplication;
//        import org.springframework.boot.builder.SpringApplicationBuilder;
//        import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//        import org.springframework.context.annotation.ComponentScan;
//        import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@SpringBootApplication
//@ComponentScan(basePackages = "com.boot")
//@EnableSwagger2
//public class BootWebApplication extends SpringBootServletInitializer {
////public class BootWebApplication implements WebMvcConfigurer {
//
//    public static void main(String[] args) {
//        SpringApplication.run(BootWebApplication.class, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(BootWebApplication.class);
//    }
//}
