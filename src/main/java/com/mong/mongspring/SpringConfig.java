package com.mong.mongspring;

import com.mong.mongspring.repository.MemberRepository;
import com.mong.mongspring.repository.MemoryMemberRepository;
import com.mong.mongspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
