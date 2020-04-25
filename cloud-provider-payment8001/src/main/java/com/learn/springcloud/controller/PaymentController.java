package com.learn.springcloud.controller;

import com.learn.springcloud.entities.CommonResult;
import com.learn.springcloud.entities.Payment;
import com.learn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author :   chenlong
 * @version :   1.0
 * @ClassName :    PaymentController$
 * @Description :   TODO(用一句话描述该类做什么)
 * @projectname :   nebula
 * @DATE :   Created in 11:36$ 2020/3/18$
 *
 * <pre>       Copyright: Copyright(c)2019     </pre>
 * <pre>       Company :   unittec             </pre>
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2020/3/18$       chenlong        1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入日志："+result);
        if (result>0) {
            return new CommonResult(200, "success", result);
        } else {
            return new CommonResult(200, "failed", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("sqqs");
        if (payment!=null) {
            return new CommonResult(200, "查询成功了m ", payment);
        } else {
            return new CommonResult(200, "没有对应记录", null);
        }
    }
}