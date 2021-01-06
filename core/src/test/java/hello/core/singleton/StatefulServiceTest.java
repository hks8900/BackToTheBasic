package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	void statfulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService service1 = ac.getBean(StatefulService.class);
		StatefulService service2 = ac.getBean(StatefulService.class);
		// Tread1 : 1번 사용자가 10000원 주문
		service1.order("order1", 10000);
		// Tread2 : 2번 사용자가 20000원 주문
		service2.order("order2", 20000);

		// Tread1: 1번 사용자가 주문 금액 조회
		int price = service1.getPrice();

		System.out.println("price = " + price);
		Assertions.assertThat(service1.getPrice()).isEqualTo(20000);
	}

	static class TestConfig {

		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}

}
