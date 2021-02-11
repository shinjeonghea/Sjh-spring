package SJH.Sjhspring;

import SJH.Sjhspring.repository.JdbcMemberRepository;
import SJH.Sjhspring.repository.MemberRepository;
import SJH.Sjhspring.repository.MemoryMemberRepository;
import SJH.Sjhspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//이건 직접 스프링 빈을 자바로 등록하는 방식
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
       // return new JdbcMemberRepository(dataSource);
        return new JdbcMemberRepository(dataSource);
    }
}
