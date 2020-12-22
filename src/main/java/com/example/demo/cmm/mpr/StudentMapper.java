package com.example.demo.cmm.mpr;

import java.util.List;

import com.example.demo.uss.service.model.Student;

import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
	public int insert(Student student);
	public Student login(Student student);
	public Student selectById(String userid);
	public List<Student> selectAll();
	public int update(Student student);
	public int delete(Student student);
}
