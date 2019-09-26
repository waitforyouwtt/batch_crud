package com.yidiandian.service;

import com.yidiandian.entity.ProductInfo;
import com.yidiandian.view.RequestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/2 19:10
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public interface SourceTableService {
    /**
     * 查询商品集合
     * @return
     */
    List<ProductInfo> findList();
    /**
     * 修改表结构，在原来基础上增加一列
     * @param vo
     */
    void updateTableColumnToCopy(RequestVO vo);

    /**
     * 对表重命名
     * @param vo
     */
    void updateTableNameToCopy(RequestVO vo);

    /**
     * 动态创建表
     * @param vo
     */
    void createTableCopy(RequestVO vo);

    /**
     * 批量修改
     * @param ids
     */
    void updateSynchroBatchById(@Param("vos") List<String> ids);

}
