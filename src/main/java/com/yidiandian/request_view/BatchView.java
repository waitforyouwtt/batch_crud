package com.yidiandian.request_view;

import lombok.Data;

import java.util.List;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/8/1 16:11
 * @Email: 15290810931@163.com
 */

@Data
public class BatchView {
    //批量删除参数化
    private List<Integer> idList;
    //利用数据进行查询
    private Integer [] idArray;
}
