package com.learn.springcloud;

import com.learn.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author :   ''
 * @version :   1.0
 * @ClassName :    OrderMain80$
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
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}