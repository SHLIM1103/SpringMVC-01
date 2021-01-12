package com.example.demo.cop.bbs.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Lazy
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private String artNum, title, content, count, writerNum;
}
