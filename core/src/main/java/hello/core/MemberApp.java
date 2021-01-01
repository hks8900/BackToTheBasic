package hello.core;

import hello.core.AppConfig.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
	
	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		
		MemberService memberService = appConfig.memberService();
		
		Member Member = new Member(1L, "memberA", Grade.VIP);
		
		memberService.join(Member);
		
		Member findMember = memberService.findByMember(1L);
		System.out.println("New Member = " + Member.getName());
		System.out.println("findMember = " + findMember.getName());
		
	}

}
