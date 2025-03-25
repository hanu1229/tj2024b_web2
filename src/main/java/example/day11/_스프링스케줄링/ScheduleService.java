package example.day11._스프링스케줄링;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ScheduleService {
    
    // 스케줄링을 적용할 메소드 위에 '@Scheduled(패턴)'을 작성
    // ↓ [1] 3초마다 스케줄 실행
    @Scheduled(fixedRate = 3000)
    public void task1() {
        System.out.println("TASK1 작동 : " + LocalTime.now());
    }

    // ↓ [2] 5초마다 스케줄 실행
    @Scheduled(fixedDelay = 5000)
    public void task2() {
        System.out.println("TASK2 작동 : " + LocalTime.now());
    }

    // ↓ [3] 5초마다 스케줄 실행
    @Scheduled(cron = "*/5 * * * * *")
    public void task3() {
        System.out.println("TASK3 작동 : " + LocalTime.now());
    }

}
