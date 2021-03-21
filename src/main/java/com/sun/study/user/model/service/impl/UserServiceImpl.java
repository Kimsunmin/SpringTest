package com.sun.study.user.model.service.impl;

import org.springframework.stereotype.Service;

import com.sun.study.user.model.repository.UserRepository;
import com.sun.study.user.model.service.UserService;
import com.sun.study.user.model.vo.User;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	// 생성자를 사용해서 의존성을 주입받는다.
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User SelectUserById(String userId) {
		User user = userRepository.selectUSerById(userId);
		return user;
	}

	@Override
	public int insertUser(User user) {
		return userRepository.insertUser(user);
	}

}
