package hello.core.member;

public interface Repository {
	
	void save(Member member);
	
	Member findById(Long memberId);

}
