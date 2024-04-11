package source.ch13_jdbc.homepage;

import java.sql.*;
import java.util.ArrayList;

//DAO = Data Access Object : 데이터베이스에 접근하기 위한 쿼리문을 보유한 클래스
public class MemberDAO {

    private String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
    private String id = "std306";
    private String pw = "oracle21c";

    public MemberDAO(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 설정 완료");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e); //프로그램 멈춤
            System.out.println("드라이버 설정 실패");
            System.exit(0); // 프로그램 종료
        }
    }

    //회원목록 가져오기
    //DB의 Member 테이블의 데이터를 자바에서 ArrayList에 담기 위해 Member 테이블의 데이터와 1:1 맻이이 되는 MemberDAO 클래스 작성
    public ArrayList<MemberDTO> getMemberList(){
        ArrayList<MemberDTO> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
           conn = DriverManager.getConnection(url,id,pw);

           StringBuffer query = new StringBuffer();
           query.append("SELECT             ");
           query.append("   mem_id,          ");
           query.append("   mem_pw,          ");
           query.append("   mem_name,        ");
           query.append("   mem_score       ");
           query.append("FROM               ");
           query.append("   members           ");

           ps = conn.prepareStatement(query.toString());
           rs = ps.executeQuery();

           while (rs.next()){
               MemberDTO member = new MemberDTO();
               member.setMemId(rs.getString("mem_id"));
               member.setMemPw(rs.getString("mem_pw"));
               member.setMemName(rs.getString("mem_name"));
               member.setScore(rs.getInt("mem_score"));

               result.add(member);
               }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){try { rs.close();} catch (SQLException e){}}
            if(ps != null){try { ps.close();} catch (SQLException e){}}
            if(conn != null){try { conn.close();} catch (SQLException e){}}
        }
        return result;
    }

    //회원가입
    public int signup(String mem_id, String mem_pw, String mem_name){
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DriverManager.getConnection(url,id,pw);

            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO   ");
            query.append("members (     ");
            query.append("  mem_id,     ");
            query.append("  mem_pw,     ");
            query.append("  mem_name,   ");
            query.append("  mem_score   ");
            query.append("  ) VALUES (  ");
            query.append("       ?,       "); //값이 들어오는 곳에 ? 표기 가능
            query.append("       ?,       ");
            query.append("       ?,       ");
            query.append("       0        ");
            query.append("  )             ");

            ps = conn.prepareStatement(query.toString());

            int idx = 1;
            ps.setString(idx++,mem_id);
            ps.setString(idx++,mem_pw);
            ps.setString(idx++,mem_name);

            result = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("중복된 아이디입니다");
        } finally {
            if(ps != null){try { ps.close();} catch (SQLException e){}}
            if(conn != null){try { conn.close();} catch (SQLException e){}}
        }
        return result;
    }

    public MemberDTO signIn(String mem_id, String mem_pw){
        MemberDTO result = new MemberDTO();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url,id,pw);

            StringBuffer query = new StringBuffer();
            query.append("SELECT                 ");
            query.append("      mem_id,          ");
            query.append("      mem_pw,          ");
            query.append("      mem_name,        ");
            query.append("      mem_score        ");
            query.append("FROM                   ");
            query.append("      members          ");
            query.append("WHERE                  ");
            query.append("          mem_id = ?   ");
            query.append("    AND   mem_pw = ?   ");

            ps = conn.prepareStatement(query.toString());
            int idx = 1;
            ps.setString(idx++,mem_id);
            ps.setString(idx++,mem_pw);

            rs = ps.executeQuery();

            while (rs.next()){
                result.setMemId(rs.getString("mem_id"));
                result.setMemPw(rs.getString("mem_pw"));
                result.setMemName(rs.getString("mem_name"));
                result.setScore(rs.getInt("mem_score"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){try { rs.close();} catch (SQLException e){}}
            if(ps != null){try { ps.close();} catch (SQLException e){}}
            if(conn != null){try { conn.close();} catch (SQLException e){}}
        }
        return result;
    }
}
