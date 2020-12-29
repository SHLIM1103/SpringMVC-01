package com.example.demo.sym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
	@Autowired TeacherMapper teacherMapper;
	
	public int register(Teacher teacher) {
		return teacherMapper.insert(teacher);
	}

}