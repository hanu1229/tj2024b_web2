package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// [1] 어노테이션 만들기
// interface타입 앞에 @을 붙인다.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Annotation2 {
    String value1();
    int value2() default 100;
}

// [2] 어노테이션 사용하기
class TestClass2 {
    @Annotation2(value1 = "유재석", value2 = 40)
    // 해당 함수 안에서 value1 = "유재석"과 value2 = 40을 사용이 가능하다
    public void method1() {}

    @Annotation2(value1 = "강호동")
    // 해당 함수 안에서 value1 = "강호동"과 value2 = 100을 사용이 가능하다
    public void method2() {}
}

@Retention(RetentionPolicy.RUNTIME)
// 클래스, 인터페이스, 열거형 타입에 대상을 적용하겠다고 설정
@Target(ElementType.TYPE)
@interface Annotation3 {
    String value1();
    int value2() default 100;
}

@Annotation3(value1 = "유재석", value2 = 40)
// Member 클래스에 어노테이션 주입
class Member {
    
}

public class Example2 {
    public static void main(String[] args) {
        Annotation3 annotation3 = Member.class.getAnnotation(Annotation3.class);
        System.out.println(annotation3.value1());
        System.out.println(annotation3.value2());

    }
}
