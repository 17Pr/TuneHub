package com.tunehub.project1.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.project1.entity.Users;
import com.tunehub.project1.services.UsersService;

import jakarta.servlet.http.HttpSession;
@Controller
public class UserController {
	@Autowired
	UsersService service;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user)
	 {
		boolean userStatus=service.emailExists(user.getEmail());
		if(userStatus==false)
		{
			service.addUser(user);
			System.out.println("user added");
		}
		else {
			System.out.println("user already exits");
		}
		
		return "home";
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password")String password, HttpSession session)
	{
		if(service.validateUser(email, password)==true)
		{
			String role=service.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				return "adminHome";
			}
			else
			{
				return "customerHome";
			}
		}
		else
		{
			return "login";
		}
		
	}
	
	@GetMapping("/logut")
	public String logut(HttpSession session)
	
	{
		session.invalidate();
		return "login";
	
	}
}



