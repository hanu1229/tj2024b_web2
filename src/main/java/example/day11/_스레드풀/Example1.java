package example.day11._스레드풀;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {
    // main함수안에 main스레드(코드를 읽어드리는 역할) 내장
    public static void main(String[] args) {
        // [1] 반복문을 이용하여 반복문 횟수만큼 작업 스레드를 생성하여 실행
        for(int index = 0; index < 10; index++) {
            String name = "thread " + index;
            // ↓ 작업 스레드 생성
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("작업 스레드 : " + name + " 실행중");
                    try {
                        Thread.sleep(1500);
                    } catch(InterruptedException e) {
                        System.out.println(e);
                    }
                }
            });
            // ↓ 작업 스레드 실행
            thread.start();
        }
        System.out.println("================================================");
        // [2] 반복문을 이용하여 반복문 횟수만큼 지정된 작업 스레드에 배정하여 실행 (스레드 풀)
        // ↓ 스레드풀 생성(고정된 스레드 개수) : Executors.newFixedThreadPool(고정할 개수);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // ↓ 반복문
        for(int index = 0; index < 10; index++) {
            String name = "thread " + index;
            // ↓ 새로운 스레드가 아닌 스레드 풀에 정의한 스레드를 등록하기
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("작업 스레드 : 실행중 " + name);
                    try {
                        Thread.sleep(3000);
                    } catch(InterruptedException e) {
                        System.out.println(e);
                    }
                }
            });
        }
        // 스레드풀 종료 : shutdown();
        executorService.shutdown();
    }
}
