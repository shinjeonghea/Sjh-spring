package SJH.Sjhspring.service;

import SJH.Sjhspring.domain.Member;
import SJH.Sjhspring.repository.MemberRepository;
import SJH.Sjhspring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

    //원래//private final MemberRepository memberRepository = new MemoryMemberRepository();

    //이후// 이렇게 해서 test에서 인스턴스를 새로 생성하지 않고 여기에 값을 가져오게 한다.
    private  final  MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
    회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복회원은 안됨
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw  new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /**
     * 전체 회원 조회
     **/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
