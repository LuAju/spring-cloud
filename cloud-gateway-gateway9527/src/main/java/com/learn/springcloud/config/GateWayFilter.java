package com.learn.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class GateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.info("***非法用户***");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            // 退出
            return exchange.getResponse().setComplete();
        }
        // 进入下一个过滤连
        log.info("***合法用户***");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
