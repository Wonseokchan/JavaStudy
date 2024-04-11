package source.ch13_jdbc;

import oracle.jdbc.OracleDriver;

import javax.xml.transform.Result;
import java.sql.*;

public class JdbcSelect {
    public static void main(String[] args) {
        //Oracle, MySQL
        //Oracle DB 연동을 위한 라이브러리 ojdbc 다운받기

        //해당 클래스를 깨운다 -> DB드라이버를 OracleDB드라이버로 변경
        OracleDriver od = new oracle.jdbc.OracleDriver();

        // 1. 드라이버 설정
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 설정 완료");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e); //프로그램 멈춤
            System.out.println("드라이버 설정 실패");
            System.exit(0); // 프로그램 종료
        }

        // 2. DB 연결을 위한 URL, 계정 ID/PW 준비
        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std306";
        String pw = "oracle21c";

        // 3. 데이터베이스 서버와 연결
        //연결에 성공하면 DB와 연결된 상태인 객체(Connection)을 리턴한다
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DB 연결 성공");

            // 4. 쿼리문 작성
            StringBuffer query = new StringBuffer();
            //문자열 더하기 할 때 여백이 없이 이어지는 경우가 없도록 하기
            query.append("SELECT            ");
            query.append("      MEM_ID,      ");
            query.append("      MEM_PW,      ");
            query.append("      MEM_NAME AS 이름,    ");
            query.append("      MEM_SCORE    ");
            query.append("FROM               ");
            query.append("      MEMBERS      "); //쿼리문 안에 ; 넣으면 에러남
            query.append("Order BY           ");
            query.append("      MEM_ID       ");

            // 5. 쿼리문을 실행하기 위해 PreparedStatement 객체 생성
            //쿼리문에 문제가 있는 경우 이 때 SQLException 에러가 날 수 있음
            ps = conn.prepareStatement(query.toString());

            // 6. 쿼리문 실행 및 실행 결과를 ResultSet에 담기
            rs = ps.executeQuery();

            //7. ResultSet 내부 데이터 조회
            while(rs.next()){
                System.out.println(rs.getString("MEM_ID"));
                System.out.println(rs.getString("MEM_PW"));
                //알리아스(AS)를 사용했다면 해당 알리아스 컬럼명 입력
                System.out.println(rs.getString("이름"));
                System.out.println(rs.getInt("MEM_SCORE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 8. DB연결에 사용된 모든 객체들 close 해주기 ( = 자원정리 )
            //생성된 순서의 반대 순서로 close 하는 것을 추천
            if(rs != null){ try {rs.close();} catch (SQLException e) {} }
            if(ps != null){ try {ps.close();} catch (SQLException e) {} }
            // 연결 끊기(안그러면 계속 연결이 쌓인다)
            if(conn != null){ try {conn.close();} catch (SQLException e) {} }

        }

    }
}
