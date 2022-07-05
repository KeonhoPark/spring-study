package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

//스프링과 엮어서 테스트할때 사용
@RunWith(SpringRunner.class)
//스프링부트를 띄운 상태로 테스트할때 사용(없으면 @Autowired 적용 안됨)
@SpringBootTest
//테스트와 함께 붙으면 테스트 완료 후 RollBack
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("Park");

        //when
        Long memberId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(memberId));
        
    }
    
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("park");
        Member member2 = new Member();
        member2.setName("park");

        //when
        memberService.join(member1);
        memberService.join(member2);

        //then
        Assertions.fail("중복 회원 예외 실패");
        
    }
    

}