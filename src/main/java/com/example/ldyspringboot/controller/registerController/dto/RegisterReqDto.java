package com.example.ldyspringboot.controller.registerController.dto;

import com.example.ldyspringboot.domain.member.Member;
import lombok.Data;

@Data
public class RegisterReqDto {
    private String username;
    private String password;
    private String email;

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }

}
