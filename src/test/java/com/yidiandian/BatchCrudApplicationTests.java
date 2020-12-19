package com.yidiandian;

import com.yidiandian.entity.BatchEntity;
import com.yidiandian.service.BatchService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchCrudApplicationTests {

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
	public void deleteTest() {
		List ids = Arrays.asList("1","3","4");
		batchService.deleteList(ids);
	}

}
