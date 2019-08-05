package com.yidiandian.dao;

import com.yidiandian.entity.BatchEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/26 18:44
 * @Email: 15290810931@163.com
 */
@Mapper
public interface BatchEntityDao {

    void batchInsert(@Param("batchEntities") List<BatchEntity> batchEntities);

    void batchDelete(@Param("ids") List<Integer> ids);

    void batchUpdate(@Param("batchEntities") List<BatchEntity> batchEntities);

    List<BatchEntity> batchFindList(@Param("list") List<BatchEntity> list);

    List<BatchEntity> findByIds(@Param("array") Integer [] ids);
}
