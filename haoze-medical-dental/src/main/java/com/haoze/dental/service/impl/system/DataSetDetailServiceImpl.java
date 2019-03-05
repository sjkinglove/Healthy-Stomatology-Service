package com.haoze.dental.service.impl.system;

import com.haoze.common.service.AbstractService;
import com.haoze.dental.model.system.DataSetDetailEntity;
import com.haoze.dental.service.system.DataSetDetailService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 数据集明细service实现
 * @author fcx
 * @date 2019年2月19日09:18:32
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DataSetDetailServiceImpl extends AbstractService<DataSetDetailEntity> implements DataSetDetailService {

}
