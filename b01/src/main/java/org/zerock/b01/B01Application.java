package org.zerock.b01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //AuditingEntityListener 를 활성화 시키기 위함. 적용시키면 엔티티가 데이터베이스에 추가되거나 변경될 때 자동으로 시간 값을 지정 가능
public class B01Application {

    public static void main(String[] args) {
        SpringApplication.run(B01Application.class, args);
    }

}
