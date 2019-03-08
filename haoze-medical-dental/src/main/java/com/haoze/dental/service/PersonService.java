package com.haoze.dental.service;

import com.haoze.common.service.Service;
import com.haoze.dental.dto.PersonDTO;
import com.haoze.dental.model.PersonEntity;

import java.util.List;

/**
 * @author shenjun
 * @date 2019/3/5
 */
public interface PersonService extends Service<PersonEntity> {

    List<PersonEntity> getListByQuery(PersonDTO entity);
}
