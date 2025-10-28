package com.kmh.ex25_branch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmh.ex25_branch.domain.Student;
import com.kmh.ex25_branch.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

//	list화면 : 전체 학생 목록
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());

		return "student/list";

	}

//	form화면 : 새로운 학생 정보를 입력하기위한 빈화면 양식을 보여준다.
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form";
	}

//  저장화면(등록처리) : 학생정보 입력후 저장버튼 클리후 학생정보를 insert 한다.	
	@PostMapping
	public String create(@ModelAttribute Student student) {

//		이미 학생이 저장이 완료되요
		studentService.createStudent(student);
		return "redirect:/students";
	}
	
//	http://localhost:8090/students/id번호:7/edit	
//  수정FORM : 메인화면에서 수정을 누르면 등록화면에 수정내용이 발생
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudent(id));
		return "student/form";
	}
	
	
	
//	수정처리 : 
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, @ModelAttribute Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}



//	http://localhost:8090/students/id번호:7/delete
//	삭제처리:
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

}
