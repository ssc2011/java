package org.zerock.springex.dto;


import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data //Lombok 라이브러리를 사용해 getter, setter 자동 생성
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;

    @NotEmpty
    private String title;

    @Future //현재보다 미래 날짜로 설정해야함 !!!! 이거때문에 modify 테스트 통과하는데에 엄청 오래걸림
    //수정할 때 미래날짜로 설정해야하는데 과거 날짜로 되어있어서 Valid 유효성 검사에서 계속 통과하지못했음
    private LocalDate dueDate;

    @NotEmpty
    private String writer;

    private boolean finished;
}
