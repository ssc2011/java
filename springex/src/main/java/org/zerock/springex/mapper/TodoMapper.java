package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

import java.util.List;


// MyBatis는 XML 파일에 정의된 SQL 쿼리와 인터페이스 메서드를 매핑하여, 인터페이스의 메서드가 호출될 때 적절한 SQL 쿼리를 실행
// ServiceImple 에서 todoMapper.delete()가 호출되면 TodoMapper의 delete가 실행되는 것임
public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO); //페이징 처리 관련

    int getCount(PageRequestDTO pageRequestDTO); // 전체 데이터의 수 구하기
}
