package SJH.Sjhspring;

import SJH.Sjhspring.aop.TimeTraceAop;
import SJH.Sjhspring.repository.MemberRepository;
import SJH.Sjhspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//이건 직접 스프링 빈을 자바로 등록하는 방식
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //private EntityManager em;
    //public SpringConfig(EntityManager em) {
    //     this.em = em;
    //}
    //-------------jpa를 사용하여 하기

    //private DataSource dataSource;

    //@Autowired
    //public SpringConfig(DataSource dataSource){
    //    this.dataSource = dataSource;
    //}

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

    //@Bean
    //public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
        //return new JdbcMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    //}

    //방법1.스프링 빈에 등록하여 aop사용하기
    //@Bean
    // public TimeTraceAop timeTraceAop(){
    //    return new TimeTraceAop();
    //}
}
