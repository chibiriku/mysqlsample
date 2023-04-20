package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.UserAddRequest;
import com.example.dto.UserSearchRequest;
import com.example.dto.UserUpdateRequest;
import com.example.entity.UserInfo;
import com.example.service.UserInfoService;



@Controller
@ControllerAdvice
@RequestMapping("/user")
public class UserInfoController {
   
    @Autowired
    private UserInfoService userInfoService;
    
    @GetMapping("/list")
    public String displayList(Model model) {
        List<UserInfo> userList = userInfoService.findAll();
        model.addAttribute("userlist", userList);
        model.addAttribute("userSearchRequest", new UserSearchRequest());
        return "user/search";
    }
    
    @GetMapping("/add")
    public String displayAdd(Model model) {
        model.addAttribute("userAddRequest", new UserAddRequest());
        return "user/add";
    }
    
    @GetMapping("/{id}/edit")
    public String displayEdit(@PathVariable Long id, Model model) {
        UserInfo user = userInfoService.findById(id);
        UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
        userUpdateRequest.setId(user.getId());
        userUpdateRequest.setName(user.getName());
        userUpdateRequest.setPhone(user.getPhone());
        userUpdateRequest.setAddress(user.getAddress());
        model.addAttribute("userUpdateRequest", userUpdateRequest);
        return "user/edit";
    }
   
    @PostMapping("/search")
    public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
        List<UserInfo> userList = userInfoService.search(userSearchRequest);
        model.addAttribute("userlist", userList);
        return "user/search";
    }
   
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        // ユーザー情報の削除
        userInfoService.delete(id);
        return "redirect:/user/list";
    }
    
    @PostMapping("/create")
    public String create(@ModelAttribute UserAddRequest userRequest, Model model) {
       
        // ユーザー情報の登録
        userInfoService.save(userRequest);
        return "redirect:/user/list";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute UserUpdateRequest userUpdateRequest, Model model) {
        // ユーザー情報の更新
        userInfoService.update(userUpdateRequest);
        return "redirect:/user/list";
    }
}