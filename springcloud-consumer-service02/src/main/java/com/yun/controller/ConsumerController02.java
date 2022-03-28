package com.yun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: config controller
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/3/22 14:31
 */
@RefreshScope
@RestController
public class ConsumerController02 {

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;


    @GetMapping("/name")
    public String getName(){
        return name;
    }

    @GetMapping("/password")
    public String getPassword(){
        return password;
    }
}
