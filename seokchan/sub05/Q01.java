package source.seokchan.sub05;

public class Q01 {
    public static void main(String[] args) {
        makeTree(5);
        makeTree(7);
    }
    public static String makeTree(int n){
        String tree = "";
        for(int i =0; i<n;i++){
            String blank = "";
            String star = "";
            for(int j = 0; j < i*2+1; j++){
                star += "*";
            }
            for(int k = 0 ; k < n-i; k++){
                blank += " ";
            }
            tree = blank+star;
            System.out.println(tree);
        }
        return tree;
    }
}
