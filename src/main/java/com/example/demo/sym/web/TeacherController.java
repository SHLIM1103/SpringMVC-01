package com.example.demo.sym.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.sym.service.Teacher;
import com.example.demo.sym.service.TeacherMapper;
import com.example.demo.sym.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired TeacherService teacherService;
	@Autowired TeacherMapper teacherMapper;
	
	@PostMapping("")
	public Messenger register(Teacher teacher){
		logger.info("등록하려는 교강사 정보: " + teacher.toString());
		return (teacherService.register(teacher) == 1) ? Messenger.SUCCESS : Messenger.FAILURE;
	}
	
	@PostMapping("/access")
	public Teacher access(@RequestBody Teacher teacher) {
		return teacherMapper.access(teacher);
	}
	
	@GetMapping("")
	public List<Teacher> list(){
		return teacherService.list();
	}

}