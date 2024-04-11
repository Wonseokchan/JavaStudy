package source.ch08_class.cafe;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeMain {
    public static void main(String[] args) {
        //여러 카페에 방문해서 커피를 사서 마시는 프로그램
        //카페는 '카페이름, 전화번호, 메뉴들' 을 가짐
        //메뉴는 '메뉴명, 가격' 을 가짐

        Cafe conte = new Cafe();
        conte.setName("꼰떼");
        conte.setPhone("042-256-1234");
        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("아메리카노", 2000));
        menuList.add(new Menu("라떼", 4000));
        menuList.add(new Menu("아이스티", 3000));
        menuList.add(new Menu("밀크티", 4500));
        conte.setMenuList(menuList);
        System.out.println(conte);

        Cafe twosome = new Cafe();
        twosome.setName("투썸플레이스");
        twosome.setPhone("042-256-5678");
        //twosome 개게 내부 menuList에 접근하여 menu 넣기
        twosome.getMenuList().add(new Menu("아메리카노", 4500));
        twosome.getMenuList().add(new Menu("라떼", 5000));
        twosome.getMenuList().add(new Menu("아이스티", 4900));
        twosome.getMenuList().add(new Menu("밀크티", 5900));
        System.out.println(twosome);

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("1. 꼰떼 가기 | 2. 투썸 가기 | 3. 종료");
            System.out.print(">>>");
            int command = Integer.parseInt(scan.nextLine());

            if(command==1){
                System.out.println(conte.getName()+"에 방문");
                System.out.println("==============메뉴판==============");
                ArrayList<Menu> conteMenuList = conte.getMenuList();
                for(int i = 0; i< conteMenuList.size(); i++){
                    System.out.print(conteMenuList.get(i).getName());
                    System.out.print(" | "+conteMenuList.get(i).getPrice());
                    System.out.println("원");
                }
                System.out.println("무엇을 구매하시겠습니까?");
                System.out.print(">>>");
                String menuName = scan.nextLine();
                //conte의 메뉴 리스트에서 사용자가 주문한 메뉴를 찾고 [메뉴명 + 가격+ 결제하였습니다] 출력
                for (int i = 0; i < conteMenuList.size(); i++){
                    if(conteMenuList.get(i).getName().equals(menuName)){
                        System.out.print(conteMenuList.get(i).getName());
                        System.out.print(" "+ conteMenuList.get(i).getPrice());
                        System.out.println("원 결제하였습니다.");
                    }
                }

            }
            else if(command==2){
                System.out.println(twosome.getName()+"에 방문");
                System.out.println("==============메뉴판==============");
                ArrayList<Menu> twosomeMenuList = twosome.getMenuList();
                for(int i = 0; i< twosomeMenuList.size(); i++){
                    System.out.print(twosomeMenuList.get(i).getName());
                    System.out.print(" | "+twosomeMenuList.get(i).getPrice());
                    System.out.println("원");
                }
                System.out.println("무엇을 구매하시겠습니까?");
                System.out.print(">>>");
                String menuName = scan.nextLine();
                for (int i = 0; i < twosomeMenuList.size(); i++){
                    if(twosomeMenuList.get(i).getName().equals(menuName)){
                        System.out.print(twosomeMenuList.get(i).getName());
                        System.out.print(" "+ twosomeMenuList.get(i).getPrice());
                        System.out.println("원 결제하였습니다.");
                    }
                }
            }
            else if(command==3)
                break;
        }




    }
}
