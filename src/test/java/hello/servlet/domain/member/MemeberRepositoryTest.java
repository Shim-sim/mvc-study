package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemeberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clear();
    }

    @Test
    void save() {
        //given 이런게 주어졌을 때
        Member member = new Member("hello", 30);

        //when 이런걸 실행했을 때
        Member savedMember = memberRepository.save(member);

        //then 결과가 이러하다.
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findAll() {
        Member member = new Member("hello", 30);
        Member member2 = new Member("hello2", 31);

        memberRepository.save(member);
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(2);
        assertThat(members.contains(member)).isTrue();
    }
}