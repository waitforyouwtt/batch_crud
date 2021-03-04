package com.yidiandian;

import com.yidiandian.entity.Student;
import com.yidiandian.thread.StudentThread;
import com.yidiandian.utils.StringCustomizedUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class StudentTest extends BatchCrudApplicationTests{

    @Test
    public void xx(){

        // 查询所有的学生信息
        List<Student> students = this.getAllStudents();
        // 定义一个临时集合，用于存放学生信息
        List<Student> tempStudents = new ArrayList<Student>();

        for (int i = 0; i < students.size(); i++) {
            tempStudents.add(students.get(i));
            if (i != 0 && i % 500 == 0) {
                this.createThread4ExportStudentInfo(tempStudents, i);
            }
        }
       // this.createThread4ExportStudentInfo(tempStudents, students.size());
    }

    /**
     * 创建线程，导入学生信息
     */
    public void createThread4ExportStudentInfo(List<Student> tempStudents, int i){
        List<Student> students = new ArrayList<Student>();

        for (Student student : tempStudents) {
            students.add(student);
        }

        StudentThread studentThread = new StudentThread(students);
        // 设置线程名称
        studentThread.setName("Thread-" + i);
        // 启动线程
        studentThread.start();

        // 重新生成一个新的临时学生集合。
        tempStudents = new ArrayList<Student>();
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<Student>();

        for (int i = 1; i <= 10000; i++) {
            Student student = new Student();
            student.setName(StringCustomizedUtils.generateName());
            student.setAge(25);
            student.setSex("女");
            students.add(student);
        }
        return students;
    }
}
