package com.example.demo.uss.service.impl;

import java.util.List;

import com.example.demo.cmm.mpr.StudentMapper;
import com.example.demo.uss.service.StudentService;
import com.example.demo.uss.service.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired StudentMapper studentMapper;
    @Override
    public int register(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public Student login(Student student) {
        return studentMapper.login(student);
    }

    @Override
    public Student detail(String userid) {
        return studentMapper.selectById(userid);
    }

    @Override
    public List<Student> list() {
        return studentMapper.selectAll();
    }

    @Override
    public int update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public int delete(Student student) {
        return studentMapper.delete(student);
    }

}
