package org.zerock.b01.repository;


import org.zerock.b01.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;
import java.util.stream.IntStream;

//JPA 기능
@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Board board = Board.builder()
                    .title("title..."+i)
                    .content("content..."+i)
                    .writer("user"+(i%10))
                    .build();
            Board result = boardRepository.save(board);
            log.info("BNO: "+result.getBno());
        });
    }

    @Test
    public void testSelect(){
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow(); //조회 결과가 없으면 예외를 던짐
        log.info(board);
    }

    @Test
    public void testUpdate(){ //수정시에 select가 먼저 실행되는데 이유는 같은 id가 존재하는지 먼저 확인하기 때문에
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow(); //조회 결과가 없으면 예외를 던짐
        board.change("update..title 100","update..content 100");
        boardRepository.save(board);
    }

    @Test
    public void testDelete(){ //삭제시에 select가 먼저 실행되는데 이유는 같은 id가 존재하는지 먼저 확인하기 때문에
        Long bno = 1L;
        boardRepository.deleteById(bno);
    }

    @Test
    public void testPaging() {
        //1 page order by bno desc
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> resuLt = boardRepository.findAll(pageable);
    }

    @Test
    public void testSearch1(){
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        boardRepository.search1(pageable);
    }

    @Test
    public void testSearchAll(){
        String[] types={"t","c","w"};
        String keyword="1";
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> result = boardRepository.searchAll(types,keyword,pageable);

        log.info(result.getTotalElements()); //페이지 갯수

        log.info(result.getSize()); //한페이지의 글 갯수

        log.info(result.getNumber()); // 현재 페이지 번호

        log.info(result.hasPrevious()+" : "+result.hasNext()); //이전페이지, 다음페이지 유무

        result.getContent().forEach(board -> log.info(board));
    }
}
