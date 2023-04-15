package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserSearchRequest;
import com.example.entity.User;
import com.example.repository.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public User search(UserSearchRequest userSearchRequest) {
        return userMapper.search(userSearchRequest);
    }

}
