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

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  // 时间窗口期,10s钟后才会开启
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return "调用成功";
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数";
    }



}
