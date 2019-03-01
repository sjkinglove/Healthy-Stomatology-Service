package com.haoze.service;

import com.haoze.common.dto.TUser;
import com.haoze.common.dto.UserEntity;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Headers("Content-Type:application/json")
@FeignClient(name = "api-admin")
public interface AdminService {

    @GetMapping("/system/user/info/{loginName}")
    TUser getInfo(@PathVariable("loginName") String account);
}