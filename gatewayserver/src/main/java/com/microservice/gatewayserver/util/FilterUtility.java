package com.microservice.gatewayserver.util;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;



@Component
public class FilterUtility {
    public static final String CORRELATION_ID = "correlation-id";

    public String getCorrelationId(HttpHeaders reqHeaders) {
        if(reqHeaders.get(CORRELATION_ID) != null){
            return reqHeaders.getFirst(CORRELATION_ID);
        }
        return null;
    }

    public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String value) {
        return setRequestHeader(exchange, CORRELATION_ID, value);
    }
}
