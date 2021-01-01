package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
	// given

	// when

	// then
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다.")
	void vip_o() {

		// given
		Member member = new Member(1L, "nameVIP", Grade.VIP);
		// when
		int dis = discountPolicy.dicount(member, 10000);
		// then
		assertThat(dis).isEqualTo(1000);
	}

	@Test
	@DisplayName("VIP가 아니면 할인 적용 아님.")
	void vip_X() {
		// given
		Member member = new Member(2L, "nameBASIC", Grade.BASIC);
		// when
		int dis = discountPolicy.dicount(member, 10000);
		// then
		assertThat(dis).isEqualTo(1000);
	}
}
