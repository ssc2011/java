package org.zerock.b01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zerock.b01.domain.Board;
import org.zerock.b01.dto.BoardDTO;
import org.zerock.b01.dto.PageRequestDTO;
import org.zerock.b01.dto.PageResponseDTO;
import org.zerock.b01.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //스프링이 이 클래스를 빈(bean)으로 등록하여 관리
@Log4j2
@RequiredArgsConstructor // final 필드와 @NonNull 필드를 포함하는 생성자를 자동으로 생성
@Transactional //이 클래스의 메서드가 트랜잭션 내에서 실행되도록 보장
public class BoardServiceImpl implements BoardService {

    private final ModelMapper modelMapper; //DTO와 엔티티 간의 매핑을 도와주는 라이브러리
    private final BoardRepository boardRepository; //Spring Data JPA 레포지토리. 데이터베이스와의 상호작용을 담당

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class); //BoardDTO 객체를 Board 엔티티로 변환
        Long bno = boardRepository.save(board).getBno(); //Board 엔티티를 boardRepository를 통해 데이터베이스에 저장
        return bno;
    }

    @Override
    public BoardDTO readOne(Long bno) {
        Optional<Board> result = boardRepository.findById(bno); //Optional<Board> : 결과가 존재할 수도 있고, 존재하지 않을 수도 있음
        Board board = result.orElseThrow(); //Optional이 비어 있을 경우 NoSuchElementException을 던짐. 그렇지 않으면 Board엔티티 반환
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class); //Board 엔티티를 BoardDTO로 변환
        return boardDTO;
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        Optional<Board> result = boardRepository.findById(boardDTO.getBno());
        Board board = result.orElseThrow();
        board.change(boardDTO.getTitle(),boardDTO.getContent());
        boardRepository.save(board);
    }

    @Override
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno"); // bno 를 기준으로 내림차순 정렬함
        //Pageable 객체는 페이지 번호, 페이지 크기, 정렬 방식을 포함
        Page<Board> result = boardRepository.searchAll(types,keyword,pageable); //조건에 맞는 Board 엔티티 목록을 조회

        List<BoardDTO> dtoList = result.getContent().stream() //조회된 Board 엔티티 목록을 BoardDTO로 변환
                .map(board -> modelMapper.map(board,BoardDTO.class)) //스트림 API를 사용하여 변환된 BoardDTO 객체를 리스트로 수집
                .collect(Collectors.toList());
        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }
}
