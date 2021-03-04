package com.yidiandian;

import com.yidiandian.entity.Student;
import com.yidiandian.thread.IntoTask;
import com.yidiandian.utils.StringCustomizedUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class StudentThreadPoolTest extends BatchCrudApplicationTests{

    // 定义一个临时集合，用于存放学生信息
    static List<Student> tempStudents = new ArrayList<Student>();

    @Test
    public void threadSaveTest() {

        long start = System.currentTimeMillis();
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Student> allStudents = getAllStudents();
        log.info("处理数据总条数：{}",allStudents);
        for (int i = 0; i < 4; i++) {
            pool.execute(new IntoTask(i,allStudents));
        }

        pool.shutdown();

        while(!pool.isTerminated()){
            log.info("等待所有任务完成☆☆☆☆☆☆☆☆☆☆");
        }
        stopwatch.stop();
        log.info("结束时间：{}",(System.currentTimeMillis()-start));
    }



    /**
     * 查询所有的学生信息 ，这里可以换成数据库操作，组装一个list
     * @return
     */
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<Student>();
        for (int i = 1; i <= 6000; i++) {
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
