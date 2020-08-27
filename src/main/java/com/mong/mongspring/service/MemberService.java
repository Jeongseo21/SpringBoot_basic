package com.mong.mongspring.service;

import com.mong.mongspring.domain.Member;
import com.mong.mongspring.repository.MemberRepository;
import com.mong.mongspring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public MemberService(MemberRepository memberRepository) {
    }


    //회원가입
    public Long join(Member member){
        //같은 이름의 중복회원은 X
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName()); //result가 optional로 반환되니까
        result.ifPresent(member1 -> { //ifPresent를 사용할 수 있음. ifPresent == null이 아니면~
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체회원조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //회원아이디로 회원 이름 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
