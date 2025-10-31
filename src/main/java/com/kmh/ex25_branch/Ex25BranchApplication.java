package com.kmh.ex25_branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Ex25BranchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex25BranchApplication.class, args);
	}

}


// DB연결 전에.. DB차단 하기
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
