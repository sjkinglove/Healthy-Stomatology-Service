package com.haoze.admin.service;

import com.haoze.admin.model.FastMenuEntity;
import com.haoze.common.service.Service;

import java.util.List;

public interface FastMenuServcie extends Service<FastMenuEntity> {

    List<FastMenuEntity> listByUserId(String id);

    void saveFastMenu(FastMenuEntity entity);

    List<FastMenuEntity> selectMenuByUserRole(String account);

    int countFastMenuByUserId(String userId);
}
