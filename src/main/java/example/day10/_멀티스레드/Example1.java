package example.day10._멀티스레드;

import java.awt.*;

public class Example1 {
    // ↓ main함수는 main스레드를 포함하며 코드의 시작이다
    public static void main(String[] args) {
        System.out.println("(1) main스레드가 읽어드리는 코드");
        // ↓ main함수 안에서 작성된 코든느 모드 main 스레드가 읽어드린다.
        for(int index = 0; index < 5; index++) {
            System.out.println("(2) main스레드가 읽어드리는 코드 " + index);
        }
        // region 싱글 스레드
        System.out.println("==================== ↓ 싱글 스레드 ↓ ====================");
        // ↓ java ui를 제공하는 패키지(java.awt)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int index = 0; index < 5; index++) {
            toolkit.beep();
            // 스레드 일시정지
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        // 출력 5번 실행
        for(int index = 0; index < 5; index++) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("==================== ↑ 싱글 스레드 ↑ ====================");
        // endregion 싱글 스레드

        // region 멀티 스레드  (1) 익명 객체
        System.out.println("==================== ↓ 멀티 스레드 (1) 익명 객체 ↓ ====================");
        // 작업스레드 정의
        Thread thread = new Thread(new Runnable() {
            // 추상 메소드
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int index = 0; index < 5; index++) {
                    toolkit.beep();
                    System.out.println("동");
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        });
        // 작업스레드 실행
        thread.start();
        // 출력 5번 실행
        for(int index = 0; index < 5; index++) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("==================== ↑ 멀티 스레드 (1) 익명 객체 ↑ ====================");
        // endregion

        // region 멀티 스레드 (2) 구현 객체
        System.out.println("==================== ↓ 멀티 스레드 (2) 구현 객체 ↓ ===================");
        BeepSound beepSound = new BeepSound();
        Thread beepSoundThread = new Thread(beepSound);
        beepSoundThread.start();
        // 출력 5번 실행
        for(int index = 0; index < 5; index++) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("==================== ↑ 멀티 스레드 (2) 구현 객체 ↑ ====================");
        // endregion 멀티 스레드 (2) 구현 객체

        // region 멀티 스레드 (3) 상속 객체
        System.out.println("==================== ↓ 멀티 스레드 (3) 상속 객체 ↓ ===================");

        BeepSound2 beepSound2 = new BeepSound2();
        beepSound2.start();
        // 출력 5번 실행
        for(int index = 0; index < 5; index++) {
            System.out.println("띵");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("==================== ↑ 멀티 스레드 (3) 상속 객체 ↑ ====================");
        // endregion 멀티 스레드 (3) 상속 객체
        
    }
}
