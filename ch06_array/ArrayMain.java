package source.ch06_array;

import source.seokchan.sub05.Q03;

import java.beans.Encoder;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Base64;

public class ArrayMain {
    public static void main(String[] args) {
        String samjang = "삼장";
        String woogong = "오공";
        String saojeong = "사오정";
        String palgye = "저팔계";

        //배열은 여러개의 값을 담아서 한번에 처리할 수 있도록 하는 그릇이라고 보면 된다.

        //배열의 선언
        //String타입의 데이터를 4개 담을 수 있는 배열
        String[] seoyugi = new String[4];
        System.out.println(seoyugi);

        //배열의 길이 확인 (그릇의 크기 확인)
        System.out.println(samjang.length());
        System.out.println(seoyugi.length);

        //배열 내 요소(element)의 값 확인
        //인덱스 사용
        System.out.println(seoyugi[0]);

        //크기만 선언된 배열 내에는 해당 타입의 기본값이 들어있다.
        //기본값(default)
        //참조타입 : null | 기본타입(int, boolean)
        //숫자타입 : 0 | boolean : false

        System.out.println("\n=============================\n");

        //배열에 값 넣기
        seoyugi[0] = samjang;
        seoyugi[1] = woogong;
        seoyugi[2] = saojeong;
        seoyugi[3] = palgye;
        for(int i =0 ; i < seoyugi.length; i++){
            System.out.println(seoyugi[i]);
        }
        System.out.println("\n====================\n");
        //배열 요소를 조회하는 메소드를 만들기
        printArray(seoyugi);

        System.out.println("\n===========================\n");

        //(자바에서) 배열의 단점 >> 크기가 고정됨 !!! | 값을 제거하거나 추가하지 못한다.

        //실행전에 빨간줄이 그어지는 에러는 컴파일 에러
        //실행을 할 때 발생하는 에러는 런타임 에러

        //배열의 장점 >> for문을 이용해 배열에 담긴 모든 요소들을 한번에 처리할 수 있다.
        for(int i = 0; i < seoyugi.length; i++){
            seoyugi[i] = "서유기 " + seoyugi[i];
        }
        printArray(seoyugi);
        System.out.println("\n==============\n");
        //for문을 이용하여 배열 내 특정 요소에 접근하여 처리할 수 있다.
        //서유기 오공 <- "오공"을 찾아서 "서유기"를 '드래곤볼'로 바꾸기
        for(int i = 0; i < seoyugi.length; i++){
            if(seoyugi[i].contains("오공"))
                seoyugi[i] = seoyugi[i].replace("서유기", "드래곤볼");
            System.out.println(seoyugi[i]);
        }
        System.out.println("\n============================\n");

        //로또 번호 6개를 담는 배열 만들기
        //로또 번호는 1~45
        int[] lotto = new int[6];
        /*lotto[0] = Q03.makeRandom(1, 45);
        lotto[1] = Q03.makeRandom(1, 45);
        lotto[2] = Q03.makeRandom(1, 45);
        lotto[3] = Q03.makeRandom(1, 45);
        lotto[4] = Q03.makeRandom(1, 45);
        lotto[5] = Q03.makeRandom(1, 45);*/
        for(int i = 0; i < lotto.length; i++)
            lotto[i] = Q03.makeRandom(1, 45);
        printArray(lotto);

        System.out.println("\n==========================\n");

        // 값을 넣으며 배열 선언
        String[] socArray = { "홀란드", "음바페", "벨링엄" };

        String books = "반지의 제왕, 해리포터, 자바의 정석,이것이 자바다";

        //.split(문자열)
        //괄호안 문자열을 기준으로 해당 문자열을 나누어 문자열 배열로 리턴한다.
        String[] bookArray = books.split(", ");
        for(int i = 0; i<bookArray.length; i++) {
            bookArray[i] = bookArray[i].trim();
            System.out.println(bookArray[i]);
        }
        for(int i = 0; i<bookArray.length; i++)
            System.out.println(bookArray[i]);

        //TMI
        String calStr = "1+3+6+8";
        String[] numArray = calStr.split("\\+"); //regex란 정규표현식의 약자 | *, ?, +의 경우 정규표현식에서 특정 기능을 가지는 특수문자에 해당 | 해당 특수문자를 일반 문자로 쓰려면 앞에 \\를 붙인다.
        //정규표현식 사용 예
        // ID에 영어+숫자만 허용
        // PW에 알파벳 소문자, 대문자, 숫자, 특수문자를 최소 1개 이상인지 체크
        printArray(numArray);

        System.out.println("\n==============================\n");
        String[] sinSeoyugi = seoyugi;
        printArray(seoyugi);
        printArray(sinSeoyugi);

        sinSeoyugi[0] = "강호동";
        sinSeoyugi[1] = "이수근";

        //[Ljava.lang.String;@b4c966a
        //@앞은 객체의 타입, 뒤에 붙은건 hashCode를 16진수로 나타낸 것
        System.out.println(seoyugi);
        System.out.println(seoyugi.hashCode());
        System.out.println(Integer.toHexString(189568618));

        //해쉬코드(hasCode)란? 객체의 메모리 주소값에 대해 해쉬를 적용한 코드를 의미
        //해쉬란? 해쉬함수를 이용해서 데이터를 암호화하는 기법
        //암호화, 복호화 정말 쉽다(라이브러리의 메소드 사용하면 끝)

        //Base64로 문자열 인코딩(암호화 아님)
        String password = "1q2w3e4r";
        Base64.Encoder base64Encoder = Base64.getEncoder();

        byte[] passByte = password.getBytes();
        String encodeRst = new String(base64Encoder.encode(passByte));
        System.out.println(encodeRst);

        //디코딩
        Base64.Decoder base64Decoder = Base64.getDecoder();
        String decodeRst = new String(base64Decoder.decode(encodeRst));
        System.out.println(decodeRst);
        System.out.println("\n===========================\n");

        //올바른 배열 복사
        String[] sinSeoyugi2 = seoyugi.clone();
        System.out.println(seoyugi);
        System.out.println(sinSeoyugi2);

        sinSeoyugi2[0] = "조규현";
        sinSeoyugi2[1] = "피오";
        sinSeoyugi2[2] = "송민호";
        printArray(seoyugi);
        printArray(sinSeoyugi2);

        //clone을 까먹었어요
        //sinseoyugi3에 seoyugi의 값들을 하나하나 옮겨담기
        /*String[] sinSeoyugi3 = new String[];
        for(int i = 0; i < sinSeoyugi3.length-1; i++){
            sinSeoyugi3 =
        }
        sinSeoyugi3[2] = "은지원";
        printArray(seoyugi);
        printArray(sinSeoyugi3);*/


        System.out.println("\n===========================\n");

        int[] intArray = {23, 456, 213, 32, 340, 6, 11};
        printArray(intArray);

        //인덱스 0번 값과 1번 값의위치를 바꿔보기
        int temp = intArray[1];
        intArray[1] = intArray[0];
        intArray[0] = temp;

        printArray(intArray);

        swap(intArray[2], intArray[3]);
        printArray(intArray);

        int a = 10;
        int b = a;

        System.out.println(b);
        a = 20;
        System.out.println(b);

        swap(a,b);
        System.out.println(a);
        System.out.println(b);

        System.out.println("\n============================\n");

        printArray(intArray);
        swap(intArray, 2, 3);
        printArray(intArray);

        System.out.println("\n=============버블 정렬===============");
        //숫자 배열 정렬
        //버블 정렬 알고리즘으로 정렬

        //인덱스 0,1 에 대해 왼쪽이 더 큰지 비교 후 왼쪽이 더 크다면 자리 바꿈
        for(int i = 0; i < intArray.length-1; i++) {
            for (int j = 0; j < intArray.length - 1; j++) {
                if (intArray[j] > intArray[j + 1])
                    swap(intArray, j, j + 1);
            }
        }
        printArray(intArray); //오름차순

        for(int k = 0; k < intArray.length-1; k++) {
            for (int j = 0; j < intArray.length - 1; j++) {
                if (intArray[j] < intArray[j + 1])
                    swap(intArray, j, j + 1);
            }
        }
        printArray(intArray); //내림차순

        //정렬 메소드 이용
        System.out.println("\n=============오름차순 메소드를 이용한 정렬=====================");
        Arrays.sort(intArray); //오름차순
        printArray(intArray);

        //내림차순
        //오름차순 메소드를 이용한 내림차순
        //1. intArray의 모든 요소에 각각 -1을 곱함
        //2. Arrays.sort(intArrya) 적용
        //3. intArray의 모든 요소에 각각 -1을 곱함
        System.out.println("\n=============오름차순 메소드를 이용한 내림차순=====================");
        for(int i = 0; i<intArray.length; i++)
            intArray[i] = intArray[i]*(-1);
        Arrays.sort(intArray);
        for(int i =0; i<intArray.length; i++)
            intArray[i] = intArray[i]*(-1);
        printArray(intArray);

        System.out.println("\n==================================\n");
        //1000원짜리 복권
        int [] lotto1000 = { 1, 5, 10, 12, 23, 45 };

        //5000원짜리 복권
        int [][] lotto5000 = { { 1, 5, 10, 12, 23, 45 }, { 3, 7, 11, 15, 27, 41}, { 6, 9, 15, 18, 32, 37}, { 2, 8, 17, 24, 36, 39}, { 13, 22, 25, 38, 42, 44} };

        //15000원
        int [][][] lotto15000 = { {{ 1, 5, 10, 12, 23, 45 }, { 3, 7, 11, 15, 27, 41}, { 6, 9, 15, 18, 32, 37}, { 2, 8, 17, 24, 36, 39}, { 13, 22, 25, 38, 42, 44}},
                                    {{ 1, 5, 10, 12, 23, 45 }, { 3, 7, 11, 15, 27, 41}, { 6, 9, 15, 18, 32, 37}, { 2, 8, 17, 24, 36, 39}, { 13, 22, 25, 38, 42, 44}},
                                    {{ 1, 5, 10, 12, 23, 45 }, { 3, 7, 11, 15, 27, 41}, { 6, 9, 15, 18, 32, 37}, { 2, 8, 17, 24, 36, 39}, { 13, 22, 25, 38, 42, 44}} };

        //lotto15000[2][2] = { 3, 7, 11, 15, 27, 41}
        //lotto15000[2][2][3] = 15

    }
    public static void printArray(String[] strArr){
        System.out.print("[ ");
        for(int i = 0; i < strArr.length; i++) {
            //맨 마지막인 경우에는 ", " 안붙이기
            if(i == strArr.length-1)
                System.out.print(strArr[i]);
            else
                System.out.print(strArr[i] + ", ");
        }
        System.out.println(" ]");
    }
    public static void printArray(int[] intArr){
        System.out.print("[ ");
        for(int i = 0; i < intArr.length; i++) {
            //맨 마지막인 경우에는 ", " 안붙이기
            if(i == intArr.length-1)
                System.out.print(intArr[i]);
            else
                System.out.print(intArr[i] + ", ");
        }
        System.out.println(" ]");
    }

    public static void swap(int[] param, int idxA, int idxB){
        int temp = param[idxA];
        param[idxA] = param[idxB];
        param[idxB] = temp;
    }

    public static void swap(int idxA, int idxB){
        int temp = idxA;
        idxA = idxB;
        idxB = temp;
    }


}
