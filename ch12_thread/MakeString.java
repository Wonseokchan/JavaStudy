package source.ch12_thread;

import java.util.concurrent.ThreadLocalRandom;

public class MakeString {
    public static void main(String[] args) {
        //문자열을 아주 길게 만들기

        //ThreadA와 ThreadB에게 각각 문자열을 5천만자리씩 추가시킬 예정
        //동기화 지원 Stringbuffer -> 멀티스레드에서 안정적
        //동기화 미지원 Stringbuilder -> 멀티스레드에서 불안정함
        StringBuffer strBuff = new StringBuffer();
        StringBuilder strBuild = new StringBuilder();

        Thread threadA = new Thread(() -> {
            for(int i = 0; i < 50000000; i++){
                strBuild.append("a");
            }
            System.out.println("A : "+strBuild.length());
        });
        Thread threadB = new Thread(() -> {
            for(int i = 0; i <  50000000; i++){
                strBuild.append("a");
            }
            System.out.println("B : "+strBuild.length());
        });

        threadA.start();
        threadB.start();

    }
}
