package source.ch12_thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer extends Thread{

    private boolean isRun = true;

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while (isRun) {
            System.out.println(sdf.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setRun(boolean run) {
        isRun = run;
    }
}
