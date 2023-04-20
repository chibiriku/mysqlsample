package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.UserAddRequest;
import com.example.dto.UserSearchRequest;
import com.example.dto.UserUpdateRequest;
import com.example.entity.UserInfo;

@Mapper
public interface UserInfoMapper {
    
	//全検索
    List<UserInfo> findAll();
    
    //詳細データ
    UserInfo findById(Long id);
    
    //検索機能
    List<UserInfo> search(UserSearchRequest user);
    
    //追加
    void save(UserAddRequest userRequest);
    
    //更新
    void update(UserUpdateRequest userUpdateRequest);
    
    //削除
    void delete(Long id);
}