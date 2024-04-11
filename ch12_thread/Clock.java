package source.ch12_thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Timer timer = new Timer();

        while(true){
            System.out.println("1. 시계 시작| 2. 시계 멈춤");
            System.out.print(">>> ");
            int cmd = Integer.parseInt(scan.nextLine());

            if(cmd == 1){
                //외부 스레드에게 시계 출력 일 시킴
                timer.start();
            }
            else if(cmd == 2) {
                //외부 스레드의 run 내부 while문 종료
                timer.setRun(false);
                break;
            }
        }
    }
}
