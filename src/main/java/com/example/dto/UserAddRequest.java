package com.example.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserAddRequest implements Serializable {
    
    private String name;
    
    private String address;
    
    private String phone;
}