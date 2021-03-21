package com.sun.study.user.model.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sun.study.user.model.vo.User;

@Mapper
public interface UserRepository {
	
	@Select("select * from tb_user where user_id = #{userId}")
	User selectUSerById(String userId);
	
	@Insert("insert into tb_user(user_id,user_pw,user_name) values(#{userId},#{userPw},#{userName})")
	int insertUser(User user);
}
