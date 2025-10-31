package com.kmh.ex25_branch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kmh.ex25_branch.domain.Student;
import com.kmh.ex25_branch.mapper.StudentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

//	public String getMyString() {
//		
//		return "test 테스트";
//	}
//
//	public Integer getMyInteger() {
//		return 99999;
//	}
//
//	public MyStudent getStudent() {
//// java방식
//		MyStudent myStudent = new MyStudent();
//		myStudent.setName("홍길동");
//		myStudent.setAge(10);		
//		return myStudent;
//	}
//
//	public String getStudentName() {
//		MyStudent myStudent2 = new MyStudent();
//		myStudent2.setName("일지매222");
//		myStudent2.setAge(20);
//		return myStudent2.getName();
//	}
	
	private final StudentMapper studentMapper;
	
	public List<Student> getAllStudents(){
		return studentMapper.findAll();
	}
	
	public Student getStudent(Long id) {
		return studentMapper.findById(id);
	}
	
	@Transactional
	public void createStudent(Student student) {
		studentMapper.insert(student);
	}
	
	@Transactional
	public void updeteStudent(Student student) {
		studentMapper.update(student);
	}
	
	@Transactional
	public void deleteStudent(Long id ) {
		studentMapper.delete(id);
	}


	
}
