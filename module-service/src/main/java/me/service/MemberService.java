package me.service;

import me.domain.Member;
import me.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long signup(Member member) {
        return memberRepository.save(member).getId();
    }
}