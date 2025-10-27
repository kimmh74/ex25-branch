package com.kmh.ex25_branch.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Student {

	private Long id;
	@NotBlank(message = "이름은 필수항목")
	private String name;
	@Email(message = "이메일 형식@ 입력필수")
	private String email;
	@Min(value = 1, message = "나이는 1세 이상")
	private Integer age;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}



//package com.kmh.ex25_branch.domain;
//
//import java.time.LocalDateTime;
//
//import lombok.Data;
//
//@Data
//public class Student {
//
//	private Long id;
//	private String name;
//	private String email;
//	private Integer age;
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;
////	private LocalDateTime created_at;
////	private LocalDateTime updated_at;
//
//}
