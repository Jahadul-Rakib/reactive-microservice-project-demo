package com.rakib.userservice.service.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class ResponseDTO {

    public static Mono<ResponseEntity<Map<String, Object>>> sendResponseMono(HttpStatus status, String message, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", data);
        return Mono.just(ResponseEntity.ok().body(map));
    }
    public static Flux<ResponseEntity<Map<String, Object>>> sendResponseFlux(HttpStatus status, String message, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("message", message);
        map.put("data", data);
        return Flux.just(ResponseEntity.ok().body(map));
    }
}
