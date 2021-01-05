package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("no spring DI container")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		// 1. 조회 호출할때 마다 객체를 생성
		MemberService memberService1 = appConfig.memberService();
		// 2. 조회 호출할때 마다 객체를 생성
		MemberService memberService2 = appConfig.memberService();
		// 3. 참조값이 다른 것을 확인
		System.out.println("memberService1 = " + memberService1);
		System.out.println("memberService2 = " + memberService2);

		// memberService1 =! memberService2
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);

	}

	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
		SingletonService service1 = SingletonService.getInstance();
		SingletonService service2 = SingletonService.getInstance();

		System.out.println("singletonService1 =" + service1);
		System.out.println("singletonService2 =" + service2);
		assertThat(service1).isSameAs(service2);
		
		service1.logic();
	}
}
