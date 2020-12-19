package com.yidiandian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BatchCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchCrudApplication.class, args);
	}

}
