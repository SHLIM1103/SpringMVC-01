package com.example.demo.sym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	@Autowired TeacherMapper teacherMapper;
	
	public int register(Teacher teacher) {
		return teacherMapper.insert(teacher);
	}
	
	public List<Teacher> list(){
		return teacherMapper.selectAll();
	}

}