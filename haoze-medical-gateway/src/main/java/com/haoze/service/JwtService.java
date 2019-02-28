package com.haoze.service;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Headers("Content-Type:application/json")
@FeignClient(name = "api-base")
public interface JwtService {
    @GetMapping("/jwt/getAccountByToken/{token}")
    String getAccountByToken(@PathVariable("token") String token);

}