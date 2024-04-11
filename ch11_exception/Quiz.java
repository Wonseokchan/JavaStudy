package source.ch11_exception;

public class Quiz {
    public static void main(String[] args) {
        try {
            myMethod(1);
            System.out.println("B");
        } catch (Exception e) {
            System.out.println("C");
        }finally {
            System.out.println("D");
        }
        System.out.println("E");
    }

    public static void myMethod(int num) throws Exception {
        if(num < 0){
            throw new Exception();
        }
        System.out.println("A");
    }
}
