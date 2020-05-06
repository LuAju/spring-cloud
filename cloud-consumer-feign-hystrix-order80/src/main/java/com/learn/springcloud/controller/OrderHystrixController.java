package com.learn.springcloud.controller;

import com.learn.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_GlobalErrorHandler")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK (@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        log.info(result);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_ErrorHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "9000")
//    })
    @HystrixCommand //使用服务降级，但是不指明
    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout (@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        log.info(result);
        return result;
    }

    public String paymentInfo_ErrorHandler (@PathVariable("id") Integer id) {
        String result = "等一下";
        log.info(result);
        return result;
    }


    // 全局fallback
    // 这里不能在方法里添加参数，否则无法找到该方法
    public String paymentInfo_GlobalErrorHandler () {
        String result = "我是全局处理";
        log.info(result);
        return result;
    }
}
