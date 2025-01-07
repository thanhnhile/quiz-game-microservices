package com.microservice.gatewayserver.filter;

import com.microservice.gatewayserver.util.FilterUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@Order(1)
public class RequestTraceFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    private final FilterUtility filterUtility;

    public RequestTraceFilter(FilterUtility filterUtility) {
        this.filterUtility = filterUtility;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!isCorrelationIdPresent(exchange)) {
            String correlationId = generateCorrelationId();
            logger.debug("Adding correlationId: " + correlationId);
            exchange = filterUtility.setCorrelationId(exchange, correlationId);
        } else {
            logger.debug("CorrelationId already present " + filterUtility.getCorrelationId(exchange.getRequest().getHeaders()));
        }
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(ServerWebExchange exchange) {
        return filterUtility.getCorrelationId(exchange.getRequest().getHeaders()) != null;
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
