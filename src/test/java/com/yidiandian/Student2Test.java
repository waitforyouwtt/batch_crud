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
public class Student2Test extends BatchCrudApplicationTests{

    // 定义一个临时集合，用于存放学生信息
    static List<Student> tempStudents = new ArrayList<Student>();

    @Test
    public void threadSaveTest() {
        // 查询所有的学生信息
        List<Student> students = this.getAllStudents();
        int avg = 1000;//设置每份多少个
        List<List<Student>> lists=averageAssign(students, avg);

        for (int i = 0; i < lists.size(); i++) {
            this.createThread4ExportStudentInfo(lists.get(i), i);
        }
    }

    /**
     * 创建线程，导入学生信息
     *
     * @param tempStudents
     * 每个线程，需要导入的学生信息的数量
     * @param i
     */
    public void createThread4ExportStudentInfo(List<Student> tempStudents, int i) {

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

    /**
     * 将一个list均分成n个list,主要通过偏移量来实现的
     * avg表示每个list里面的元素个数
     * @param source
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> source,int avg){
        int n = (int)Math.ceil((double)source.size()/avg);
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n;  //(先计算出余数)
        int number=source.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }
}
