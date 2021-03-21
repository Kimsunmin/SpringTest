package com.sun.study.user.model.service;

import com.sun.study.user.model.vo.User;

public interface UserService {
	
	User SelectUserById(String userId);
	
	int insertUser(User user);
	
}
