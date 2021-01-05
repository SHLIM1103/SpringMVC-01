package com.example.demo.uss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class StudentService {
	@Autowired StudentMapper studentMapper;
	public int register(Student student) {
		return studentMapper.insert(student);
	}
	public Student login(Student student) {
		return studentMapper.login(student);
	}
	public Student detail(String userid) {
		return studentMapper.selectById(userid);
	}
	public List<Student> list(){
		return studentMapper.selectAll();
	}
	public int update(Student student) {
		return studentMapper.update(student);
	}
	public int delete(Student student) {
		return studentMapper.delete(student);
	}
}