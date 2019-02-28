package com.haoze.dental.service;

import com.haoze.dental.entity.ClassInfo;

import java.util.List;
import java.util.Map;


public interface ClassAndSchoolSevice {

    List<Map<String,String>> getAllClassAndSchool();

    String getNowTime();

    List<ClassInfo> getAllClass();

    void test();
}
