package com.learn.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * @author :   ''
 * @version :   1.0
 * @ClassName :    ApplicationContextConfig$
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
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced // 添加负载均衡功能，通过微服务的名称添加服务功能，不再使用地址的方式
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}