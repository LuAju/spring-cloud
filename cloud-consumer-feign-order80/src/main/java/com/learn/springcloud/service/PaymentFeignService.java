package com.learn.springcloud.service;

import com.learn.springcloud.entities.CommonResult;
import com.learn.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //微服务名称
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    // 去指定微服务中相应的接口（controller）
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    @GetMapping("/payment/timeout")
    String timeout();
}
