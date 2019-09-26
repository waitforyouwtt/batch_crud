package com.yidiandian.service.impl;

import com.yidiandian.dao.SourceTableDao;
import com.yidiandian.entity.ProductInfo;
import com.yidiandian.service.SourceTableService;
import com.yidiandian.view.RequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/2 19:11
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Service
@Slf4j
public class SourceTableServiceImpl implements SourceTableService {

    @Autowired
    SourceTableDao sourceTableDao;

    /**
     * 查询商品集合
     * @return
     */
    @Override
    public List<ProductInfo> findList() {
        return sourceTableDao.findList();
    }

    /**
     * 修改表结构，在原来基础上增加一列
     * @param vo
     */
    @Override
    public void updateTableColumnToCopy(RequestVO vo) {
        String column = "address";
        log.info( "增加列为:{}",column );
        sourceTableDao.updateTableColumnToCopy( column );
    }

    /**
     * 对表重命名
     * @param vo
     */
    @Override
    public void updateTableNameToCopy(RequestVO vo){
        String tableName = "product_info"+"_copy";
        log.info( "表名字：{}",tableName );
        sourceTableDao.updateTableNameToCopy(tableName);
    }

    /**
     * 动态创建表
     * @param vo
     */
    @Override
    public void createTableCopy(RequestVO vo) {
        String tableName = getNow()+"_"+"product_info"+"_copy";
        log.info( "表名字：{}",tableName );
        sourceTableDao.createTable(tableName);
    }

    /**
     * 批量修改
     * @param ids
     */
    @Override
    public void updateSynchroBatchById(List<String> ids) {
        sourceTableDao.updateSynchroBatchById(ids);
    }

    private String getNow(){
        return new SimpleDateFormat("YYYY_MM_dd").format(new Date());
    }
}
