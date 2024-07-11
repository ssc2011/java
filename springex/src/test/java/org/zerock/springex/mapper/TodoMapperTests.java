package org.zerock.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {
    @Autowired(required=false)
    private TodoMapper todomapper;

    @Test
    public void testGetTime() {
        log.info(todomapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.of(2022,10,10))
                .writer("user00")
                .build();
        todomapper.insert(todoVO);
    }

    @Test
    public void testSelectAll(){
        List<TodoVO> voList = todomapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne(){
        TodoVO todoVO = todomapper.selectOne(3L);
        log.info(todoVO);
    }

    @Test
    public void testSelectList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        List<TodoVO> voList = todomapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectSearch(){ // 검색 필터 테스트
        //select * from tbl_todo ? ? order by tno desc limit ?,?  이렇게 만들어짐
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"})
                .keyword("AAAA")
//                .finished(true)
                .from(LocalDate.of(2021,12,1))
                .to(LocalDate.of(2024,11, 1))
                .build();

        List<TodoVO> voList = todomapper.selectList(pageRequestDTO);
        voList.forEach(vo -> log.info(vo));
        log.info(todomapper.getCount(pageRequestDTO));
    }
}
