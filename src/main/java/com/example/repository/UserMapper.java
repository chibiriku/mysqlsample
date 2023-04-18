package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.UserSearchRequest;
import com.example.entity.User;

@Mapper
public interface UserMapper {
	
	List<User>findAll();
	
	User search(UserSearchRequest user);

}
