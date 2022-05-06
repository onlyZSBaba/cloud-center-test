package com.example.serviceconsumerdemo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author 36569
 * @Date 2022-04-28 10:25
 * @Version 1.0
 */
@FeignClient("service-provider-demo")
public interface EchoClient {

    @GetMapping(value = "/provider/echo/{string}")
    String echo(@PathVariable String string);
}
