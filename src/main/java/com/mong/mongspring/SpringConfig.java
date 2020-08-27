package com.mong.mongspring;

import com.mong.mongspring.repository.JdbcTemplateMemberRepository;
import com.mong.mongspring.repository.MemberRepository;
import com.mong.mongspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


public class SpringConfig {

    private final MemberRepository memberRepository;
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(MemberRepository memberRepository, DataSource dataSource){
        this.memberRepository = memberRepository;
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JdbcTemplateMemberRepository(dataSource);
    }




}
