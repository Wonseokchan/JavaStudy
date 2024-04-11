package source.ch04_controll;

public class LoopFor {
    public static void main(String[] args) {
        //반복문
        //for문
        /*for(int i=1;i<=10;i++){
            System.out.println(i);
        }
        System.out.println();
        for(int i = 21; i<=30; i++){
            System.out.println(i);
        }
        int num = 1;

        //10번 반복하는 for문
        for(int i=0;i<10;i++){
            System.out.println(num++);
        }
        System.out.println("\n========================\n");

        //1부터 10까지 더한 값
        int sum = 0;
        for(int i=1;i<=10;i++) {
            sum += i;
        }
        System.out.println(sum);

        //1부터 40까지 더한 값
        sum=0;
        for(int i=1;i<=40;i++)
            sum += i;
        System.out.println(sum);

        //1부터 40까지 짝수만 더한 값
        sum=0;
        for(int i=0;i<=40;i+=2){
            sum += i;
        }
        System.out.println(sum);

        //0부터 2까지 0.2마다 출력
        for(double i =0;i<=2;i+=0.2)
            System.out.println(i);
        System.out.println();
        for(int i =0;i<=20;i+=2)
            System.out.println(i/10.0);
        System.out.println();


        //증감식에 i++두고 같은결과
        for(int i =0;i<=10;i++)
            System.out.println(i/5.0);

        System.out.println();
        int i =2;
        System.out.println("\n"+i+"단");
        for (int j = 1; j < 10; j++){
            System.out.println(i + " x " + j + " = " + i*j);
        }

        for(int x = 1; x < 10; x++) {
            System.out.println("\n"+x+"단");
            for (int j = 1; j < 10; j++){
                System.out.println(x + " x " + j + " = " + x*j);
            }
        }

        for(int i=1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //국수뽑기
        //국수 공장에서 면을 20cm 뽑고 있는데 5cm마다 잘라주기
        //i가 4일때 면이 5cm가 돼서 자라야 함
        //i가 4, 9, 14, 19 일때 면을 잘라야 함
        for(int i=0; i < 40; i++){
            if(i % 5 == 0){
                System.out.println();
            }
            System.out.println(i + ". ||||||||");
        }

        for(int i =0; i < 30; i++){
            if(i%6==0){
                System.out.println();
            }
            if(i%2==0){
                System.out.println(i + ". /////");
            }
            else System.out.println(i + ". \\\\\\\\\\");
        }
        System.out.println();
        for(int i=10; i>0; i--){
            System.out.println(i);
        }
        System.out.println();

        //for문으로 String을 가지고 놀기
        int result =0;
        String example = "1234567890";

        for(int i=0; i < example.length(); i++){
            result += Integer.parseInt(example.substring(i, i+1));
        }
        System.out.println(result);
        System.out.println();

        //밥의 개수
        String bab = "바바바바밥바바밥ㅂ바밥밥밥";
        int sum=0;
        for(int i=0; i<bab.length(); i++){
            String one = bab.substring(i, i+1);
            if(one.equals("밥")){
                sum++;
            }
        }
        System.out.println(sum);
        System.out.println("=================================");
        //break 문;
        //내 이름을 유니코드로 표현
        /*char word =0;
        for(int i=0; i < 65000; i++){
            if(word == 'A'){
                System.out.println(i);;

                break;
            }
        }
        word++;

        //continue문
        //구구단 7단 출력을 하는데 1,2,3은 출력하지 않겠다.
        for(int i = 1; i<=9; i++){
            if(i<=3)
                //continue 명령어가 실행되면 continue아래의 코드는 무시하고 바로 다음 반복문으로 넘어간다.
                continue;
            System.out.println("7 x "+i+" = "+(i*7));
        }
        System.out.println("============구구단============");
        for(int i=2; i<=9; i++){
            System.out.println(i+"단");
            for(int j = 2; j<=9; j++)
                System.out.println(i+" x "+j+" = "+ i*j );
        }*/

        //디버깅 모드
        //코드라인 좌측 넘버를 클릭하여 breakpoint(빨간점)를 만든 후 디버깅
        //생성된 breakpoint는 다시 클릭하면 사라짐
        //목적
        //코드를 한줄 한줄 실행해보며 변수에 어떤값이 담기고 있는지 확인할 때 사용
        //실행
        //상단 벌레모양 아이콘 클릭[Shift + F9]
        //디버깅 시 위에서부터 코드가 실행되다가 breakpoint가 있는 지점에 멈춰서 대기
        //이후 하단 Debug탭의 step over [F8]를 실행하면 한줄 한줄 실행이 된다.
        //디버깅 모드를 종료하려면 Terminate [Ctrl +F2

        //반쪽 트리
        /*for(int i = 0; i < 5; i++) {
            String blank = "";
            for(int k = 0; k < 4-i; k++){
                blank += " ";
            }
            String star = "";
            for(int j = 0; j < i+1; j++){
                star += "*";
            }
            System.out.println(blank + star);
        }
        //트리
        for(int i = 0; i < 5; i++){
            String blank = "";
            for(int j = 0; j < 5-i; j++){
                blank += " ";
            }
            String star = "";
            for(int k = 0; k < i*2+1; k++){
                star += "*";
            }
            System.out.println(blank+star);
        }*/
        //역트리
        for(int i = 0; i <= 5; i++){
            String blank = "";
            for(int j = 0; j < i; j++){
                blank += " ";
            }
            String star = "";
            for(int k = 0; k< 9-i*2;k++){
                star += "*";
            }
            System.out.println(blank+star);
        }
    }
}
