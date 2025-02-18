package example.day02._2의존성;

/*
    [고전적인 방법2 : 싱글톤 생성]
    스프링 없이 싱글톤(인스턴스)를 직접 생성하여 메소드를 사용한다.
    싱클톤을 사용한 이유 : 프로그램내 인스턴스가 1개만 필요할 때 사용
    주로 Controller, Dao에서 사용

*/

// [1] 서비스 클래스
class SampleService2 {
    private static SampleService2 instance = new SampleService2();
    private SampleService2() {}
    public static SampleService2 getInstance() { return instance; }

    void method() {
        System.out.println("SampleService2.method");
    }
}

// [2] 컨트롤러 클래스
class SampleController2 {
    SampleService2 sampleService2 = SampleService2.getInstance();
    void method() {
        sampleService2.method();
    }
}

public class Example2 {
}
