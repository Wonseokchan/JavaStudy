package source.seokchan.sub05;

public class Q04 {
    public static void main(String[] args) {
        String myBinaryStr = makeBinary(23);
        System.out.println(myBinaryStr);
    }

    public static String makeBinary(int n){
        String binary = "";
        String str = "";
        while(true){
            str += n%2;
            n = n/2;
            if(n==1){
                str += 1;
                break;
            }
        }
        for(int i = str.length() -1; i>=0; i--)
            binary += str.substring(i,i+1);
        return binary;

    }
}
