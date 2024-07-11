package org.zerock.springex.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//DTO를 VO로 변환하거나 VO를 DTO로 변환하는 작업을 처리하기 위해 ModelMapper를 빈으로 등록
@Configuration // Configuration : 해당 클래스가 빈에 대한 설정을 하는 클래스임을 명시
public class ModelMapperConfig {
    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}
