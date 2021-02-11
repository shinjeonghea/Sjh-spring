package SJH.Sjhspring.repository;

import SJH.Sjhspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스 다중상속 가능
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL, select m from Member m where m.name = ?
    //NAME 같은 경우 회사마다 공통적인 이름으로 쓸 수 없기 때문에 옵션에 맞춰 만들어 준다.
    @Override
    Optional<Member> findByName(String name);
}
