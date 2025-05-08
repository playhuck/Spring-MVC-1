package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {

        Member member = new Member("hello", 20);

        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertEquals(member, findMember);
    }

    @Test
    void findAll() {

        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello2", 30);

        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();

        Assertions.assertEquals(2, members.size());
        assertThat(members).contains(savedMember1, savedMember2);

    }

}