package com.example.demo.sym.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
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