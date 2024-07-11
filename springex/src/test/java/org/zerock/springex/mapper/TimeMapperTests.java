package org.zerock.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.mapper.TimeMapper;
import org.zerock.springex.mapper.TimeMapper2;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {
    @Autowired(required = false) //required : @Service,@Repository와 같이 직접 스프링의 빈으로 등록한 경우가 아니면 경고가 발생하는 것을 방지
    private TimeMapper2 timeMapper2;

    @Test
    public void testGetTime(){
        log.info(timeMapper2.getNow());
    }
}
