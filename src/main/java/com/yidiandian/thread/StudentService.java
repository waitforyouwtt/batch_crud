package com.yidiandian.thread;

import com.yidiandian.entity.Student;

import java.util.List;

public interface StudentService {
    void batchDeal(List<Student> data, int batchNum);
}
