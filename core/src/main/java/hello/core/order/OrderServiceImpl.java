package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
	
	private final MemberRepository repo;
	private final DiscountPolicy discountPolicy ;
	
	public OrderServiceImpl(MemberRepository repo, DiscountPolicy discountPolicy) {
		this.repo = repo;
		this.discountPolicy = discountPolicy;
	}


	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		
		Member member = repo.findById(memberId);
		int discountPrice = discountPolicy.dicount(member, itemPrice);
		
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

}
