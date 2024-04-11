package source.ch13_jdbc;

import java.sql.*;
import java.util.ArrayList;

public class JdbcWord {
    private String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
    private String id = "std306";
    private String pw = "oracle21c";

    public JdbcWord(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 설정 완료");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e); //프로그램 멈춤
            System.out.println("드라이버 설정 실패");
            System.exit(0); // 프로그램 종료
        }
    }
    public ArrayList<String> getWordList() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<String> result = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DB 연결 성공");

            StringBuffer query = new StringBuffer();
            query.append("SELECT            ");
            query.append("      *      ");
            query.append("FROM               ");
            query.append("      words      ");

            ps = conn.prepareStatement(query.toString());
            rs = ps.executeQuery();

            while(rs.next()){
                result.add(rs.getString("word"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null){ try {rs.close();} catch (SQLException e) {} }
            if(ps != null){ try {ps.close();} catch (SQLException e) {} }
            if(conn != null){ try {conn.close();} catch (SQLException e) {} }
        }
        return result;
    }
}
