package com.yidiandian.dao;

import com.yidiandian.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/2 19:13
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Mapper
public interface SourceTableDao {

    /**
     * 查询商品集合
     * @return
     */
    List<ProductInfo> findList();
    /**
     * 修改表结构，在原来基础上增加一列
     * @param column
     */
    void updateTableColumnToCopy(@Param("column") String column);
    /**
     * 对表重命名
     * @param tableName
     */
    void updateTableNameToCopy(@Param("tableName") String tableName);

    /**
     * 动态创建表
     * @param tableName
     */
    void createTable(@Param("tableName") String tableName);

    /**
     * 批量修改
     * @param ids
     */
    void updateSynchroBatchById(@Param("vos") List<String> ids);
}
