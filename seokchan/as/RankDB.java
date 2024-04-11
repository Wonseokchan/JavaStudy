package source.seokchan.as;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class RankDB {
    private ArrayList<Rank> rankList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    private RankDB(){
        rankList.add(new Rank("이거보다 높으면 매크로임", 0.1F));
        rankList.add(new Rank("이건 사람아님", 1.5F));
    }
    private static RankDB instance = new RankDB();

    public static RankDB getInstance() {
        return instance;
    }

    public void showRank(){
        Collections.sort(rankList, new Comparator<Rank>() {
            @Override
            public int compare(Rank rk1, Rank rk2) {
                if(rk1.getReactime() - rk2.getReactime() < 0) {
                    return -1;
                }
                return 0;
            }
        });
        for(int i = 0; i<rankList.size(); i++)
            System.out.println(i+1 +"위\t\t"+ rankList.get(i));
    }

    public void rankADD(Rank rk){
        boolean isDuple = false;
        for(int i = 0; i < rankList.size(); i++) {
            if (rankList.get(i).getName().equals(rk.getName()))
                isDuple = true;
        }
        if(isDuple){
            System.out.println("중복된 닉네임 입니다");
            System.out.println("다른 닉네임을 입력하세요");
        }
        else {
            System.out.println("기록 완료");
            rankList.add(new Rank(rk.getName(), rk.getReactime()));
        }
    }
}
