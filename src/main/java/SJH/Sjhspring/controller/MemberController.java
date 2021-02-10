package SJH.Sjhspring.controller;

import SJH.Sjhspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //private final MemberService memberService = new MemberService();
    //이렇게 할 경우, 여러 컨트롤러에서 생성되는 객체가 모두 new라서 따로 생성됨

    private  final MemberService memberService;

    //스프링이 memberService를 가져다가 연결해줌
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
