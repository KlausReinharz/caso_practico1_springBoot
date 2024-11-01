package com.klaus.dto;

import com.klaus.enums.UserRole;

import lombok.Builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UserDto {
    
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Integer sessionFailed;
    private boolean status;

    private UserRole userRole;



}
