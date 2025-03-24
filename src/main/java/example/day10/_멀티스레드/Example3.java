package example.day10._멀티스레드;

import java.time.LocalTime;
import java.util.Scanner;

class TimeClass implements Runnable {
    // run()이 구현체
    @Override
    public void run() {
        try {
            while(true) {
                System.out.println("현재 시간 : " + LocalTime.now());
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
}

class TimerClass extends Thread {
    boolean state = true;
    @Override
    public void run() {
        int second = 0;
        try {
            while(state) {
                Thread.sleep(1000);
                second++;
                System.out.println("타이머 : " + second + "초");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Example3 {
    public static void main(String[] args) {

        // region (작업 스레드) 현재 시간을 출력하는 스레드 추가
        System.out.println("==================== ↓ 현재 시간을 출력하는 스레드 ↓ ====================");

        TimeClass runnable1 = new TimeClass();
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        System.out.println("==================== ↑ 현재 시간을 출력하는 스레드 ↑ ====================");
        // endregion (작업 스레드) 현재 시간을 출력하는 스레드 추가

        // region (main스레드) 입력받기
        System.out.println("==================== ↓ 입력받기 ↓ ====================");
        // region (작업 스레드) 타이머를 출력하는 스레드 추가
        //TimerClass thread2 = new TimerClass();
        //thread2.state = false;
        // endregion (작업 스레드) 타이머를 출력하는 스레드 추가
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("타이머 1. ON 2.OFF : ");
            int ch = scan.nextInt();
            TimerClass thread2 = new TimerClass();
            if(ch == 1) {
                System.out.println("===== 타이머 시작 =====");
                // thread2 = new TimerClass();
                thread2.state = true;
                thread2.start();
            } else {
                System.out.println("===== 타이머 종료 =====");
                thread2.state = false;
            }
        }

        // System.out.println("==================== ↑ 입력받기 ↑ ====================");
        // endregion (main스레드) 입력받기

    }
}

