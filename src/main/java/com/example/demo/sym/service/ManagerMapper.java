package com.example.demo.sym.service;

import org.springframework.stereotype.Service;

@Service
public interface ManagerMapper {
    public int insert(Manager manager);
	public Manager access(Manager manager);
}
