package example.day10._멀티스레드;

// User1 클래스
class User1 extends Thread {
    public Calculator calculator;
    @Override
    public void run() {
        calculator.setMemory(100);
    }
}

// User2 클래스
class User2 extends Thread {
    public Calculator calculator;
    @Override
    public void run() {
        calculator.setMemory(200);
    }
}

// Calculator 클래스
class Calculator {
    public int memory;
    /*
    // 비동기
    public void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(this.memory);
    }
    */
    // 동기 방법1 (반환 타입 앞에 synchronized)
    /*
    public synchronized void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(this.memory);
    }
    */
    // 동기 방법2 (함수 안에 synchronized(this) {실행할 코드})
    public void setMemory(int memory) {
        synchronized (this) {
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(this.memory);
        }
    }

}


// 실행 클래스
public class Example4 {
    public static void main(String[] args) {

        // ↓ 계산기 객체 생성
        Calculator calculator = new Calculator();
        // ↓ 각 객체에 동일한 계산기를 대입
        User1 user1 = new User1();
        user1.calculator = calculator;
        User2 user2 = new User2();
        user2.calculator = calculator;
        // ↓ 두 객체가 동일한 calculator객체를 사용하고 있다.
        user1.calculator.memory = 100;
        System.out.println(user2.calculator.memory);
        // ↓ 각 객체가 계산기에 대입하는 병렬처리
        user1.start();
        user2.start();
        // ↑ user1 스레드가 2초간 일시정지 하는 도중에 user2 스레드가 200으로 대입해서 200이 두번 출력
        // 주의할 점 : 두개 이상의 스레드가 하나의 메소드를 호출할 때 비동기 처리를 한다
        // 두개 이상의 스레드가 하나의 메소드를 순서대로 호출할 때 동기 처리를 한다.
        // 두개 이상의 스레드가 하나의 메소드를 요청하면 먼저 요청한 스레드가 종료될 때까지  다음 스레드는 대기상태로 해야한다.

    }
}
