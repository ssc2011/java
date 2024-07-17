package org.zerock.b01.domain;

import javax.persistence.*;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //JPA 엔티티 클래스의 공통적인 매핑 정보를 제공하는 슈퍼클래스임을 나타냄
@EntityListeners(value = {AuditingEntityListener.class}) //자동으로 날짜를 기록해 주는 기능 제공
@Getter
abstract public class BaseEntity {
    @CreatedDate //엔티티가 처음 생성될 때의 날짜를 자동으로 기록
    @Column(name="regdate",updatable = false) //한 번 설정되면 이후에는 수정되지 않음
    private LocalDateTime regdate; //엔티티가 생성된 날짜와 시간을 저장

    @LastModifiedDate //엔티티가 마지막으로 수정된 날짜를 자동으로 기록
    @Column(name="moddate") //엔티티가 수정될 때마다 이 필드는 업데이트 됨
    private LocalDateTime moddate; //엔티티가 마지막으로 수정된 날짜와 시간을 저장
}
