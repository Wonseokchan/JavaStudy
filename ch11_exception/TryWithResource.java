package source.ch11_exception;

import java.util.Scanner;

public class TryWithResource {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //몇몇 객체들은 객체를 생성해서 사용한 후 .close()로 객체를 닫아주는 메소드를 실행시켜주어야 한다.
        try{
            Integer.parseInt(scan.nextLine());
        } catch (Exception e){
            System.out.println("에러 발생");
        }
        //사용이 끝나면 닫아줌
        scan.close();


        //1. finally를 이용하는 방법
        try{
            Integer.parseInt(scan.nextLine());
        } catch (Exception e){
            System.out.println("에러 발생");
        } finally {
            //finally는 try 내부 코드에서 에러가 발생하든, 안하든 실행됨
            scan.close();
        }

        //2. try-with-resource 방법
        // .close()가 필요한 객체를 try() 소괄호 안에 해당 객체를 선언 후 try(){} 중괄호 내에서 객체 사용
        //이후 별도로 .close() 실행시키지 않더라도 자동으로 닫힌다
        try(Scanner scanner = new Scanner(System.in)){
            Integer.parseInt(scanner.nextLine());
        } catch (Exception e){
            System.out.println("에러 발생");
        }

        // .close()는 해당 객체를 이후에 전혀 사용하지 않는 시점에 실행

    }
}
