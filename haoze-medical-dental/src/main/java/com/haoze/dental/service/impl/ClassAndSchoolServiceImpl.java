package com.haoze.dental.service.impl;

import com.haoze.dental.dao.ClassAndSchoolMapper;
import com.haoze.dental.entity.ClassInfo;
import com.haoze.dental.service.ClassAndSchoolSevice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClassAndSchoolServiceImpl implements ClassAndSchoolSevice {

    @Resource
    private ClassAndSchoolMapper casmDao;

    @Override
    public List<Map<String, String>> getAllClassAndSchool() {
        List<Map<String, Object>> list = casmDao.getAllClassAndSchool();
        List<Map<String, String>> newList = new ArrayList<Map<String, String>>();
        for (Map<String, Object> map : list) {
            Map<String, String> newMap = new HashMap<String, String>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                newMap.put(entry.getKey(), entry.getValue().toString());
            }
            newList.add(newMap);
        }
        return newList;
    }
    @Override
    public String getNowTime(){
        String str=casmDao.getNowTime();
        return str;
    }

    public List<ClassInfo> getAllClass(){
        return casmDao.getAllClass();
    }

    public void test() {
        casmDao.test();
    }
}
