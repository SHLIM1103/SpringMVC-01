package com.example.demo.sts.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @Lazy
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private int gradeNum, stuNum, score;
    private String subject, grade, examDate, passExam;

    public Grade(String subject, String examDate, int score) {
    	this.subject = subject;
    	this.examDate = examDate;
    	this.score = score;
    }
}