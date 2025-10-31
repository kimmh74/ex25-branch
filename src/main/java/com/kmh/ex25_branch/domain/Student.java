package com.kmh.ex25_branch.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Student {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private String age;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updateAt;

}
