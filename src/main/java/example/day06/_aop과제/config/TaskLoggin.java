package example.day06._aop과제.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

@Aspect
@Component
public class TaskLoggin {
    /*
    @Before("execution(* example.day06._aop과제.service.StudentService.findAll(..))")
    public void beforeGet() {
        System.out.println("메소드 실행 전(before) : 전체 조회");
    }
    @Before("execution(* example.day06._aop과제.service.StudentService.save(java.util.HashMap)) && args(map)")
    public void beforePost(HashMap<String, Object> map) {
        System.out.println("메소드 실행 전(before) : " + map + "값 출력");
    }
    @AfterReturning(value = "execution(* example.day06._aop과제.service.StudentService.*(..))", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("메소드 실행 후(afterReturning) : \n" + result + " 이/가 리턴됨\n");
    }
    @Around("execution(* example.day06._aop과제.service.StudentService.*(..))")
    public Object aroundTime(ProceedingJoinPoint joinPoint) throws Throwable {

        // ProceedingJoinPoint : AOP에서 사용되는 인터페이스
        // 제공하는 메소드
        // 1. .proceed() : 지정한 메소드를 실행하는 메소드

        // 지정한 메소드의 매개변수를 반환(배열타입)
        System.out.println(joinPoint.getArgs());
        // 지정한 메소드의 시그니처를 반환(실행된 메소드의 리턴타입, 함수명, 매개변수)
        System.out.println(joinPoint.getSignature());
        // 지정한 메소드를 실행한 객체(StudentService객체)
        System.out.println(joinPoint.getTarget());
        // 지정한 메소드를 실행한 객체(StudentService객체 + 프록시)
        System.out.println(joinPoint.getThis());

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("메소드가 실행된 시간 : " + time + "초 입니다.\n");
        return result;
    }
    */

    // [*] @Before / @AfterReturning을 사용하지 않고 @Around하나로 표현
    @Around("execution(* example.day06._aop과제.service.StudentService.*(..))")
    public Object studentServiceCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        // * 지정한 함수 시그니처 출력
        System.out.println("[실행메소드] : " + joinPoint.getSignature());

        // 1. 매개변수 출력
        // Arrays.toString(배열변수) : 배열의 출력을 주소값이 아닌 값으로 반환
        System.out.println("[매개변수] : " + Arrays.toString(joinPoint.getArgs()));

        // * 시작 시간
        long startTime = System.currentTimeMillis();

        // * 지정한 함수 실행
        Object result = joinPoint.proceed();

        // * 종료 시간
        long endTime = System.currentTimeMillis();

        // * 걸린 시간
        long time = endTime - startTime;

        // * 시간 출력
        System.out.println("[걸린 시간] : " + time + "밀리초");

        // 2. 반환값 출력
        System.out.println("[반환값] : " + result);

        // * 지정한 함수의 반환값을 그대로 반환
        return result;
    }
}
