package org.zerock.springex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.service.TodoService;

import javax.validation.Valid;

    /*
        REST API :
        GetMapping -> Read
        PostMapping -> Create
        PutMapping -> Update
        Delete -> Delete
    */

@Controller
@RequestMapping("/todo") //RequestMapping을 사용하면 여러개의 컨트롤러를 하나의 클래스로 묶을 수 있고 각 기능을 메소드 단위로 설계할 수 있음
@Log4j2
@RequiredArgsConstructor //클래스의 final 필드와 @NonNull 애노테이션이 붙은 필드에 대한 생성자를 자동으로 생성해줍니다
public class TodoController {
    //    @Autowired
    //    public TodoController(TodoService todoService) {
    //        this.todoService = todoService;
    //    }
    //@RequiredArgsConstructor를 사용하지 않고 @Autowired를 사용해도 됨. Required는 Lombok 기능임
    private final TodoService todoService;

//    @RequestMapping("/list")  //최종 경로는 /todo/list
//    public void list(Model model){
//        log.info("todo list...");
//
//        model.addAttribute("dtoList", todoService.getAll());
//    }

    @GetMapping("/list") // list?page=3&size=15 이런식으로 호출함. page와 size는 pageRequestDTO에 담겨지고 getList로 전달
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);

        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        log.info("오류없음 수고 ㅋ");
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    //@RequestMapping(value = "/register" , method= RequestMethod.GET)
    @GetMapping("/register") //브라우저 주소창에 /register 입력했을 때 실행. 페이지를 보여주기 위함
    public void registerGET() {
        log.info("GET todo register...");
    }


    @PostMapping("/register") //폼 데이터를 서버로 제출할 때 실행. register 페이지에서 submit버튼 누르면 실행됨
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes
    ) {
        log.info("POST todo register...");

        if (bindingResult.hasErrors()) {
            log.info("has error....");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO); //컨트롤러에서 뷰로 데이터를 전달. jsp에서 ${tno0} 같이 사용할 수 있음
    }

    @PostMapping("/remove")
    public String remove(Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
        log.info("---------- remove ----------");
        log.info("tno : " + tno);

        todoService.remove(tno); // 실제로는 TodoServiceImpl 객체의 remove 메서드가 호출됨

        //수정 후 목록페이지로 이동할 때 page는 무조건 1페이지로 이동해서 size정보 활용
        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/todo/list";
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        log.info("으아아" + todoDTO);
        if (bindingResult.hasErrors()) {
            log.info("has error..asd..");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify"; //redirectAttribute 에 의해 매개변수를 포함하지 않아도 페이지 이동이 가능함
        }

        todoService.modify(todoDTO);
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        return "redirect:/todo/list";
    }


}
