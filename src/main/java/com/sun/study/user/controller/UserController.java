package com.sun.study.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.study.user.model.repository.UserRepository;
import com.sun.study.user.model.service.UserService;
import com.sun.study.user.model.service.impl.UserServiceImpl;
import com.sun.study.user.model.vo.User;

@Controller
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("idcheck")
	@ResponseBody
	public String idcheck(String userId) {
		if(userService.SelectUserById(userId) != null) {
			return "fail";
		}else {
			return "ok";
		}
	}
	
	@PostMapping("joinimpl")
	public String joinimpl(@RequestBody User user) {
		System.out.println(user);
		if(userService.insertUser(user) > 0) {
			return "index";
		}else {
			return "join";
		}
	}
	
}
