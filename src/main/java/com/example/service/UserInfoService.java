
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserInfoMapper;
import com.example.dto.UserAddRequest;
import com.example.dto.UserSearchRequest;
import com.example.dto.UserUpdateRequest;
import com.example.entity.UserInfo;

@Service
public class UserInfoService {
    
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }
   
    public UserInfo findById(Long id) {
        return userInfoMapper.findById(id);
    }
    
    public List<UserInfo> search(UserSearchRequest userSearchRequest) {
        return userInfoMapper.search(userSearchRequest);
    }
   
    public void save(UserAddRequest userAddRequest) {
        userInfoMapper.save(userAddRequest);
    }
    
    public void update(UserUpdateRequest userUpdateRequest) {
        userInfoMapper.update(userUpdateRequest);
    }
    
    public void delete(Long id) {
        userInfoMapper.delete(id);
    }
}