package com.kmh.ex25_branch.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kmh.ex25_branch.domain.Student;
import com.kmh.ex25_branch.service.StudentService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {
	
	private final StudentService studentService;
	
//	@GetMapping
//	public String list() {
//		return studentService.getMyString();
//	}
	
//	@GetMapping
//	public Integer list() {
//		return studentService.getMyInteger();
//	}
	
//	@GetMapping
//	public MyStudent myStudent() {
//		return studentService.getStudent();
//	}

	
//	#################### 여기부터 #################################
//	전체 조회: GET http://localhost:8080/api/students	
	@GetMapping
	public List<Student> list() {
		return studentService.getAllStudents();
	}
	
	

}
