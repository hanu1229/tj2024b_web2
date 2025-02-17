package example.day01._2REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
    주요 기능 및 어노테이션
        1. @SpringBootConfiguration
            - @Configuration 어노테이션을 포함하며, Spring 컨테이너(메모리)에 bean(객체)의 설정을 등록할 수 있도록 도와주는 어노테이션
        2. @EnableAutoConfiguration
            - Sprint Boot가 자동으로 필요한 bean(객체)를 설정
            - 웹서버인 내장형 "tomcat"을 설정한다.
        3. @ComponentScan
            - 현재클래스를 기준으로 동일한 패키지 및 하위 패키지를 자동으로 스캔한다.
            - 스캔 대상 : Spring컨테이너(메모리)에 등록할 대상 bean(객체)
            - 스캔 어노테이션 : @Component @Controller @ RestController @Service @Repository @Mapper 등등 주로 MVC패턴의 어노테이션
*/
// 1. @SpringBootConfiguration
public class AppStart {
    public static void main(String[] args) {
        // Spring컨테이너(메모리) 초기화
        // 자동 설정이 적용
        // 내장형 웹서버(tomcat) 실행됨
        SpringApplication.run(AppStart.class);
    }
}
