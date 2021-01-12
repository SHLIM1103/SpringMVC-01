package com.example.demo.cop.bbs.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data @Lazy
@NoArgsConstructor
@AllArgsConstructor
public class Reply extends Article {
    private String replyNum, content, artNum;
}
