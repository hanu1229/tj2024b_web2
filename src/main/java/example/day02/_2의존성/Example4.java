package example.day02._2의존성;

/*
    [스프링 방식 : IOC와 DI] *권장 방법*
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// [1] 서비스 클래스
@Service
class SampleService4 {
    // @Service안에는 @Component가 포함되어 있음
    void method() {
        System.out.println("SampleService4.method");
    }
}

// [2] 컨트롤러 클래스
class SampleController4 {
    // static : 전역키워드 / final : 수정금지 키워트
    @Autowired
    private final SampleService4 sampleService4;
    public SampleController4(SampleService4 sampleService4) {
        this.sampleService4 = sampleService4;
    }
    public void method() {
        sampleService4.method();
    }
}

public class Example4 {
}
