package com.example.demo.sym.service.impl;

import java.util.List;

import com.example.demo.cmm.mpr.TeacherMapper;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.sym.service.model.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int register(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public List<?> list() {
        return teacherMapper.selectAll();
    }

    @Override
    public Teacher detail(String name) {
        return teacherMapper.selectByName(name);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int delete(Teacher teacher) {
        return teacherMapper.delete(teacher);
    }

}
