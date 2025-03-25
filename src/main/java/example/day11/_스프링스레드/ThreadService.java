package example.day11._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

// 스프링MVC에서 service임을 스프링 컨테이너에 알림
@Service
public class ThreadService {

    // ↓ 멀티스레드를 적용할 메소드 위에 작성
    @Async
    /** 비동기 = 기본값 */
    public void thread1() {
        String name = UUID.randomUUID().toString();
        for(int index = 0; index < 10; index++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(index + " 작업 스레드 : " + name);
        }
    }

    /** 동기 */
    @Async
    public synchronized void thread2() {
        String name = UUID.randomUUID().toString();
        for(int index = 0; index < 10; index++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(index + " 작업 스레드 : " + name);
        }
    }
    
}
