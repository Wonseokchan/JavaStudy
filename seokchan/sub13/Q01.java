package source.seokchan.sub13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q01 {
    public static void main(String[] args) {
        ArrayList<String> food = new ArrayList<>();
        food.add("짜장면");
        food.add("짬뽕");
        food.add("볶음밥");
        food.add("김치찌개");
        food.add("제육볶음");
        food.add("돈까스");
        food.add("카레");
        food.add("김밥/라면");
        food.add("순대국밥");
        food.add("냉면");
        food.add("삼겹살");
        food.add("생선구이");
        food.add("햄버거");
        food.add("떡볶이");
        food.add("소고기국밥");
        food.add("시래기");
        Scanner scan = new Scanner(System.in);
        Collections.shuffle(food);
        ArrayList<String> food8 = new ArrayList<>();
        ArrayList<String> food4 = new ArrayList<>();
        ArrayList<String> foodWin = new ArrayList<>();
//        System.out.println("16강");
//        while (food.size()>0) {
//            System.out.println("메뉴를 선택해주세요");
//            System.out.println("1. " + food.get(0) + " | " + "2. " + food.get(1));
//            System.out.print(">>> ");
//            int cmd = Integer.parseInt(scan.nextLine());
//            if (cmd == 1) {
//                food8.add(food.get(0));
//                food.remove(0);
//                food.remove(0);
//            } else if (cmd == 2) {
//                food8.add(food.get(1));
//                food.remove(0);
//                food.remove(0);
//            }
//        }
//        System.out.println("8강");
//        Collections.shuffle(food8);
//        while(food8.size()>0){
//            System.out.println("메뉴를 선택해주세요");
//            System.out.println("1. " + food8.get(0) + " | " + "2. " + food8.get(1));
//            System.out.print(">>> ");
//            int cmd = Integer.parseInt(scan.nextLine());
//            if (cmd == 1) {
//                food4.add(food8.get(0));
//                food8.remove(0);
//                food8.remove(0);
//            } else if (cmd == 2) {
//                food4.add(food8.get(1));
//                food8.remove(0);
//                food8.remove(0);
//            }
//        }
//        System.out.println("4강");
//        Collections.shuffle(food4);
//        while(food4.size()>0){
//            System.out.println("메뉴를 선택해주세요");
//            System.out.println("1. " + food4.get(0) + " | " + "2. " + food4.get(1));
//            System.out.print(">>> ");
//            int cmd = Integer.parseInt(scan.nextLine());
//            if (cmd == 1) {
//                foodWin.add(food4.get(0));
//                food4.remove(0);
//                food4.remove(0);
//            } else if (cmd == 2) {
//                foodWin.add(food4.get(1));
//                food4.remove(0);
//                food4.remove(0);
//            }
//        }
//        System.out.println("결승");
//        while(true){
//            System.out.println("메뉴를 선택해주세요");
//            System.out.println("1. " + foodWin.get(0) + " | " + "2. " + foodWin.get(1));
//            System.out.print(">>> ");
//            int cmd = Integer.parseInt(scan.nextLine());
//            if (cmd == 1) {
//                System.out.println(foodWin.get(0)+" 우승!!");
//                break;
//            } else if (cmd == 2) {
//                System.out.println(foodWin.get(1)+" 우승!!");
//                break;
//            }
//        }
        worldcup(food);
    }

    public static void worldcup(ArrayList<String> food){
        Scanner scan = new Scanner(System.in);
        if(food.size() == 2)
            System.out.println("결승");
        else
            System.out.println(food.size()+"강");
        ArrayList<String> selectList = new ArrayList<>();
        Collections.shuffle(food);
        for(int i = 0; i < food.size(); i+=2){
            System.out.println("1. " + food.get(i) + " | " + "2. " + food.get(i+1));
            System.out.print(">>> ");
            int cmd = Integer.parseInt(scan.nextLine());
            if (cmd == 1) {
                selectList.add(food.get(i));
            } else if (cmd == 2) {
                selectList.add(food.get(i+1));
            }
        }
        //선택된 메뉴들 반영
        food = selectList;
        //재귀함수
        if(selectList.size() == 1){
            System.out.println(selectList.get(0) + " 우승!!");
        }
        else
            worldcup(food);
    }
}
