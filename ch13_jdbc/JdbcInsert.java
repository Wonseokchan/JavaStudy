package source.ch13_jdbc;

import java.sql.*;
public class JdbcInsert {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
        String id = "std306";
        String pw = "oracle21c";

        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet은 select문에서만 사용
        try {
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DB연결 성공");

            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO ");
            query.append("members (");
            query.append("  mem_id,     ");
            query.append("  mem_pw,     ");
            query.append("  mem_name,   ");
            query.append("  mem_score   ");
            query.append("  ) VALUES (  ");
            query.append("       ?,       "); //값이 들어오는 곳에 ? 표기 가능
            query.append("       ?,       ");
            query.append("       ?,       ");
            query.append("       ?        ");
            query.append("  )             ");
            //ps는 완성되지 않은 쿼리문을 보유중 -> 쿼리문 실행 불가
            ps = conn.prepareStatement(query.toString());

            //쿼리문 내 ? 값을 채워주기
            //위에서 아래 방향으로 물음표의 순서에 맞게 채워줌
            //첫번째 물음표는 1번임(인덱스처럼 0이 아님)
            int idx=1;
            ps.setString(idx++,"f001");
            ps.setString(idx++,"123f");
            ps.setString(idx++,"식빵맨");
            ps.setInt(idx++,0);

            //SELECT문이 아닌
            //INSERT, UPDATE, DELETE 문은 executeUpdate()로 실행
            //executeUpdate()는 updated rows 값을 리턴
            int result = ps.executeUpdate();
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){try {ps.close();} catch (SQLException e) {e.printStackTrace();}}
            if(conn != null){try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
        }

    }
}
