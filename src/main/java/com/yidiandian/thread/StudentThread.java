package com.yidiandian.thread;

import com.yidiandian.dao.StudentDao;
import com.yidiandian.entity.Student;
import com.yidiandian.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StudentThread extends Thread{

    private static StudentDao studentDao = SpringContextHolder.getBean(StudentDao.class);

    private List<Student> students = new ArrayList<>();

    public StudentThread(List<Student> students){
        this.students = students;
    }

    @Override
    public void run(){
        log.info("落库总条数：{}",students.size());
        for (Student student : students){
            studentDao.insert(student);
        }
    }
}
