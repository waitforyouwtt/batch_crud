package com.yidiandian;

import com.google.common.collect.Lists;
import com.yidiandian.entity.Student;
import com.yidiandian.thread.StudentService;
import com.yidiandian.thread.StudentThread;
import com.yidiandian.utils.StringCustomizedUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Student3Test extends BatchCrudApplicationTests{


    @Autowired
    StudentService studentService;

    @Test
    public void threadSaveTest() {
        // 查询所有的学生信息
        List<Student> students = this.getAllStudents();
        List<List<Student>> partition = Lists.partition(students, 1000);
        for (List<Student> lists: partition){
            studentService.batchDeal(lists,1000);
        }
    }



    /**
     * 查询所有的学生信息 ，这里可以换成数据库操作，组装一个list
     * @return
     */
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<Student>();
        for (int i = 1; i <= 500000; i++) {
            Student student = new Student();
            student.setName(StringCustomizedUtils.generateName());
            student.setAge(i);
            student.setSex("女");
            students.add(student);
        }
        return students;
    }
}
