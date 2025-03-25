package example.day11._스프링스레드;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// ==================== 스프링에 내장된 스레드풀을 커스텀/설정 클래스 ====================
// Spring에서 설정 클래스 빈(객체)를 등록
@Configuration
public class ThreadPoolConfig {

    // ↓ 해당 메소드를 스프링 컨테이너에 빈(객체)를 등록 ↓
    @Bean
    // ↓ [1] 스레드풀 커스텀 메소드 ↓
    public Executor taskExecutor() {
        // ↓ 스레드풀 객체 ↓
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // ↓ 기본 실행 스레드 개수 ↓
        executor.setCorePoolSize(2);
        // ↓ 최대 실행 스레드 개수 설정 ↓
        executor.setMaxPoolSize(2);
        // ↓ 스레드 사용 대기 개수 설정, 대기 상태가 넘치면 503 error ↓
        executor.setQueueCapacity(10);
        // ↓ 스레드 이름 설정 ↓
        // executor.setThreadNamePrefix("");
        // ↓ 스레드풀 초기화 ↓
        executor.initialize();
        // ↓ 설정한 스레드풀 객체 반환 ↓
        return executor;
    }

}
