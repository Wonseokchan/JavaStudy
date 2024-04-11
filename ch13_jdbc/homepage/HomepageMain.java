package source.ch13_jdbc.homepage;

import source.ch08_class.homepage.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class HomepageMain {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAO();
        BoardDAO boardDAO = new BoardDAO();
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("1 . 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
            System.out.print(">>> ");
            int cmd = 0;
            try {
                cmd = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요");
                continue;
            }

            if(cmd == 1){
                System.out.print("아이디 입력 : ");
                String id = scan.nextLine();
                System.out.print("비밀번호 입력 : ");
                String pw = scan.nextLine();
                System.out.print("이름 입력 : ");
                String name = scan.nextLine();

                int result = memberDAO.signup(id, pw, name);
                if(result == 1){
                    System.out.println("회원가입에 성공하였습니다");
                }
                else{
                    System.out.println("회원가입에 실패하였습니다");
                }
            }
            else if(cmd == 2){
                System.out.print("아이디 입력 : ");
                String id = scan.nextLine();
                System.out.print("비밀번호 입력 : ");
                String pw = scan.nextLine();

                MemberDTO login = memberDAO.signIn(id, pw);
                if(login.getMemId() != null){
                    System.out.println(login.getMemName() + "님 환영합니다");
                    while(true){
                        ArrayList<BoardDTO> boardList = boardDAO.getBoardList();
                        for( BoardDTO bo : boardList){
                            System.out.println("[ " + bo.getBoNo() + " | " + bo.getBoTitle() + " | " + bo.getMemName() + " | " + bo.getBoDate() + " ]");
                        }
                        System.out.println("1. 글쓰기 | 2. 글보기 | 3. 로그아웃");
                        System.out.print(">>> ");
                        int select = (Integer.parseInt(scan.nextLine()));
                        if(select == 1){
                            System.out.print("글 제목 입력 : ");
                            String title = scan.nextLine();
                            System.out.print("글 내용 입력 : ");
                            String contents = scan.nextLine();
                            String memId = login.getMemId();

                            BoardDTO board = new BoardDTO();
                            board.setBoTitle(title);
                            board.setBoContent(contents);
                            board.setMemId(memId);
                            //BoardDTO 객체 내부에 글 제목, 글내용, 작성자 ID 값 들어있음
                            int rst = boardDAO.writeBoard(board);
                            if(rst > 0){
                                System.out.println("글 작성 완료");
                            }
                            else {
                                System.out.println("글 작성 실패");
                            }
                        }
                        else if(select == 2){
                            System.out.print("글 번호 입력 : ");
                            int n = Integer.parseInt(scan.nextLine());
                            BoardDTO bo = boardDAO.readBoard(n);
                            if(bo.getBoTitle() == null){
                                System.out.println("유효하지 않은 글 번호입니다.");
                            }
                            else{
                                System.out.println("=========================================");
                                System.out.println("제목 : " + bo.getBoTitle());
                                System.out.println("작성자 : " + bo.getMemName());
                                System.out.println("작성일 : " + bo.getBoDate());
                                System.out.println("=========================================");
                                System.out.println(bo.getBoContent());
                            }

                        }
                        else if(select == 3){
                            System.out.println("로그아웃 되었습니다");
                            break;
                        }
                    }
                }
                else{
                    System.out.println("아이디 혹은 비밀번호가 틀립니다");
                }
            }
            else if(cmd == 3){
                ArrayList<MemberDTO> memList = memberDAO.getMemberList();
                for(int i = 0; i < memList.size(); i++){
                    System.out.println(memList.get(i));
                }
            }
            else if(cmd == 4){
                System.out.println("종료합니다");
                break;
            }
            else{
                System.out.println("다시 입력해주세요");
            }
        }
    }
}
