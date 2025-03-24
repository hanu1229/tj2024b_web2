package example.day10._멀티스레드;

import java.awt.*;

public class BeepSound implements Runnable {

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
}
