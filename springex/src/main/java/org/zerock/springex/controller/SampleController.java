package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Controller  //component-scan이 패키지를 스캔해서 @Controller 어노테이션이 추가된 클래스들의 객체들을 스프링의 빈으로 설정함
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }

    @GetMapping("/ex1")
    public void ex1(String name,int age){
        log.info("ex1...");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex2") //RequestParam을 사용하면 defaultValue속성을 이용해 기본값을 지정할 수 있음
    public void ex2(@RequestParam(name="name", defaultValue = "AAA") String name,
                    @RequestParam(name="age",defaultValue = "20") int age){
        log.info("ex2...");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex3") //2020-10-10와 같은 문자열을 Date타입으로 변환해야 하기 때문에 Formatter를 이용
    public void ex3(LocalDate dueDate){
        log.info("ex3...");
        log.info("dueDate : " + dueDate);
    }
    @GetMapping("/ex4")
    public void ex4(Model model){
        log.info("-------------");
        model.addAttribute("message", "Hello World");
    }
    @GetMapping("/ex4_1")
    public void ex4_1(TodoDTO todoDTO,Model model){
        log.info(todoDTO);
    }
    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("name","ABC");
        redirectAttributes.addFlashAttribute("result", "success"); // 일회용으로만 사용됨. 새로고침하면 없어짐

        return "redirect:/ex6"; //ex5를 호출하면 서버에서는 다시 ex6경로를 호출함
        // redirect : 리다이렉션을 이용하는 경우
        // forward : 브라우저의 URL 은 고정하고 내부적으로 다른 URL 로 처리하는 경우
    }

    @GetMapping("/ex6")
    public void ex6(){

    }

    @GetMapping("/ex7")
    public void ex7(String p1,int p2){
        log.info("p1......"+p1);
        log.info("p2......"+p2);
    }
}
