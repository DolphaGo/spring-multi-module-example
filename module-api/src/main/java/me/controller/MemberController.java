package me.controller;

import me.controller.dto.MemberRequestDto;
import me.domain.Member;
import me.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public ResponseEntity<String> get() {
        Member member = new Member("DolphaGo", "adamdoha@naver.com");
        Long id = memberService.signup(member);
        return ResponseEntity.ok(id + "번 데이터로 저장되었습니다.");
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody MemberRequestDto memberRequestDto) {
        Long id = memberService.signup(memberRequestDto.toMember());
        return ResponseEntity.ok(id + "번 데이터로 저장되었습니다.");
    }
}