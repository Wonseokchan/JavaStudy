package source.seokchan.sub10.Q01;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        ArrayList<Board> boardList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while(true){
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String strNow = sdf.format(now);
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
            System.out.print(">>> ");
            int select = Integer.parseInt(scan.nextLine());
            if(select == 1){
                for(int i = 0; i < boardList.size(); i++){
                    System.out.println(boardList.get(i));
                }
            }
            else if(select == 2 ){
                System.out.println("글 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.println("글 내용을 입력해주세요 : ");
                String contents = scan.nextLine();

                boardList.add(new Board(boardList.size()+1,title,strNow,contents));
            }
            else if(select == 3 ){
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}
