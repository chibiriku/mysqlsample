package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserUpdateRequest;
import com.example.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class RestUserInfoController {
	
	@Autowired
	private UserInfoService userService;
	
	@PutMapping("/update")
	public int update(UserUpdateRequest userUpdateRequest) {
		userService.update(userUpdateRequest);
		return 0;
	}
}
