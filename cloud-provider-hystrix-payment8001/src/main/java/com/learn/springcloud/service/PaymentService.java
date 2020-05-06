package com.learn.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    // 正长的方法
    public String paymentInfo_ok(Integer id){
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfo_ok\t" + id;
    }

    // 错误的方法
    public String paymentInfo_Error(Integer id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfo_tiemout\t" + id;
    }

}
