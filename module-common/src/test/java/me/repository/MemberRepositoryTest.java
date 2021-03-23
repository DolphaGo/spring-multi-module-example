package me.repository;

import me.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void add () {
        memberRepository.save(new Member("DolphaGo", "adamdoha@naver.com"));
        Optional<Member> saved = memberRepository.findById(1L);
        assertThat(saved.get().getName()).isEqualTo("DolphaGo");
        assertThat(saved.get().getEmail()).isEqualTo("adamdoha@naver.com");
    }
}