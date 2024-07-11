package org.zerock.springex.domain;


import lombok.*;

import java.time.LocalDate;

@Getter //Lombok 라이브러리를 사용해서 getter 자동생성
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private String writer;
    private boolean finished;
}
