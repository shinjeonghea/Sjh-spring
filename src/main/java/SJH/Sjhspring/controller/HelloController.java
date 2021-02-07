package SJH.Sjhspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // '/hello'로 들어올때 여기로 매핑시켜줌
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //hello라는 이름을 가진 html로가라는 뜻
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { //외부에서 파라미터를 받는다.
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http 응답 body부분에 데이터를 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; // 이렇게 하면 view가 없다 그냥 그대로 내려감 즉, template을 거치지 않고 여기서 끝냄
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
