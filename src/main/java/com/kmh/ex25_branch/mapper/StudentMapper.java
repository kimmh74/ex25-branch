package com.kmh.ex25_branch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kmh.ex25_branch.domain.Student;

@Mapper
public interface StudentMapper {

//	  <select id="findAll" resultType="Student">
	List<Student> findAll();

//	  <select id="findById" parameterType="long" resultType="Student">
	Student findById(Long id);

//	  <insert id="insert" parameterType="Student" useGeneratedKeys="true" keyProperty="id">
	void insert(Student student);

//	  <update id="update" parameterType="Student">
	void update(Student student);

//	 <delete id="delete" parameterType="long">
	void delete(Long id);

}
