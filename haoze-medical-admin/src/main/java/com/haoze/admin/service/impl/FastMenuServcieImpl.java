package com.haoze.admin.service.impl;

import com.haoze.admin.model.TFastMenu;
import com.haoze.admin.service.FastMenuServcie;
import com.haoze.common.service.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shenjun
 * @date 2019/02/27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FastMenuServcieImpl extends AbstractService<TFastMenu> implements FastMenuServcie {
}
