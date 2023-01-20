package com.example.ldyspringboot.domain.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
    // 함수이름 = Mapper.xml id
    void memberRegister(Member member);

    Member findByUsername(String username);

    String idCheck(String username);
}
