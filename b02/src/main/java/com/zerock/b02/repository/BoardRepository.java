package com.zerock.b02.repository;

import com.zerock.b02.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

//인터페이스 선언만으로 데이터베이스 관련작업을 어느정도 처리할 수 있음
//CRUD와 페이징 처리가 모두 완료됨
public interface BoardRepository extends JpaRepository<Board, Long> {

}
