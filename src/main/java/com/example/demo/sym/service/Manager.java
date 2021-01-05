package com.example.demo.sym.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Lazy
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private String email, password;
}
/*
create table managers(
   mgr_num int primary key,
   email varchar2(20),
   password varchar2(20)
   )
 */