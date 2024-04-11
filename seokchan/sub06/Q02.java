package source.seokchan.sub06;

public class Q02 {
    public static void main(String[] args) {
        //최댓값, 최솟값 구하기
        //for문을 이용해 intArr의 최댓값과 최솟값을 출력해주세요.
        int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
        int max = 0;
        int min = 500;
        for(int i = 0; i < intArr.length; i++) {
            if(max < intArr[i])
                max = intArr[i];
            else if(min > intArr[i])
                min = intArr[i];
        }
        System.out.println("최댓값 : "+max);
        System.out.println("최솟값 : "+min);



    }
}
