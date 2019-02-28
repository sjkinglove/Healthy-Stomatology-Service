package com.haoze.dental.controller;

import com.haoze.dental.entity.ClassInfo;
import com.haoze.dental.service.ClassAndSchoolSevice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicalDental")
@Validated
@Api(value = "测试")
public class testController {

    @Autowired
    private ClassAndSchoolSevice cassService;

    @ApiOperation(value = "查询所有", notes = "这里是其他详细说明")
    @PostMapping("/getAllClassAndSchool")
    public List<Map<String,String>> getAllClassAndSchool(){

        return cassService.getAllClassAndSchool();
    }

    @ApiOperation(value = "查询时间", notes = "这里是其他详细说明")
    @PostMapping("/getNowTime")
    public String getNowTime(){
        return cassService.getNowTime();
    }

    @ApiOperation(value = "查询时间", notes = "这里是其他详细说明")
    @PostMapping("/getAllClass")
    public List<ClassInfo> getAllClass(){
        return cassService.getAllClass();
    }

    @ApiOperation(value = "test", notes = "test")
    @GetMapping("test")
    public String test() {
        cassService.test();
        return "ok";
    }

}
