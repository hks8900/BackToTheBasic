package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.Repository;

public class OrderServiceImpl implements OrderService{
	
	private final Repository repo = new MemoryMemberRepository();
	
	private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		
		Member member = repo.findById(memberId);
		int discountPrice = discountPolicy.dicount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
