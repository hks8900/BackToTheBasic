package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig.AppConfig;

public class MemberServiceTest {
	MemberService memberService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}

//	//given
//			Member member = new Member(1L, "memberA", Grade.VIP);
//			
//			
//			//when
//			
//			
//			//then 

	@Test
	void join() {
		// given
		Member member = new Member(1L, "memberA", Grade.VIP);

		// when
		memberService.join(member);
		Member findMember = memberService.findByMember(1L);

		// then
		Assertions.assertThat(member).isEqualTo(findMember);

	}
}
