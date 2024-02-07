package com.example.collectibles;


import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class DemoSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringMvcApplication.class, args);
	}
	
	@Bean
	public Executor asyncExecuter() {
		
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(2);
		threadPoolTaskExecutor.setMaxPoolSize(2);
		threadPoolTaskExecutor.setQueueCapacity(500);
		threadPoolTaskExecutor.setThreadNamePrefix("Spring-Async");
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}

}
