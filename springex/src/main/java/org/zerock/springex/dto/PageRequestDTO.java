package org.zerock.springex.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Arrays;

/*
    페이지 이동 정보 클래스
    클라이언트가 서버에 페이징 요청을 보낼 때 사용
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    private String link;

    @Builder.Default //기본값을 설정하기 위한 Lombok 기능
    @Min(value=1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String[] types; //검색종류
    private String keyword; //제목(t), 작성자(w)
    private boolean finished; //완료 여부
    private LocalDate from; // 기간(시작)
    private LocalDate to; // 기간(끝)

    public int getSkip(){
        return (page - 1) * 10;
    }

    public String getLink(){
        if(link == null){
            StringBuilder builder = new StringBuilder(); //문자열을 효율적으로 생성하기 위함
            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            link = builder.toString(); //StringBuilder에 저장된 내용을 문자열로 변환하고, 이를 link 변수에 저장
        }
        return link;
    }
    
    public boolean checkType(String type) {
        if(types == null||types.length==0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
