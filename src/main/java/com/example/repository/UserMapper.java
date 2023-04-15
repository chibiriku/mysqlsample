package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.UserSearchRequest;
import com.example.entity.User;

@Mapper
public interface UserMapper {
	
	User search(UserSearchRequest user);

}
