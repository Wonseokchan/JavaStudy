package source.seokchan.sub03;

public class Q02 {
    public static void main(String[] args) {
        //월리를 찾아라!!
        //
        //아래의 문자열 변수 findWally 중에 월리가 몇개 들어있는지 콘솔에 출력해주세요.

        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
        int sum = 0;
        for(int i=0; i<findWally.length()-1;i++){
            String wally = findWally.substring(i, i+2);
            if(wally.equals("월리")){
                sum++;
            }
        }
        System.out.println("월리는 "+sum+"개 있습니다");
    }
}
