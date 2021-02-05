package SJH.Sjhspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") // '/hello'로 들어올때 여기로 매핑시켜줌
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //hello라는 이름을 가진 html로가라는 뜻
    }
}
