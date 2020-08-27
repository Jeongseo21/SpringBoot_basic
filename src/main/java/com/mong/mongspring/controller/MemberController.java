package com.mong.mongspring.controller;

import com.mong.mongspring.domain.Member;
import com.mong.mongspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //새로 만들지 말고 스프링 컨테이너에 등록하고 쓰자
    private final MemberService memberService;

    //생성자를 만들고 오토와이어드 붙여줌 -> 생성자주입 / 생성할 때 이외에 불필요한 변경을 막아줄 수 있다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/new")
    public String createdForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/member/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/membersList";
    }
}
