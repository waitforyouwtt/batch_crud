package com.yidiandian;

import com.yidiandian.entity.BatchEntity;
import com.yidiandian.service.BatchService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BatchTests extends BatchCrudApplicationTests{

	@Autowired
	BatchService batchService;

	@Test
	public void addBatchTest() {
		List<BatchEntity> entities = Lists.newArrayList();
		BatchEntity batchEntity1 = new BatchEntity();
		batchEntity1.setLabel( "A" );
		batchEntity1.setContent( "A" );
		batchEntity1.setState( 1 );
		BatchEntity batchEntity2 = new BatchEntity();
		batchEntity2.setLabel( "B" );
		batchEntity2.setContent( "B" );
		batchEntity2.setState( 1 );
		BatchEntity batchEntity3 = new BatchEntity();
		batchEntity3.setLabel( "C" );
		batchEntity3.setContent( "C" );
		batchEntity3.setState( 1 );
		BatchEntity batchEntity4 = new BatchEntity();
		batchEntity4.setLabel( "D" );
		batchEntity4.setContent( "D" );
		batchEntity4.setState( 1 );
		BatchEntity batchEntity5 = new BatchEntity();
		batchEntity5.setLabel( "E" );
		batchEntity5.setContent( "E" );
		batchEntity5.setState( 1 );
		entities.add( batchEntity1 );
		entities.add( batchEntity2 );
		entities.add( batchEntity3 );
		entities.add( batchEntity4 );
		entities.add( batchEntity5 );
		batchService.addBatch( entities );
	}

	@Test
	public void batchSaveTest() {
		List<BatchEntity> params = new ArrayList<>();
		for (int i=0;i<100000;i++){
			BatchEntity entity = new BatchEntity();
			entity.setLabel("安书离label...+"+i);
			entity.setContent("安书离content...+"+i);
			entity.setState(1);
			entity.setCreateTime(LocalDateTime.now());
			entity.setUpdateTime(LocalDateTime.now());
			params.add(entity);
		}
		System.out.println("得到的数据大小："+params.size());
		batchService.batchSave(params);
	}

	@Test
	public void deleteTest() {
		/*List ids = Arrays.asList("1","3","4");
		batchService.deleteList(ids);*/
        int i = 13102;
        double result = i % 500;
		System.out.println("结果：{}"+result);
		if(i%500==500){//每500条提交一次防止内存溢出
			System.out.println("Nihao");
		}else{
			System.out.println("wuwuwu");
		}
	}

	@Test
	public void test(){
		int result = 0;
		for (int i = 0; i < 6; i++) {
			System.out.println("+1");
			result ++;
		}
		System.out.println("jieguo :"+result);
	}

}
