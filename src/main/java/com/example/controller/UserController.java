package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.UserSearchRequest;
import com.example.entity.User;
import com.example.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/user/search")
	public String displaySearch(Model model) {
		model.addAttribute("userSearchRequest", new UserSearchRequest());
		return "user/search";
	}
	
	@RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
	  public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
	    User user = userService.search(userSearchRequest);
	    model.addAttribute("userinfo", user);
	    return "user/search";
	}

}
