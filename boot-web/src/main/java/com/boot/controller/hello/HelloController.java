package com.boot.controller.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IDEA
 * USER : meijie
 * Date : 2018/11/12
 * Time : 20:26
 */

@RestController
@RequestMapping(value = "/helloController")
public class HelloController {

    @GetMapping(value = "hello")
    public void hello(){
        System.out.println("a");
    }

}
