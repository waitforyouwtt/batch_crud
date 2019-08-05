package com.yidiandian.service.impl;

import com.yidiandian.dao.BatchEntityDao;
import com.yidiandian.entity.BatchEntity;
import com.yidiandian.service.BatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/26 18:30
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class BatchServiceImpl implements BatchService {

    @Resource
    BatchEntityDao batchEntityDao;
    /**
     * 批量增加
     *
     * @param entityList
     * @return
     */
    @Override
    public void save(List<BatchEntity> entityList) {
        entityList.stream().forEach(batchEntity -> batchEntity.setCreateTime(LocalDateTime.now()));
        entityList.stream().forEach(batchEntity -> batchEntity.setUpdateTime(LocalDateTime.now()));
        batchEntityDao.batchInsert(entityList);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void delete(List<Integer> ids) {
        batchEntityDao.batchDelete(ids);
    }

    /**
     * 修改
     *
     * @param entityList
     */
    @Override
    public void update(List<BatchEntity> entityList) {
        batchEntityDao.batchUpdate(entityList);
    }

    /**
     * 查询
     *
     * @param entityList
     * @return
     */
    @Override
    public List<BatchEntity> findList(List<BatchEntity> entityList) {
        return batchEntityDao.batchFindList(entityList);
    }

    /**
     * 根据数据进行查询
     *
     * @param ids
     * @return
     */
    @Override
    public List<BatchEntity> findByIds(Integer[] ids) {
        return batchEntityDao.findByIds(ids);
    }
}
