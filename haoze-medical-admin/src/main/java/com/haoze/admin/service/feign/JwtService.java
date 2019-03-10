package com.haoze.admin.service.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@Headers("Content-Type:application/json")
@FeignClient(name = "api-base")
public interface JwtService {
    @RequestMapping(value = "/jwt/getToken", method = RequestMethod.GET)
    String getToken(@RequestParam("loginName") String account, @RequestParam("tuId") String id, @RequestParam("auth") String auth);
}