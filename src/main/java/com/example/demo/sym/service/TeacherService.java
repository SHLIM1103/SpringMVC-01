package com.example.demo.sym.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.utl.DummyGenerator;

@Service
public class TeacherService {
	@Autowired TeacherMapper teacherMapper;
	@Autowired DummyGenerator dummy;
	
    public void insertMany(int count) {
		var list = Arrays.asList("Java", "Spring", "jQuery", "eGovFramework", "Python");
		var tlist = new ArrayList<Teacher>();
		Teacher t = null;
		for(int i = 0; i < list.size(); i++) {
			t = dummy.makeTeacher();
			t.setSubject(list.get(i));
			tlist.add(t);
		}
		teacherMapper.insertMany(tlist);
    }
}