package com.learn.springcloud.controller;

import com.learn.springcloud.entities.CommonResult;
import com.learn.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :   ''
 * @version :   1.0
 * @ClassName :    OrderController$
 * @Description :   TODO(用一句话描述该类做什么)
 * @projectname :   ''
 * @DATE :   Created in 11:36$ 2020/3/18$
 *
 * <pre>       Copyright: Copyright(c)2019     </pre>
 * <pre>       Company :   ''             </pre>
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2020/3/18$       ''        1.0             1.0
 * Why & What is modified: <修改原因描述>
 */
@RestController
@Slf4j
public class OrderController {
    // 修改服务的名称，不再使用ip地址，改用服务名称
    private static final String URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(URL + "/payment/create", payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(URL + "/payment/get/"+id,  CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentForEnity(@PathVariable("id") Long id){
        // 如果是object，则返回值类似对象的json字符串，如果是ForEntity，则包含另外的请求信息
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }
}