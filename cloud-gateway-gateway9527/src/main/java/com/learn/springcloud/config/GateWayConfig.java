package com.learn.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        // 路由对象
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path",
                r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        // 地址栏 输入localhost:9527/guonei 会自动映射到  http://news.baidu.com/guonei
        return routes.build();
    }
}
