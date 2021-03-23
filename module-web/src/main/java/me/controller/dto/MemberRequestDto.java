package me.controller.dto;

import lombok.*;
import me.domain.Member;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {
    private String name;
    private String email;

    @Builder
    public MemberRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Member toMember() {
        return new Member(this.name, this.email);
    }
}
