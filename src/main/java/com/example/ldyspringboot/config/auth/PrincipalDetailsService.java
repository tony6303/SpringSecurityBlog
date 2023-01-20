package com.example.ldyspringboot.config.auth;

import com.example.ldyspringboot.domain.member.Member;
import com.example.ldyspringboot.domain.member.MemberMapper;
import com.example.ldyspringboot.domain.member.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {
    private final MemberMapper mapper;

    // /login 요청이 오면 스프링에서 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername 함수를 실행 함
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = mapper.findByUsername(username); // member는 현재 서비스에서만 이용되는 도메인이다.
        if(member != null){
            return new PrincipalDetails(member);
        }

        return null;
    }
}
