package com.yidiandian.thread;

import com.yidiandian.dao.StudentDao;
import com.yidiandian.entity.Student;
import com.yidiandian.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class IntoTask implements Runnable{

    private int index;
    List<Student> students = new ArrayList<Student>();

    private static StudentDao studentDao = SpringContextHolder.getBean(StudentDao.class);

    public IntoTask(int index,List<Student> students) {
        super();
        this.index = index;
        this.students = students;
    }

    @Override
    public void run() {
        for (Student student : students){
            log.info("获取当前线程：{}",Thread.currentThread().getName());
            studentDao.insert(student);
            System.out.println(Thread.currentThread().getName()+"执行了第"+index+"任务");
        }
    }
}
