package org.zerock.b01.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.QBoard;

import java.util.List;

import static org.zerock.b01.domain.QBoard.board;

public class BoardSearchImpl extends QuerydslRepositorySupport implements  BoardSearch {
    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {

        QBoard qBoard = board; // Q도메인 객체
        JPQLQuery<Board> query = from(qBoard); //select.. from board

        BooleanBuilder booleanBuilder = new BooleanBuilder(); // Querydsl을 이용할 때 or 조건 즉, '()' 가 필요한 상황에 BooleanBuilder 사용
        booleanBuilder.or(board.title.contains("11")); //title like...
        booleanBuilder.or(board.content.contains("11")); //content like...  title 조건와 content 조건이 or 연산됨
        query.where(booleanBuilder);
        query.where(board.bno.gt(0L));

        this.getQuerydsl().applyPagination(pageable, query);
        List<Board> list = query.fetch();
        long count = query.fetchCount();

        return null;
    }

    @Override //제목(t), 내용(c), 작성자(w)로 가정함
    public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {
        QBoard qBoard = QBoard.board;
        JPQLQuery<Board> query = from(qBoard); //select 라고 생각하면 됨??

        if ((types != null && types.length > 0) && keyword !=null){ //검색조건과 키워드가 있다면
            BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

            for(String type:types){ //for 루프를 통해 types 배열의 각 요소를 확인하고, 각 조건에 따라 booleanBuilder에 OR 조건으로 추가
                switch(type){
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder); //최종적으로 query.where(booleanBuilder)를 통해 쿼리에 조건을 추가
        }

        query.where(board.bno.gt(0L)); //bno가 0보다 큰 조건을 추가. 모든 Board 엔티티가 검색되도록 하기 위한 조건

        //paging
        this.getQuerydsl().applyPagination(pageable, query);
        List<Board> list = query.fetch(); //결과 목록을 반환
        long count = query.fetchCount(); //총 결과 수를 반환

        //현재 페이지의 데이터 리스트 (list) , 페이징 정보 (pageable), 전체 데이터 개수 (count) 정보를 포함한 Page객체 생성 후 반환
        return new PageImpl<>(list, pageable, count);
    }
}
