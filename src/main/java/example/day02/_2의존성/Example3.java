package example.day02._2의존성;

/*
    [스프링 방식 : IOC와 DI]


*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// [1] 서비스 클래스
@Component
class SampleService3 {
    // @Component : 스프링 컨테이너(메모리)에 bean(빈객체(인스턴스))를 등록
    // bean : 스프링 컨테이너(메모리)에서 관리하는 인스턴스/객체 --> IOC라고 함
    // IOC : 제어의 역전 : 개발자가 new로 인스턴스를 생성하지 않고 스프링이 대신 인스턴스를 생성/관리해준다.
    void method() {
        System.out.println("SampleService3.method");
    }
}

// [2] 컨트롤러 클래스
class SampleController {
    // @Autowried : 스프링 컨테이너(메모리)에 등록된 빈(인스턴스)를 주입 --> DI(Dependency Injection)라고 함
    @Autowired
    private SampleService3 sampleService3;
    public void method() {
        sampleService3.method();
    }
}

public class Example3 {
}
