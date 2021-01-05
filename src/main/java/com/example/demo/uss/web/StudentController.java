package com.example.demo.uss.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.uss.service.Student;
import com.example.demo.uss.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired StudentService studentService;

    @PostMapping("")
    public Map<?,?> register(@RequestBody Student student){
        logger.info("학생등록 정보: " + student.toString());
        var map = new HashMap<>();
        map.put("message", studentService.register(student) == 1 ? "SUCCESS" : "FAILURE");
        return map;
    }
    
    @PostMapping("/login")
    public Map<?,?> login(@RequestBody Student student){
        logger.info("로그인 정보: " + student.toString());
        var map = new HashMap<>();
        map.put("message", (studentService.login(student)!=null) ? "SUCCESS" : "FAILURE");
        map.put("sessionUser", studentService.login(student));
        return map;
    }

    @GetMapping("/{userid}")
    public Student profile(@PathVariable String userid){
        logger.info("프로필 정보: " + userid);
        return studentService.detail(userid);
    }

    @GetMapping("")
    public List<?> list(){
        return studentService.list();
    }

    @PutMapping("")
    public Map<?,?> update(@RequestBody Student student){
        logger.info("수정하려는 학생: " + student.toString());
        var map = new HashMap<>();
        map.put("message", (studentService.update(student) == 1) ? "SUCCESS" : "FAILURE");
        return map;
    }
    
    @DeleteMapping("")
    public Map<?,?> delete(@RequestBody Student student){
        logger.info("삭제하려는 학생: " + student.toString());
        var map = new HashMap<>();
        map.put("message", (studentService.delete(student) == 1) ? "SUCCESS" : "FAILURE");
        return map;
    }
}

