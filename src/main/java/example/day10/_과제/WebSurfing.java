package example.day10._과제;

public class WebSurfing implements Runnable {
    public boolean state = true;
    @Override
    public void run() {
        while(true) {
            if(state) {
                System.out.println("웹서핑 중...");
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("웹서핑 종료!");
                break;
            }

        }
    }
}
