package com.example.demo.uss.service;

import java.util.List;

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
