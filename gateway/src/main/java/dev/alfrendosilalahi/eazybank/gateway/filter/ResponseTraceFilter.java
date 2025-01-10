package dev.alfrendosilalahi.eazybank.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

@Configuration
public class ResponseTraceFilter {

    private final Logger log = LoggerFactory.getLogger(ResponseTraceFilter.class);

    private final FilterUtil filterUtil;

    public ResponseTraceFilter(FilterUtil filterUtil) {
        this.filterUtil = filterUtil;
    }

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> chain
                .filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
                    String correlationId = filterUtil.getCorrelationId(requestHeaders);
                    log.debug("update the correlation id to the outbound headers: {}", correlationId);
                    exchange.getResponse().getHeaders().add(FilterUtil.CORRELATION_ID, correlationId);
                }));
    }
}
