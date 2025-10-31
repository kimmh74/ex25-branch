package com.kmh.ex25_branch.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	

	
//	#################### 여기부터 #################################
//	전체 조회: GET http://localhost:8080/api/students	
	@GetMapping
	public List<Student> list() {
		return studentService.getAllStudents();
	}
//	단건 조회 : get http://localhost:8080/api/student/id => 요청경로는 getMapping밖에 못쓴다.
	@GetMapping("/{id}")
	public ResponseEntity<Student> detail(@PathVariable Long id) {
		Student student = studentService.getStudent(id);
		return ResponseEntity.ok(student);
	}
//	등록 : POST http://localhost:8080/api/students 포스트맨 POSTMAN 으로 확인
	@PostMapping
	public ResponseEntity<Student> create(@RequestBody Student student) {
		studentService.createStudent(student);		
		return ResponseEntity.ok(student);
	}
//	수정 put작업
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		student.setId(id);
		studentService.updeteStudent(student);
		return ResponseEntity.ok(student);
	}
//	삭제 작업 DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		studentService.deleteStudent(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
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

	

}
