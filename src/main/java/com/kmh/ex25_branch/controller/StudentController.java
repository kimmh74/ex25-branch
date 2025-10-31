package com.kmh.ex25_branch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmh.ex25_branch.domain.Student;
import com.kmh.ex25_branch.service.StudentService;

import lombok.RequiredArgsConstructor;




@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;

//	Model : UI를 찾아서 사용 - 중요.화면에 뿌려주기 위해서..
//	화면 list확인 : http://localhost:8080/students
//	list.html의 83라인 students를 학생들을 넣어준다. <<주의>>
	@GetMapping
	public String list(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
//		화면의 경로와 이름을 리턴해야한다.student안에 list를 경로를 넣어준다(templates에서)
		return "student/list";
	}

//	화면 new 등록폼(새학생등록화면 빈화면) : 새로운 학생정보를 입력히기 위한 빈양식 : http://localhost:8080/students/new
//	model.addAttribute => 화면에 보여준다는 의미
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/form";
	}
	
//	등록처리 저장(학생등록->저장) : 학생정보 기록후 저장버튼 클릭을 하면, 학생정보를 insert : 한명의 학생을 등록 처리하기
	@PostMapping
	public String create(@ModelAttribute Student student) {
//		이미 학생 저장이 완료됨.
		studentService.createStudent(student);		
		return "redirect:/students";
	}
	
//	수정하는 양식으로 양식form : list화면에서 수정버튼을 누르면 등록된id 정보가 나오는 화면 수정대기(수정정보를 보여준다) 
//	@PathVariable=>{id}가져오는 용어
//	1명의 정보/ 당권정보 studentService.getStudent(id)를 넣어준다.
//	model.addAttribute => 화면에 보여준다는 의미
//	http://localhost:8080/students/{99}/edit
	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",studentService.getStudent(id));
		return "student/form";
	}
	
//	수정처리
//	저장을 누르면 수정내용이 저장되도록 저장.update시키는 명령어.
//	form.html의 77라인 student를 단수 학생을 @ModelAttribute에 넣어준다.<<주의>>
	@PostMapping("/{id}")
	public String update(@PathVariable Long id,@ModelAttribute Student student) {
		student.setId(id);
		studentService.updeteStudent(student);
		return "redirect:/students";
	}
	
//	삭제처리
//	http://localhost:8080/students/{11}/delete
	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
		studentService.deleteStudent(id);		
		return "redirect:/students";
	}
	
//	읽어보기
//	StudentController.java 는 .....StudentRestController.java를 보면서 비교하면서 적용하기 바랍니다.
	
}
