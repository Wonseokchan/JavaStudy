package source.ch08_class.homepage;

import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

public class MemberDB {
    private ArrayList<Member> memList = new ArrayList<>();

    //싱글톤 패턴 적용
    //프로젝트 내에서 이 객체를 딱 하나만 생성할 수 있도록 구현
    //1. 기본생성자의 접근제어자를 private으로 변경
    private MemberDB() {
        memList.add( new Member("admin", "admin", "관리자"));
        memList.add( new Member("a001", "123a", "호빵맨"));
    }


    //2. 필드에 자기 자신(MemeberDB) 객체를 생성한다.
    //다른 클래스에서는 객체 생성을 못하므로 static으로 설정
    //instance를 private으로 막은 뒤 instance에 대한 Getter 생성
    private static MemberDB instance = new MemberDB();

    //다른 클래스에서 getInstance를 객체 생성 없이 사용할 수 있도록 static을 붙여준다.
    public static MemberDB getInstance() {
        return instance;
    }

    //회원가입 메소드
    public void signUP(Member mem){
        //파라미터로 들어온 mem의 id값이 memlist 내 존재하는 Member 객체의 id 값과 중복되지 않을때만 회원가입(add)진행 중복되는 경우 회원가입 불가 처리
        boolean isDuple = false;
        for(int i = 0; i < memList.size(); i++) {
            if (memList.get(i).getId().equals(mem.getId()))
                isDuple = true;
        }
        if(isDuple){
            System.out.println("회원가입 실패");
        }
        else {
            System.out.println("회원가입 성공");
            memList.add(mem);
        }
    }

    public void showMemlist(){
        for(int i = 0; i < memList.size(); i++){
            System.out.println(memList.get(i));
        }
    }

    //로그인 메소드
    public Member login(String ID, String PW){
        for(int i = 0; i < memList.size(); i++){
            if(memList.get(i).getId().equals(ID) && memList.get(i).getPassword().equals(PW))
                return memList.get(i);
        }
        //로그인 실패
        return null;
    }
}
