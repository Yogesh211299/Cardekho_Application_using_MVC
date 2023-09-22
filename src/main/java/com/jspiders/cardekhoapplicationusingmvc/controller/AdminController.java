package com.jspiders.cardekhoapplicationusingmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.cardekhoapplicationusingmvc.pojo.AdminPojo;
import com.jspiders.cardekhoapplicationusingmvc.service.AdminService;

import jakarta.servlet.http.HttpSession;
@Controller
public class AdminController {
	@Autowired
	private AdminService service;
	
	
	@GetMapping("/createAccount")
	public String getAdmin(ModelMap map) {
		AdminPojo pojo=service.getAdmin();
		if (pojo == null) {
			return"CreateAccount";			
		}
		map.addAttribute("msg","Account already exists");
	    return "Login";

	}
	
	@PostMapping("/createAccount")
	public String createAccountAdmin(@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPojo pojo=service.createAccountAdmin(username,password);
		if (pojo != null) {
			map.addAttribute("msg","Account Created successfully..!");
			return"Login";
		}
		map.addAttribute("msg","Account not created");
		return "Login";
	}
	
	
	
	
	@PostMapping("/login")
	public String login(HttpSession session,@RequestParam String username,@RequestParam String password,ModelMap map) {
		AdminPojo pojo=service.login(username,password);
		if (pojo != null) {
			session.setAttribute("login", pojo);
			session.setMaxInactiveInterval(100);
			return"Home";
		}
		map.addAttribute("msg","Invalid username and password");
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		session.invalidate();
		map.addAttribute("msg","Logout successfully..!");
		return"Login";
	}
}
