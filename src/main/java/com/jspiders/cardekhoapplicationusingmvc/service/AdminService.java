package com.jspiders.cardekhoapplicationusingmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhoapplicationusingmvc.pojo.AdminPojo;
import com.jspiders.cardekhoapplicationusingmvc.repository.AdminRepository;


@Service
public class AdminService {
	@Autowired
	private AdminRepository repository;
	
	public AdminPojo getAdmin() {
     AdminPojo pojo=repository.getAdmin();
		return pojo;
	}

	public AdminPojo createAccountAdmin(String username, String password) {
    AdminPojo pojo=repository.createAccountAdmin(username,password);
		return pojo;
	}

	public AdminPojo login(String username, String password) {
       AdminPojo pojo=repository.login(username,password);
		return pojo;
	}

	
}
