package com.yun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: config controller
 * @Param:
 * @Return:
 * @Author: tom zhang
 * @Date: 2022/3/22 14:31
 */
@RestController
public class ConfigController {

    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public String getName(){
        return name;
    }
}
