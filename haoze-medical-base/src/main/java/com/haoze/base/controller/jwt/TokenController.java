package com.haoze.base.controller.jwt;

import com.haoze.base.core.jwt.JwtUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yangyb
 * @date 2019/1/22
 */
@RestController
@RequestMapping("/jwt")
@Validated
public class TokenController {
    @Resource
    private JwtUtil jwtUtil;

//    @GetMapping("/getAccountByToken/{token}")
//    public String getAccountByToken(@PathVariable("token") String token) {
//        return jwtUtil.getUsername(token);// jwtUtil中存入的userName其实是账号
//    }
    @GetMapping("/getAccountByToken/{token}")
    public String getAccountByToken(@PathVariable String token) {
        return jwtUtil.getUsername(token);// jwtUtil中存入的userName其实是账号
    }

    @GetMapping("/getIdByToken/{token}")
    public String getIdByToken(@PathVariable String token) {
        return jwtUtil.getId(token);// jwtUtil中存入的userName其实是账号
    }

    @GetMapping("/getToken")
    public String getToken(@RequestParam("loginName") String account, @RequestParam("tuId") String id, @RequestParam("auth") String auth) {
        System.out.println("获取token");
        return jwtUtil.sign(account, id, auth);// jwtUtil中存入的userName其实是账号
    }
}
