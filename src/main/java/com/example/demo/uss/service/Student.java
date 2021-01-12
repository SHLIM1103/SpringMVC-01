package com.example.demo.uss.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @Lazy
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int stuNum;
	private String userid, password, name, birthday, gender, regDate, profileImage, subject;
}