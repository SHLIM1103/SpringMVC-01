package com.example.demo.sts.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.utl.DummyGenerator;

@Service
public class SubjectService {
	@Autowired SubjectMapper subjectMapper;
	@Autowired DummyGenerator dummy;
	
	public void insertMany(int count) {
		var list1 = Arrays.asList("Java", "Spring", "jQuery", "eGovFramework", "Python");
		var list2 = Arrays.asList("Java 언어", "Spring 프레임워크", "jQuery 라이브러리", "전자정부프레임워크", "Python 언어");
		Subject s = null;
		var list = new ArrayList<Subject>();
		for(int i = 0; i < count; i++) {
			s = new Subject();
			s.setSubject(list1.get(i));
			s.setDescription(list2.get(i));
			list.add(s);
		}
		subjectMapper.insertMany(list);
    }
}
