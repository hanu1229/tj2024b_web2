package example.day01._1어노테이션;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

class SuperClass {
    public void method1() {}
}

class SubClass extends SuperClass {

    @Override
    public void method1() {
        super.method1();
    }
    
    // @Deprecated : 더이상 사용하지 않는 코드임을 알림
    @Deprecated
    public void method2() {}
}

// [1] 어노테이션 만들기
// 런타임까지 유지한다는 뜻
@Retention(RetentionPolicy.RUNTIME)
// 해당 어노테이션은 메소드에만 적용 한다는 뜻
@Target(ElementType.METHOD)
@interface Annotation1 {
    String value1();
}
// [2] 어노테이션 사용하기
class TestClass {
    // 실행 중에 주입됨
    @Annotation1(value1="어노테이션(value1)에 값 저장")
    public void method3() {}
}

public class Example1 {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        // 오버라이딩된 메소드
        subClass.method1();
        // 비권장(더이상 사용하지 않는) 메소드
        subClass.method2();

        // [3] 리플렉션된 클래스 정보 확인
        try {
            Method method = TestClass.class.getMethod("method3");
            Annotation1 annotation1= method.getAnnotation(Annotation1.class);
            System.out.println(annotation1.value1());
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
