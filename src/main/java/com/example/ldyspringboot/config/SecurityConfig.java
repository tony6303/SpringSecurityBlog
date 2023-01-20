package com.example.ldyspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public BCryptPasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/home","member/**").permitAll() // 지정한 경로의 접근은 권한 없어도 허용
                .antMatchers("/hello").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                // .anyRequest().authenticated() // 지정한 경로 이외의 접근은 권한 필요로 설정
                .and()
            .formLogin()
                .loginPage("/loginForm") // 권한이 없는 페이지로 이동하게 되면 loginForm 페이지로 이동하게 함
                .loginProcessingUrl("/login") // 로그인 컨트롤러에 login 을 만들지 않아도 됨, 스프링이 알아서 로그인 체크.
                .defaultSuccessUrl("/home")
                .and()
            .logout()
                .logoutSuccessUrl("/home")
        ;



        return http.build();
    }


}
