package com.yidiandian;

import com.yidiandian.service.BatchService;
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
	public void deleteTest() {
		List ids = Arrays.asList("1","3","4");
		batchService.delete(ids);

	}

}
