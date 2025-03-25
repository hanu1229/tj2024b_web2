package example.day11._스프링스레드;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ↓ 스프링MVC에서 rest Controller임을 스프링 컨테이너에 알림
@RestController
// ↓ 공통 Url
@RequestMapping("/day11/thread")
// ↓ final 필드 초기화
@RequiredArgsConstructor
public class ThreadController {

    private final ThreadService threadService;

    /** 비동기 = 기본값 */
    @GetMapping("/start1")
    public void thread1() {
        System.out.println("ThreadController.thread1");
        threadService.thread1();
    }

    /** 동기 */
    @GetMapping("/start2")
    public void thread2() {
        System.out.println("ThreadController.thread2");
        threadService.thread2();
    }

}
