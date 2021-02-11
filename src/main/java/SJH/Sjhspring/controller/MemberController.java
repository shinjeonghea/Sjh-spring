package SJH.Sjhspring.controller;

import SJH.Sjhspring.domain.Member;
import SJH.Sjhspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    //private final MemberService memberService = new MemberService();
    //이렇게 할 경우, 여러 컨트롤러에서 생성되는 객체가 모두 new라서 따로 생성됨

    private  final MemberService memberService;

    //스프링이 memberService를 가져다가 연결해줌
    @Autowired
    public MemberController(MemberService memberService){

        this.memberService = memberService;
        System.out.println("memberService = "+ memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
