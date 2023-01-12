package com.example.ldyspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/","/home").permitAll() // 지정한 경로의 접근은 권한 없어도 허용
                .anyRequest().authenticated() // 지정한 경로 이외의 접근은 권한 필요로 설정
                .and()
            .formLogin()
                .loginPage("/login").permitAll() // 권한이 없는 페이지로 이동하게 되면 login 페이지로 이동하게 함
                .and()
                .logout().permitAll();



        return http.build();
    }


}
