package com.haoze.dental.dao;


import com.haoze.common.mapper.MyMapper;
import com.haoze.dental.entity.AreaInfo;
import com.haoze.dental.entity.ClassInfo;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ClassAndSchoolMapper extends MyMapper<ClassInfo> {


    List<Map<String,Object>> getAllClassAndSchool();


    String getNowTime();

    List<ClassInfo> getAllClass();

    String test();

}
