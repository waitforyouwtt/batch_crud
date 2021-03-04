package com.yidiandian.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private Integer id;
    private String name;
    private String sex;
    private int age;
}
