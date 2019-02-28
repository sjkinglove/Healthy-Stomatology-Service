package com.haoze.common.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Headers("Content-Type:application/json")
@FeignClient(name = "api-base")
public interface AuthService {
    @GetMapping("/auth/hasRole")
    boolean hasRole(@RequestParam("role") String role, @RequestParam("account") String account);

    @GetMapping("/auth/hasPermission")
    boolean hasPermission(@RequestParam("permission") String permission, @RequestParam("account") String account);
}