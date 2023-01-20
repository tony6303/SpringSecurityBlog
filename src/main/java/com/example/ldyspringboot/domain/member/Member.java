package com.example.ldyspringboot.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Timestamp createDate;
    private RoleType role;
}
