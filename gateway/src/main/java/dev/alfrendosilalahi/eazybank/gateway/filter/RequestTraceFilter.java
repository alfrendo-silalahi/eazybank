package dev.alfrendosilalahi.eazybank.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

    private final Logger log = LoggerFactory.getLogger(RequestTraceFilter.class);

    private final FilterUtil filterUtil;

    public RequestTraceFilter(FilterUtil filterUtil) {
        this.filterUtil = filterUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if (isCorrelationIdPresent(requestHeaders)) {
            log.debug("eazybank correlation id present in RequestTraceFilter: {}", filterUtil.getCorrelationId(requestHeaders));
        } else {
            String correlationId = generateCorrelationId();
            exchange = filterUtil.setCorrelationId(exchange, correlationId);
            log.debug("eazybank correlation id generated in RequestTraceFilter: {}", correlationId);
        }
        return chain.filter(exchange);
    }

    private boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
        return filterUtil.getCorrelationId(requestHeaders) != null;
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

}
