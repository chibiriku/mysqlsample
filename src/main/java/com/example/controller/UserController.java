package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.UserSearchRequest;
import com.example.entity.User;
import com.example.service.UserService;


@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/list")
	public String displaySearch(Model model) {
		List<User> userlist = userService.findAll();
		model.addAttribute("userlist", userlist);
		model.addAttribute("userSearchRequest", new UserSearchRequest());
		return "user/list";
	}
	
	@PostMapping("/id_search")
	  public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
	    User user = userService.search(userSearchRequest);
	    model.addAttribute("userinfo", user);
	    return "user/search";
	}

}
