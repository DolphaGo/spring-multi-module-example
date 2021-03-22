package me.controller;

import me.domain.Member;
import me.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private MemberService memberService;

    //TODO : 서비스 모듈 사용할 수 있도록 조치 해보기
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public Member get() {
        return new Member("DolphaGo", "adamdoha@naver.com");
    }

    @GetMapping("/signUp")
    public ResponseEntity<String> signUp() {
        Long id = memberService.signup(new Member("DolphaGo", "adamdoha@naver.com"));
        return ResponseEntity.ok(id + "로 저장되었습니다.");
    }
}