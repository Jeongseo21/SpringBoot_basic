package com.mong.mongspring.controller;

import com.mong.mongspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //새로 만들지 말고 스프링 컨테이너에 등록하고 쓰자
    private final MemberService memberService;

    //생성자를 만들고 오토와이어드 붙여줌 -> 생성자주입 / 생성할 때 이외에 불필요한 변경을 막아줄 수 있다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
