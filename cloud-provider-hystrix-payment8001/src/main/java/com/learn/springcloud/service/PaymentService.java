package com.learn.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    // 正长的方法
    public String paymentInfo_ok(Integer id){
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfo_ok\t" + id;
    }

    // 错误的方法
    // 使用注解添加服务操作fallback
    @HystrixCommand(fallbackMethod = "paymentInfo_ErrorHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Error(Integer id){
        try {
            // 延长时间
            TimeUnit.SECONDS.sleep(2);
//            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfo_tiemout\t" + id;
    }

    // 兜底方法
    public String paymentInfo_ErrorHandler(Integer id){
        return "线程池" + Thread.currentThread().getName() + "\tpaymentInfo_ErrorHandler\t" + id;
    }

}
