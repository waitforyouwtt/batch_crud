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

    /**
     * 批量插入
     * @param batchEntities
     * @return
     */
    int batchInsert(@Param("batchEntities") List<BatchEntity> batchEntities);

    /**
     * 批量插入：如果数据库不存在则插入，如果存在则修改，如果数据相同，则不做动作
     * @param batchEntities
     * @return
     */
    int batchInsertForUpdate(@Param("batchEntities") List<BatchEntity> batchEntities);

    /**
     * 批量删除
     * @param ids
     */
    void batchDeleteList(@Param("list") List<Integer> ids);
    /**
     * 批量删除
     * @param ids
     */
    void batchDeleteArray(Integer[] ids);

    /**
     *更新
     *
     */
    void batchUpdate(@Param("batchEntities") List<BatchEntity> batchEntities);

    /**
     * 更新
     * @param ids
     * @param label
     * @param content
     */
    void updates(@Param("list")List<Integer> ids,@Param("label") String label,@Param("content") String content);

    List<BatchEntity> batchFindList(@Param("list") List<BatchEntity> list);

    List<BatchEntity> findByIds(@Param("array") Integer [] ids);

    List<BatchEntity> findEntity(@Param("label")String label,@Param("list")List<String> content);

}
