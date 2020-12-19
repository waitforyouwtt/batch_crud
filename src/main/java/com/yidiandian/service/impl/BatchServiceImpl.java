package com.yidiandian.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.yidiandian.dao.BatchEntityDao;
import com.yidiandian.entity.BatchEntity;
import com.yidiandian.service.BatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
     * @param entityList
     * @return
     */
    @Override
    public void batchInsert(List<BatchEntity> entityList) {
        log.info("批量插入请求参数:{}",JSON.toJSONString(entityList));
        entityList.stream().forEach(entity ->{
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
        });
        batchEntityDao.batchInsert(entityList);
    }

    /**
     * 批量增加
     * @param entityList
     * @return
     */
    @Override
    public void batchInsertForUpdate(List<BatchEntity> entityList) {
        log.info("批量插入请求参数:{}",JSON.toJSONString(entityList));
        entityList.stream().forEach(entity ->{
            entity.setCreateTime(LocalDateTime.now());
            entity.setUpdateTime(LocalDateTime.now());
        });
        batchEntityDao.batchInsertForUpdate(entityList);
    }

    /**
     * 批量增加优化代码
     *
     * @param batchEntityList
     * @return
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public int addBatch(List<BatchEntity> batchEntityList) {
        int result  = 0;
        List<List<BatchEntity>> batchEntirys = Lists.partition(batchEntityList,3);
        for (List<BatchEntity> entities : batchEntirys){
            log.info( "批量插入的参数：{}", JSON.toJSON( entities ) );
            result += batchEntityDao.batchInsert( entities );
            log.info( "批量插入的结果：{}",JSON.toJSON( result ) );
        }
        log.info( "return 之前的result：{}",result );
        return result;
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void deleteList(List<Integer> ids) {
        batchEntityDao.batchDeleteList(ids);
    }
    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void deleteArray(Integer[] ids) {
        batchEntityDao.batchDeleteArray(ids);
    }

    /**
     * 修改
     *
     * @param entityList
     */
    @Override
    public void batchUpdate(List<BatchEntity> entityList) {
        batchEntityDao.batchUpdate(entityList);
    }

    /**
     * 修改
     *
     * @param entityList
     */
    @Override
    public void updates(List<BatchEntity> entityList) {
        List<Integer> ids = entityList.stream().map(BatchEntity::getId).collect(Collectors.toList());
        String content = entityList.get(0).getContent();
        String label = entityList.get(0).getLabel();
        batchEntityDao.updates(ids,content,label);
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
