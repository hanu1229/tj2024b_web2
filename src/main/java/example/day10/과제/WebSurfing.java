package example.day10.과제;

public class WebSurfing implements Runnable {
    public boolean state = true;
    @Override
    public void run() {
        while(state) {
            System.out.println("웹서핑 중...");
            try {
                Thread.sleep(2000);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
