package example.day11._스프링스케줄링;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// 스프링에서 스케줄을 사용하고 싶으면 '@EnableScheduling'어노테이션을 추가하여 스케줄링 기능 활성화
@EnableScheduling
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
