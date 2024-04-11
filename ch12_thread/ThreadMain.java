package source.ch12_thread;

public class ThreadMain {
    public static void main(String[] args) {
        //기본적으로 멀티스레드를 구현하지 않으면 스레드 하나만 일을 하므로 (= 메인 스레드)
        //위에서부터 차례대로 코드가 실행된다(= 동기)
        //printN(20);

        //printN(100);

        //1. Thread 를 상속받은 클래스를 이용하여 멀티스레드 구현
        MyThread myTH = new MyThread(200);
        myTH.start();

        // thread는 300~305를 출력할 수 있도록 MyThread를 수정
        MyThread threadB = new MyThread(300);
        threadB.start();

        printN(100);

        //외부 스레드에 일을 던지는 비동기 방식의 경우 각각의 외부 스레드가 언제 일이 끝날지 모른다

        //2. Thread의 생성자에 Runnable 인터페이스의 추상메소드 run 넣어주기
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                printN(400);
            }
        });

        threadC.start();
        //람다식 사용 가능
        Thread threadD = new Thread(() -> {
            printN(500);
        });
        threadD.start();


    }
    public static void printN(int n){
        for(int i = n; i <= n+5; i++){
            System.out.println(i);

            try {
                //실행에 텀을 주고 싶을 때 사용
                //이 코드를 실행한 Thread가 잠이 든다
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

