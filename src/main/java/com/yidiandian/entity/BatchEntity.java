package com.yidiandian.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/7/26 18:26
 * @Email: 15290810931@163.com
 */
@Data
@Entity
@Table(name ="tb_batch_entity")
public class BatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    private String content;

    private Integer state;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
