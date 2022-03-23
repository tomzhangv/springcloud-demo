package com.yun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Controller {
    @RequestMapping("/world")
    public String helloWorld(String s) {
        System.out.println("Eureka client中传入的值为：" + s);
        return "Eureka client中传入的值为:" + s;
    }
}
