package com.haoze.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.special.InsertListMapper;


/**
 * 定制版MyBatis Mapper插件接口
 * 如需其他接口参考官方文档自行添加
 *
 * @author yangyb
 * @date 2018/06/09
 */
@Mapper
public interface MyMapper<T>
        extends
        BaseMapper<T>,
        ConditionMapper<T>,
        IdsMapper<T>,
        InsertListMapper<T> {
}
