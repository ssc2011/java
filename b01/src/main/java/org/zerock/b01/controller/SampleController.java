package org.zerock.b01.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello(Model model){
        log.info("hello.......");

        model.addAttribute("msg", "Hello World");
    }

    @GetMapping("/ex/ex1")
    public void ex1(Model model){
        List<String> list = Arrays.asList("AAA","BBB","CCC","DDD");

        model.addAttribute("list", list);

    }

    class SampleDTO{
        private String p1,p2,p3;

        public String getP1() {
            return p1;
        }
        public String getP2() {
            return p2;
        }
        public String getP3() {
            return p3;
        }
    }

    @GetMapping("/ex/ex2")
    public void ex2(Model model){
        log.info("ex/ex2.....");

        // 1부터 9까지의 숫자를 "Data1", "Data2" 등으로 변환하여 리스트로 생성
        List<String> strList = IntStream.range(1,10)
                .mapToObj(i->"Data"+i)
                .collect(Collectors.toList());

        // 리스트를 모델에 추가
        model.addAttribute("list", strList);

        // 맵 생성 및 값 추가
        Map<String,String> map = new HashMap<>();
        map.put("A","AAAA");
        map.put("B","BBBB");

        model.addAttribute("map", map);

        SampleDTO sampleDTO = new SampleDTO();
        sampleDTO.p1 = "Value -- p1";
        sampleDTO.p2 = "Value -- p2";
        sampleDTO.p3 = "Value -- p3";

        model.addAttribute("dto", sampleDTO);
    }

    @GetMapping("/ex/ex3")
    public void ex3(Model model){
        model.addAttribute("arr",new String[]{"AAA","BBB","CCC","DDD"});
    }
}
