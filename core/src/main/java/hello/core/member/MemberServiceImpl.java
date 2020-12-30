package hello.core.member;

public class MemberServiceImpl implements MemberService {
	
	private final Repository memberRepository = new MemoryMemberRepository();

	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
		
	}

	@Override
	public Member findByMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId);
	}

}