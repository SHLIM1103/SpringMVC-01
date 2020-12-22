package com.example.demo.sym.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.sym.service.TeacherService;
import com.example.demo.sym.service.model.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired TeacherService teacherService;
    @PostMapping("")
    public Map<?, ?> register(@RequestBody Teacher teacher) {
        logger.info("등록하려는 교사 정보: " + teacher.toString());
        var map = new HashMap<>();
        map.put("message", (teacherService.register(teacher) == 1) ? "SUCCESS" : "FAILURE");
        return map;
    }
    
    @GetMapping("")
    public List<?> list(){
        return teacherService.list();
    }
    
    @GetMapping("/{name}")
    public Teacher profile(@PathVariable String name){
        logger.info("불러올 교사명: " + name);
        return teacherService.detail(name);
    }
    
    @PutMapping("")
    public Map<?,?> update(@RequestBody Teacher teacher){
        logger.info("수정하는 교사 정보: " + teacher.toString());
        var map = new HashMap<>();
        map.put("message", (teacherService.update(teacher) == 1) ? "SUCCESS" : "FAILURE" );
        return map;
    }
    
    @DeleteMapping("")
    public Map<?,?> delete(@RequestBody Teacher teacher){
        var map = new HashMap<>();
        map.put("message", (teacherService.delete(teacher) == 1) ? "SUCCESS" : "FAILURE" );
        return map;
    }
}
