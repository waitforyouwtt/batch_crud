package com.yidiandian.service;

import com.yidiandian.entity.BatchEntity;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/1 14:10
 * @Email: 15290810931@163.com
 */
public interface BatchService {

    /**
     * 批量增加
     * @param entityList
     * @return
     */
    void batchInsert(List<BatchEntity> entityList);
    /**
     * 批量增加
     * @param entityList
     * @return
     */
    void batchInsertForUpdate(List<BatchEntity> entityList);


    /**
     * 批量增加优化代码
     * @param batchEntityList
     * @return
     */
    int addBatch(List<BatchEntity> batchEntityList);

    void batchSave(List<BatchEntity> params);

    /**
     * 删除
     */
    void deleteList(List<Integer> idList);
    /**
     * 删除
     */
    void deleteArray(Integer[] ids);

    /**
     * 修改
     */
    void batchUpdate(List<BatchEntity> entityList);

    /**
     * 修改
     */
    void updates(List<BatchEntity> entityList);

    /**
     * 查询
     * @param entityList
     * @return
     */
    List<BatchEntity> findList(List<BatchEntity> entityList);

    /**
     * 根据数据进行查询
     * @param ids
     * @return
     */
    List<BatchEntity> findByIds(Integer [] ids);
}
