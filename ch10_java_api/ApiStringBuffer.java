package source.ch10_java_api;

public class ApiStringBuffer {
    public static void main(String[] args) {
        //문자열하면? String
        //String을 계속 수정하게 되면 힙 메모리 영역에 매번 새로운 String 객체가 만들어지고 그로인해 가비지 컬렉터가 할 일이 많아진다(=비효율적)
        String word = "오징어";
        for(int i = 0; i < 10; i++){
            word += "3"; //반복문 내에 String 수정 코드가 있으면 인텔리제이가 훈수함
        }

        //문자열을 수정해야 하는 경우 StringBuffer 또는 StringBuilder를 이용하는 것이 권장

        //객체 생성
        StringBuffer strBuff = new StringBuffer();
        System.out.println(strBuff); //""와 같음

        //문자열 추가
        strBuff.append("오징어");
        System.out.println(strBuff);

        //문자열 비우기
        strBuff = new StringBuffer();

        //객체 생성시 문자열 부여
        strBuff = new StringBuffer("기본문자");
        System.out.println(strBuff);

        //파라미터로 String 타입을 요구하는 메소드에 StringBuffer 객체를 넣을 순 없음
        //StringBuffer 객체 안에 문자열을 꺼내서 넣는다
        String str = strBuff.toString();
        System.out.println(str);

        //랜덤숫자 10자리 만들기
        StringBuffer numBuff = new StringBuffer();
        String num = "";
        long before = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++){
            int rand = (int)(Math.random()*10);
            numBuff.append(rand);
            if(i % 100000 == 0){
                System.out.println(i + "...");
            }
        }
        long after = System.currentTimeMillis();
        long diffMill = after - before;
        System.out.println(diffMill/1000 + "초 걸림");

        //String과 StringBuffer의 성능차이가 어마무시하다
        System.out.println("\n=========================================\n");

        StringBuilder strBuild = new StringBuilder();
        strBuild.append("쌍둥이?");
        System.out.println(strBuild);

        String strB = strBuild.toString();

        //StringBuffer는 동기화 지원
        //StringBuilder는 동기화 미지원
        //동기화를 지원한다? >> 멀티 쓰레드 환경에서 해당 객체가 모든 쓰레드에서 안정적으로 사용될 수 있음을 의미

        //동기화 지원 StringBuffer
        //쓰레드 A, B, C에서 각각의 쓰레드 들이 하나의 StringBuffer 객체 를 사용할 때 쓰레드 A가 StringBuffer의 값을 바꾼다면 다른 쓰레드 B, C에서 이를 안다(안정적)
        //단일 쓰레드에서는 조금 낮은 성능

        //동기화 미지원 StringBuilder
        //쓰레드 A, B, C에서 각각의 쓰레드들이 하나의 StringBuilder 객체를 사용할 때 쓰레드 A가 StringBuilder의 값을 바꾼다면 다른 쓰레드 B와 C에서 이를 모를 수 있다.(=불안정)
        //단일 쓰레드에서는 좀 더 좋은 성능



    }
}
