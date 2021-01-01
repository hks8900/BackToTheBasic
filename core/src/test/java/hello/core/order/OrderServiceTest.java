package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderServiceTest {
	
	AppConfig appConfig = new AppConfig();
	
	MemberService memberService = appConfig.memberService();
	OrderService orderService = appConfig.orderService();
	
	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberQ!", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemmA", 10000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}

}
