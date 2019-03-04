package com.haoze.admin.service;

import com.haoze.admin.dto.system.FastMenuDTO;
import com.haoze.admin.model.FastMenuEntity;
import com.haoze.common.service.Service;

import java.util.List;
/**
 * @author shenjun
 * @date 2019/02/27
 */
public interface FastMenuServcie extends Service<FastMenuEntity> {

    List<FastMenuEntity> listByUserId(String id);

    void saveFastMenu(FastMenuEntity entity);

    void updateFastMenu(FastMenuEntity entity);

    List<FastMenuEntity> listByQuery(FastMenuDTO entity);

    List<FastMenuDTO> list (String id);
}
