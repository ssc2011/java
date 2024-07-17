package org.zerock.b01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.b01.dto.BoardDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;
import org.zerock.b01.service.BoardService;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) { /* 요청인자로 받은 PageRequestDTO 객체도 model에 담기게 됨. 즉, View에서 사용가능 */
        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO); //페이징된 BoardDTO 리스트와 페이징 정보를 포함한 객체 생성
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO); //화면(View)에서 responseDTO를 사용할 수 있도록 하기 위함
    }
}
