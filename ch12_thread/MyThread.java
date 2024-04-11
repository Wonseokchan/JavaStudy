package source.ch12_thread;

//1. Thread를 상속시킨다
public class MyThread extends Thread{
    private int n;

    public MyThread(int n){
        this.n = n;
    }
    //2. Thread의 run 메소드를 Override 한다.

    @Override
    public void run() {
        //run 메소드 내부 코드가 멀티스레드에 던질 일에 해당
        for(int i = n; i <= n+5; i++){
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
