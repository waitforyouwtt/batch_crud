package com.yidiandian.thread;

import com.yidiandian.dao.StudentDao;
import com.yidiandian.entity.Student;
import com.yidiandian.utils.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Slf4j
public class StudentImpl implements StudentService {

    @Override
    public void batchDeal(List<Student> data, int batchNum) {
        int totalNum = data.size();
        int pageNum = totalNum % batchNum == 0 ? totalNum / batchNum : totalNum / batchNum + 1;
        ExecutorService executor = Executors.newFixedThreadPool(pageNum);
        try {
            CountDownLatch countDownLatch = new CountDownLatch(pageNum);
            List subData = null;
            int fromIndex, toIndex;
            for (int i = 0; i < pageNum; i++) {
                fromIndex = i * batchNum;
                toIndex = Math.min(totalNum, fromIndex + batchNum);
                subData = data.subList(fromIndex, toIndex);
                ImportTask task = new ImportTask(subData, countDownLatch);
                executor.execute(task);
            }
            // 主线程必须在启动其它线程后立即调用CountDownLatch.await()方法，
            // 这样主线程的操作就会在这个方法上阻塞，直到其它线程完成各自的任务。
            // 计数器的值等于0时，主线程就能通过await()方法恢复执行自己的任务。
            countDownLatch.await();
            log.info("数据操作完成!可以在此开始其它业务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池，释放资源
            executor.shutdown();
        }
    }
}


class ImportTask implements Runnable {

    private static StudentDao studentDao = SpringContextHolder.getBean(StudentDao.class);

    private List<Student> list;
    private CountDownLatch countDownLatch;

    public ImportTask(List<Student> data, CountDownLatch countDownLatch) {
        this.list = data;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (null != list) {
            // 业务逻辑，例如批量insert或者update
            for (Student student: list){
                studentDao.insert(student);
            }
        }
        // 发出线程任务完成的信号
        countDownLatch.countDown();
    }
}