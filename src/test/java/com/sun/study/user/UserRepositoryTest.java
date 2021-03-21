package com.sun.study.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sun.study.user.model.repository.UserRepository;
import com.sun.study.user.model.vo.User;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class UserRepositoryTest {
	
	// 빈에 등록되어있는 userRepository를 자동으로 의존성 주입을 해준다.
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void insertUser() {
		User user = new User();
		user.setUserId("test1");
		user.setUserPw("test1");
		user.setUserName("test1");
		System.out.println(user);
		userRepository.insertUser(user);
	}
	
	@Test
	public void selectUserById() {
		System.out.println(userRepository.selectUSerById("test1"));
	}
}
