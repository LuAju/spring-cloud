package com.learn.springcloud.service;

import org.springframework.stereotype.Component;

// 用这个类实现这个接口，从而为接口内的所有方法做fallback处理。实现将业务与fallback解耦的目的
@Component
public class PaymentHystrixFallBack implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---paymentInfo_OK---";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----paymentInfo_Timeout---";
    }
}
