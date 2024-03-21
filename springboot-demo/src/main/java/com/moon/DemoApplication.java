package com.moon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@MapperScan("com.moon.mapper")
@EnableCaching
@EnableAsync
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		System.out.println("----------------- 程序运行测试见 DemoApplicationTests 类 -----------------");

		SpringApplication.run(DemoApplication.class, args);
	}

}
