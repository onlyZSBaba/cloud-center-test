package com.example.serviceconsumerdemo.controller;

import com.example.serviceconsumerdemo.client.EchoClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 36569
 * @Date 2022-04-28 10:23
 * @Version 1.0
 */
@RestController
@RequestMapping("/echo")
@Api(tags = "服务 - 消费者")
public class EchoConsumerController {

    //注入 @FeignClient 注解配置 所配置的 EchoClient 客户端Feign实例
    @Resource
    EchoClient echoClient;

    //回显服务
    @ApiOperation(value = "消费回显服务接口")
    @RequestMapping(value = "/{string}", method = RequestMethod.GET)
    public String echoRemoteEcho(@PathVariable String string) {
        return "provider echo is:" + echoClient.echo(string);
    }
}
