package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
	
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
		Member Member = new Member(1L, "memberA", Grade.VIP);
		
		memberService.join(Member);
		
		Member findMember = memberService.findByMember(1L);
		System.out.println("New Member = " + Member.getName());
		System.out.println("findMember = " + findMember.getName());
		
	}

}
