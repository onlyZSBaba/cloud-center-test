package com.example.serviceproviderdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 36569
 * @Date 2022-04-27 16:34
 * @Version 1.0
 */
//配置发布之后，动态刷新配置
@RefreshScope
@Api(tags = "服务 - 提供者")
@RestController
@RequestMapping("/echo")
public class EchoController {

    @Value("${user.name}")
    private String name;

    @Value("${data.age}")
    private int age;

    /**
     * 回显服务
     * @param string
     * @return
     */
    @ApiOperation(value="回显信息",httpMethod="GET",notes="echo")
    @GetMapping(value = "/{string}")
    public String echo(@PathVariable String string) {
        return "echo: " + string + " name: " + name + " age: " + age;
    }

}
