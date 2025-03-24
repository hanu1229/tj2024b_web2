package example.day10._멀티스레드;


class WorkThreadA extends Thread {
    @Override
    public void run() {
        try {
            int count = 1;
            while(true) {
                // Thread.sleep(ms) : 해당 스레드가 밀리초만큼 일시정지하는 함수(예외처리 필수)
                Thread.sleep(1000);
                // 스레드 이름 정의/만들기 함수
                Thread.currentThread().setName("작업스레드A");
                count++;
                System.out.println("현재 스레드명 : " + Thread.currentThread().getName() + " count : " + count);
            }
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Example2 {
    public static void main(String[] args) {

        // region 작업스레드 생성
        System.out.println("==================== ↓ 작업스레드 생성 ↓ ====================");

        // ↓ main스레드가 작업스레드를 생성
        WorkThreadA thread1 = new WorkThreadA();
        // ↓ main스레드가 작업스레드를 실행
        thread1.start();
        // ↓ main스레드가 아래 코드를 실행
        int count = 1;
        try {
            while(true) {
                // Thread.sleep(ms) : 해당 스레드가 밀리초만큼 일시정지하는 함수(예외처리 필수)
                Thread.sleep(1000);
                // 스레드 이름 정의/만들기 함수
                // Thread.currentThread().setName("작업스레드B");
                count++;
                System.out.println("현재 스레드명 : " + Thread.currentThread().getName() + " count : " + count);
            }
        } catch(InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("==================== ↑ 작업스레드 생성 ↑ ====================");
        // endregion 작업스레드 생성

    }
}
