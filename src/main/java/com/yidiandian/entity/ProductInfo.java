package com.yidiandian.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/2 19:59
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ProductInfo implements Serializable {

    private String productId;
    private String productName;

}
