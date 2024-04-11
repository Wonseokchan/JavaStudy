package source.ch08_class.homepage;

import java.util.ArrayList;
public class BoardDB {
    private ArrayList<Board> boardList = new ArrayList<>();

    private BoardDB (){
        boardList.add(new Board(boardList.size()+1,"첫 번째 게시글 제목","호빵맨", "첫 번째 게시글 내용"));
        boardList.add(new Board(boardList.size()+1,"두 번째 게시글 제목","식빵맨", "두 번째 게시글 내용"));
        boardList.add(new Board(boardList.size()+1,"세 번째 게시글 제목","찐빵맨", "세 번째 게시글 내용"));
    }

    private static BoardDB instance = new BoardDB();

    public static BoardDB getInstance(){
        return instance;
    }

    public void show(){ //게시글 목록 출력
        for(int i = 0; i < boardList.size(); i++){
            System.out.println(boardList.get(i));
        }
    }
    public void viewBoard(int a){ //글보기
        for (Board bo : boardList) {
            if(bo.getNum() == a) {
                System.out.println("======================");
                System.out.println("제목 : "+bo.getTitle());
                System.out.println("작성자 : "+bo.getName());
                System.out.println("----------------------");
                System.out.println(bo.getContents());
                System.out.println("======================");
                break;
            }
        }
    }

    public void boardADD(Board bd){
        boardList.add(new Board(boardList.size()+1, bd.getTitle(), bd.getName(), bd.getContents()));
    }
}
