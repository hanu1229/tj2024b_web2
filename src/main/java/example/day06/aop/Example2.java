package example.day06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// ========================= AOP로 구현된 코드 ========================= //
@Aspect
@Component
class Security {
    // [1]
    // 지정한 메소드가 실행되기 전에 아래 함수가 실행이 된다.
    // 지정한 메소드는 'TestService2'클래스의 *(모든메소드)이면서 (..)모든매개변수타입 *(모든리턴타입)
    // 즉] 'TestService2'의 모든 메소드들은 실행 되기전에 'securityCheck()'메소드가 자동으로 실행된다.
    @Before("execution(* TestService2.*(..))")
    public void securityCheck() {
        System.out.println("메소드 실행 전(before) : (보안) [코로나] 온도 체크 + 작아진당");
    }

    // [2]
    // 지정한 메소드가 실행 후에 아래 메소드가 실행된다.
    // 지정한 메소드는 'TestService2'클래스의 'enter1'(특정메소드)이면서 (..)모든매개변수타입, *(모든리턴타입)
    // 즉] 'TestService2'의 'enter1'메소드가 실행된 후에 'securityCheck2()'메소드가 *자동*으로 실행된다.
    @After("execution(* example.day06.aop.TestService2.enter1(..))")
    public void securityCheck2() {
        System.out.println("메소드 실행 후(after) : 메소드 실행 종료");
    }

    // [3]
    // 지정한 메소드에서 name 매개변수를 가지고와서 아래 메소드에서 사용이 가능하다.
    // 매개변수를 가져오는 이유 : 로그처리, 보안검사, 트랜잭션 등을 하기 위해서
    @Before("execution(* example.day06.aop.TestService2.enter3(..)) && args(name)")
    public void securityCheck3(String name) {
        System.out.println("메소드 실행 전(before) : " + name + "님 코로나 검사 완료");
    }

    // [4]
    // 지정한 메소드가 정상적으로 실행 되었을때 result리턴값을 가지고 와서 아래 메소드에서 사용이 가능하다.
    // 리턴값을 가져오는 이유 : 로그처리, 보안검사, 트랜잭션 등을 하기 위해서
    @AfterReturning(value = "execution(* example.day06.aop.TestService2.enter3(..))", returning = "result")
    public void securityCheck4(Object result) {
        System.out.println("메소드 실행 후(after) : " + result + "의 결과값 정상");
    }

    // [5] 메소드 실행 시간 체크
    @Around("execution(* example.day06.aop.TestService2.enter3(..))")
    public Object timeCheck5(ProceedingJoinPoint joinPoint) throws Throwable {
        // ProceedingJointPoint : 지정한 메소드와 그외 로직과 조합해서 구현
        // 추가 로직에서 직접 지정한 메소드 호출 : Object result = joinPoint.proceed();
        // 1. 시작 시간
        // System.currentTimeMillis() : 현재 시간을 밀리초(1/1000초)를 반환
        long startTime = System.currentTimeMillis();

        // * 지정된 메소드("enter3")를 실행
        Object result = joinPoint.proceed();

        // 2. 끝나는 시간
        // System.currentTimeMillis() : 현재 시간을 밀리초(1/1000초)를 반환
        long endTime = System.currentTimeMillis();

        // 3. 지정된 메소드가 실행되었을때 걸린시간 계산
        long timeMs = endTime - startTime;

        // 4. 걸린 시간 출력
        System.out.println("enter3 메소드가 실행된 시간 : " + timeMs + "ms");

        return result;
    }

}

@Service
class TestService2 {
    /** 메소드 1 */
    public void enter1() {
        /* 일반적인 방법
            new Security().securityCheck();
        */
        // 부가적인 기능을 제외한 상태
        // 비지니스 로직
        System.out.println("식당 입장");
    }
    /** 메소드 2 */
    public void enter2() {
        /* 일반적인 방법
            new Security().securityCheck();
        */
        // 부가적인 기능을 제외한 상태
        // 비지니스 로직
        System.out.println("학원 입장");
    }
    /** 메소드 3 */
    public boolean enter3(String name) {
        // 비지니스 로직
        System.out.println(name + "님, 헬스장 입장");
        return true;
    }
}

@RestController
class TestControlle2 {
    @Autowired
    private TestService2 testService2;
    @GetMapping("/day06/aop")
    public void aop() {
        testService2.enter1();
        testService2.enter2();
        testService2.enter3("강호동");
    }
}
// ========================= AOP로 구현된 코드 ========================= //

@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run(Example2.class);
    }
}
