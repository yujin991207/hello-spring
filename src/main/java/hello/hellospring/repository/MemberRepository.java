package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    /* Optional이란.. 값이 null일때 null을 그냥 반환하기보단
    Optional함수로 감싸서 반환해주는 방법 */
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}