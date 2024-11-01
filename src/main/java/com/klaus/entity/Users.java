package com.klaus.entity;

import com.klaus.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;

    private Integer sessionFailed;

    private Boolean status = true;


    
}
