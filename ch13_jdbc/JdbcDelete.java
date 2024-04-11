package source.ch13_jdbc;
import java.sql.*;
public class JdbcDelete {
    public static void main(String[] args) {
        //점수가 100인 member 데이터에 대해 점수를 0으로 수정하기
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

        try {
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DB연결 성공");

            StringBuffer query = new StringBuffer();
            query.append("DELETE                   ");
            query.append("FROM                     ");
            query.append("       MEMBERS           ");
            query.append("WHERE                    ");
            query.append("       MEM_ID = 'e001'     ");

            ps = conn.prepareStatement(query.toString());

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
