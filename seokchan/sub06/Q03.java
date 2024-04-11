package source.seokchan.sub06;

import java.util.Arrays;

public class Q03 {
    public static void main(String[] args) {
        //로또 번호 생성기
        //1~45 까지의 랜덤 숫자 6개를 배열에 중복되지 않도록 담고, 이를 정렬한 배열을 리턴하는 makeLotto() 함수를 만들어주세요.
        int[] myLotto = makeLotto();
        for(int i = 0; i < myLotto.length; i++){
            Arrays.sort(myLotto);
            System.out.print(myLotto[i] + " ");
        }
        System.out.println("\n==================\n");
        int[] myLotto2 = makeLotto2();
        for(int i = 0; i < myLotto.length; i++){
            Arrays.sort(myLotto2);
            System.out.print(myLotto2[i] + " ");
        }
        System.out.println("\n==================\n");
        //로또 시뮬레이터 만들기
        //과연 나는 로또를 몇장 구매해야 당첨될까
        /*int[] winLotto = { 3, 7, 11, 20, 22, 41 };
        //로또가 당첨될때까지 반복해서 makeLotto()실행
        //반복횟수 카운트
        int buy = 0;
        while(true){
            buy++;
            int[] one = makeLotto2();
            //구매한 로또 번호가 당첨 번호와 전부 일치하는지 확인
            //winLotto와 one의 각 인덱스 요소가 전부 같음
            //winLotto == one >> X
            int count = 0;
            for(int i = 0; i<winLotto.length; i++){
                if(winLotto[i] == one[i])
                    count++;
            }
            if(count == 6){
                System.out.println("당첨!!");
                System.out.println("사용금액 : "+(buy*1000));
                break;
            }
            System.out.println("로또 구매 횟수 : "+buy);
        }*/

    }
    public static int[] makeLotto(){
        int[] lotto = new int[6];
        for(int i = 0; i < lotto.length; i++) {
            lotto[i] = source.seokchan.sub05.Q03.makeRandom(1, 45);
            for(int j = 0; j < i; j++){
                if(lotto[i] == lotto[j])
                    i--;
            }
        }
        return lotto;
    } //myVersion
    public static int[] makeLotto2() {
        int[] lotto2 = new int[6];
        int idx = 0;
        while (true) {
            int rand = (int) (Math.random() * 45) + 1;
            boolean isDuple = false;
            for (int j = 0; j < idx; j++) {
                //중복 감지!!
                if (lotto2[j] == rand)
                    isDuple = true;
            }
            if (!isDuple) {
                lotto2[idx] = rand;
                idx++;
            }
            if (idx == 6)
                break;
        }
        Arrays.sort(lotto2);
        return lotto2;
    } //SSAM Version
}
