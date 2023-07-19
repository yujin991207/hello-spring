package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// command + shift + t : 새테스트 자동 생성
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    } // MemberService()-end

    /*
    * 회원가입
    * */
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);

        return member.getId();
    } // join()-end

    private void validateDuplicateMember(Member member){
            memberRepository.findByName(member.getName())
                    .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
                    });
        } // validateDuplicateMember()-end

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    } // findMembers()-end

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    } // findOne()-end

} // class-end
