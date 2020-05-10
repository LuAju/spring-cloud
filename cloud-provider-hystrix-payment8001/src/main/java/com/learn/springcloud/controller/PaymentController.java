package com.learn.springcloud.controller;

import com.learn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("payment/hystrix/ok/{id}")
    public String paymentInfo_OK (@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_ok(id);
        log.info(result);
        return result;
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout (@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Error(id);
        log.info(result);
        return result;
    }

    @GetMapping("payment/circuitBreaker/{id}")
    public String circuitBreaker (@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info(result);
        return result;
    }
}
