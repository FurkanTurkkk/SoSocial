package com.api_gateway.api_gateway.filter;


import com.api_gateway.api_gateway.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter implements WebFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (request.getURI().getPath().startsWith("/api/v1/auth")) {
            return chain.filter(exchange);
        }

        if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"You don't have JWT ! Firstly login please");
        }

        String token = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if(token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        if (!jwtUtil.validateToken(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Geçersiz JWT token.");
        }

        Long userId = jwtUtil.extractUserId(token);  // JWT içinden userId çek
        ServerHttpRequest modifiedRequest = exchange.getRequest().mutate()
                .header("X-Auth-Id", String.valueOf(userId))  // Header'a ekle (String olarak)
                .build();

        ServerWebExchange modifiedExchange = exchange.mutate().request(modifiedRequest).build();
        return chain.filter(modifiedExchange);
    }
}

