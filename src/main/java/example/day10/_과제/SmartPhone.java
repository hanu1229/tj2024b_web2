package example.day10._과제;


import java.util.Scanner;

public class SmartPhone {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Music music = null;
        WebSurfing webSurfing = null;
        Thread musicThread = null;
        Thread webSurfingThread = null;
        System.out.println("1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료");
        System.out.print(">> ");
        while(true) {
            int choose = scan.nextInt();
            if(choose == 1) {
                if(music == null || !music.state) {
                    System.out.println("음악 시작!");
                    music = new Music();
                    musicThread = new Thread(music);
                    music.state = true;
                    musicThread.start();
                } else {
                    music.state = false;
                    // musicThread.interrupt();
                }
            } else if(choose == 2) {
                if(webSurfing == null || !webSurfing.state) {
                    System.out.println("웹서핑 시작!");
                    webSurfing = new WebSurfing();
                    webSurfingThread = new Thread(webSurfing);
                    webSurfing.state = true;
                    webSurfingThread.start();
                } else {
                    webSurfing.state = false;
                    // webSurfingThread.interrupt();
                }
            } else if(choose == 0) {
                if(music != null) {
                    music.state = false;
                    // musicThread.interrupt();
                }
                if(webSurfing != null) {
                    webSurfing.state = false;
                    // webSurfingThread.interrupt();
                }
                System.out.println("스마트폰 종료!");
                return;
            }

        }
    }
}
