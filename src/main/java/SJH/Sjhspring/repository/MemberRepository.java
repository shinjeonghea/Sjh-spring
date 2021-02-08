package SJH.Sjhspring.repository;

import SJH.Sjhspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); //Optional : 자바 8부터 들어가는 기능 , Null로 반환이 될때 Optional이라는 것으로 감싸서 반환하는 방식
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
