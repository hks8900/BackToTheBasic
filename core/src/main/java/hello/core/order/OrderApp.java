package hello.core.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp {

	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig(); 
//
//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = context.getBean("memberService", MemberService.class);
		OrderService orderService = context.getBean("orderService", OrderService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "member1", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemNameAA", 20000);
		System.out.println("order = " + order);
		System.out.println("order,callu = " + order.calculatePrice());

	}
}
