package org.zerock.springex.mapper;

/*
    XML과 매퍼 인터페이스를 같이 결합할 때의 과정
    1. 매퍼 인터페이스를 정의하고 메소드를 선언
    2. 해당 XMl 파일을 작성(파일 이름과 매퍼 인터페이스 이름을 같게)하고 <select>와 같은 태그를 이용해서 SQL을 작성
    3. <select>,<insert>등의 태그에 id 속성값을 매퍼 인터페이스의 메소드 이름과 같게 작성
 */
public interface TimeMapper2 {
    String getNow();
}
