package example.day06.aop;

// ========================= AOP없이 구현된 코드 ========================= //
class TestService {
    /** 메소드 1 */
    public void enter1() {
        // 부가기능
        System.out.println("[코로나] 온도 체크");
        // 비지니스 로직
        System.out.println("식당 입장");
    }
    /** 메소드 2 */
    public void enter2() {
        // 부가기능
        System.out.println("[코로나] 온도 체크");
        // 비지니스 로직
        System.out.println("학원 입장");
    }
}
// ========================= AOP없이 구현된 코드 ========================= //

public class Example1 {
    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.enter1();
        testService.enter2();
        // 단점 : 유지보수가 복잡하다. 하나으 ㅣ메소드에서 부가기능이 바뀌면 다른 메소드에서도 수정해야한다.
    }
}
