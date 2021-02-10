package SJH.Sjhspring;

import SJH.Sjhspring.repository.MemberRepository;
import SJH.Sjhspring.repository.MemoryMemberRepository;
import SJH.Sjhspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//이건 직접 스프링 빈을 자바로 등록하는 방식
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
