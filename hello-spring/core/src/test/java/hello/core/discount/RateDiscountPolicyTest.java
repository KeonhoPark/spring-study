package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP회원은 10프로 할인이 되어야 함")
    void vip_o(){
        //given
        Member VIP_member = new Member(1L, "VIP_member", Grade.VIP);
        //when
        int discountPrice = rateDiscountPolicy.discount(VIP_member, 10000);
        //then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("기본회원은 10프로 할인이 되면 안됨")
    void vip_x(){
        //given
        Member BASIC_member = new Member(2L, "BASIC_member", Grade.BASIC);
        //when
        int discountPrice = rateDiscountPolicy.discount(BASIC_member, 10000);
        //then
        Assertions.assertThat(discountPrice).isEqualTo(1000);
    }

}