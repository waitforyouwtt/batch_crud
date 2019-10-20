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
    void save(List<BatchEntity> entityList);

    /**
     * 批量增加优化代码
     * @param batchEntityList
     * @return
     */
    int addBatch(List<BatchEntity> batchEntityList);
    /**
     * 删除
     */
    void delete(List<Integer> ids);
    /**
     * 修改
     */
    void update(List<BatchEntity> entityList);
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
