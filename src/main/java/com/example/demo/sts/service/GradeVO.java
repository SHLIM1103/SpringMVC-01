package com.example.demo.sts.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data @Lazy
public class GradeVO { // Big bean 이라고 부르기도 한다.
	// Grade
	private int gradeNum, stuNum, score;
    private String subject, grade, examDate, passExam;
    private int subNum, teaNum;
    // Subject
    private String description;
    // Teacher
    private String teaName, teaPassword, teaProfileImage;
    // Student
	private String userid, stuPassword, stuName, birthday, gender, regDate, stuProfileImage;
}