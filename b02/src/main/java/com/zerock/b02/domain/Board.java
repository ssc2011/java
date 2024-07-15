package com.zerock.b02.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터 베이스에 추가될 때 생성되는 번호를 데이터베이스에서 알아서 결정하는 방식
    private Long bno;

    @Column(length=500,nullable = false) //컬럼의 길이와 null 허용여부
    private String title;

    @Column(length=200,nullable = false)
    private String content;

    @Column(length=50,nullable = false)
    private String writer;

    public void change(String title, String content){
        this.title = title;
        this.content = content;
    }
}
