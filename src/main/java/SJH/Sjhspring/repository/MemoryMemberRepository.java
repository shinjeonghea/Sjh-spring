package SJH.Sjhspring.repository;

import SJH.Sjhspring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0l; //키값을 생성해 주는 변수
    //원래는 동시성 문제 때문에 다른 걸 쓰는 것이 좋으나
    // 여기는 단순하게 하기에 그냥 쓴다.

    @Override
    public Member save(Member member) { //멤버를 저장
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //Member 객체에 name이 있으면 바로 반환 없으면, Optioanl에 감싸서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){ //스토어 안을 비우는 함수
        store.clear();
    }
}
