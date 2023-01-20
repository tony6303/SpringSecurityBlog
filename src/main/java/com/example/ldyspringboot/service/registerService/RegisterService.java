package com.example.ldyspringboot.service.registerService;

import com.example.ldyspringboot.domain.member.Member;
import com.example.ldyspringboot.domain.member.MemberMapper;
import com.example.ldyspringboot.domain.member.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class RegisterService {
    private final BCryptPasswordEncoder encoder;
    private final MemberMapper mapper;
    @Transactional
    public void memberRegister(Member member){
        String rawPassword = member.getPassword();
        String encPassword = encoder.encode(rawPassword);
        member.setPassword(encPassword);
        member.setRole(RoleType.USER);

        mapper.memberRegister(member);
    }

    public String idCheck(String username){
        return mapper.idCheck(username);
    }


}
