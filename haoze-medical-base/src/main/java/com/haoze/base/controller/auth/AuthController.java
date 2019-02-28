package com.haoze.base.controller.auth;

import com.haoze.base.core.jwt.JwtUtil;
import com.haoze.base.service.auth.AuthService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yangyb
 * @date 2019/1/24
 */
@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private AuthService authService;

    @GetMapping("/hasRole")
    public boolean hasRole(@RequestParam("role") String role, @RequestParam("account") String account) {
        return authService.hasRole(account, role);
    }

    @GetMapping("/hasPermission")
    public boolean hasPermission(@RequestParam("permission") String permission, @RequestParam("account") String account) {
        return authService.hasPermission(account, permission);
    }
}
