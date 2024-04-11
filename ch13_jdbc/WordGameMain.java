package source.ch13_jdbc;

import java.util.ArrayList;
import java.util.Scanner;

public class WordGameMain {
    public static void main(String[] args) {
        JdbcWord word = new JdbcWord();
        ArrayList<String> wordList = word.getWordList();
        ArrayList<String> endList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        int rand = (int)(Math.random()*wordList.size());
        String computerWord = wordList.get(rand);
        endList.add(computerWord);
        while(true){
            System.out.println("제시어 : " + computerWord);
            System.out.print(">>> ");
            String input = scan.nextLine();

            boolean isContain = false;
            for(int i = 0; i < wordList.size(); i++){
                if(wordList.get(i).equals(input))
                    isContain = true;
            }
            if(isContain == false){
                System.out.println("인간 패배");
                break;
            }

            if(!input.substring(0,1).equals(computerWord.substring(computerWord.length()-1))){
                System.out.println("인간 패배");
                break;
            }
            if(endList.contains(input)){
                System.out.println("인간 패배");
                break;
            }
            endList.add(input);
            ArrayList<String> answerList = new ArrayList<>();
            for(int i = 0; i < wordList.size(); i++){
                if(wordList.get(i).substring(0,1).equals(input.substring(input.length()-1)))
                    answerList.add(wordList.get(i));
            }

            if(answerList.size() == 0){
                System.out.println("인간 승리");
                break;
            }

            int idx = (int)(Math.random()*answerList.size());
            computerWord = answerList.get(idx);

            if(endList.contains(computerWord)){
                System.out.println("인간 승리");
                break;
            }
            endList.add(computerWord);

        }
    }
}
