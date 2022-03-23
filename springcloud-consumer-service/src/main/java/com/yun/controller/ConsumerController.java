package com.yun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/consumer")
    public String helloWorld(String s){
        System.out.println("传入的值为："+s);
        //第一种调用方式
        String forObject = new RestTemplate().getForObject("http://localhost:10084/hello/world?s=" + s, String.class);

        //第二种调用方式
        //根据服务名 获取服务列表 根据算法选取某个服务 并访问某个服务的网络位置。
//        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-CLIENT");
//        String forObject = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/hello/world?s="+s,String.class);

        //第三种调用方式 需要restTemplate注入的方式
//        String forObject = restTemplate.getForObject("http://EUREKA-CLIENT/hello/world?s=" + s, String.class);
        return forObject;
    }

    @Value("${name}")
    private String name;

    @GetMapping("/name")
    public String getName(){
        return name;
    }
}
