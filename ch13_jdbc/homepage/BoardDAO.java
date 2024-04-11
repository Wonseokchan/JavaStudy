package source.ch13_jdbc.homepage;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAO {
    private String url = "jdbc:oracle:thin:@nextit.or.kr:1521:xe";
    private String id = "std306";
    private String pw = "oracle21c";

    public BoardDAO(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 설정 완료");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e); //프로그램 멈춤
            System.out.println("드라이버 설정 실패");
            System.exit(0); // 프로그램 종료
        }
    }

    public ArrayList<BoardDTO> getBoardList(){
        ArrayList<BoardDTO> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url,id,pw);

            StringBuffer query = new StringBuffer();
            query.append("SELECT                        ");
            query.append("      a.bo_no,                ");
            query.append("      a.bo_title,             ");
            query.append("      a.bo_content,           ");
            query.append("      a.mem_id,               ");
            query.append("   TO_CHAR(a.BO_DATE, 'yyyy.mm.dd HH24:mi:ss') AS BO_DATE,       ");
            query.append("      b.MEM_NAME              ");
            query.append("FROM                          ");
            query.append("      BOARDS a,               ");
            query.append("      MEMBERS b               ");
            query.append("WHERE                         ");
            query.append("      a.mem_id =  b.MEM_ID    ");
            query.append("ORDER BY BO_DATE DESC         ");

            ps = conn.prepareStatement(query.toString());
            rs = ps.executeQuery();

            while (rs.next()){
                BoardDTO board = new BoardDTO();
                board.setBoNo(rs.getInt("bo_no"));
                board.setBoTitle(rs.getString("bo_title"));
                board.setBoContent(rs.getString("bo_content"));
                board.setMemId(rs.getString("mem_id"));
                board.setBoDate(rs.getString("bo_date"));
                board.setMemName(rs.getString("mem_name"));

                result.add(board);
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

    //글쓰기(insert)
    //파라미터에 글제목, 글내용, 작성자ID가 들어와야 함
    //(=String title, String content, String memId)
    //(=BoardDTO board)로 바꿔도 무방
    public int writeBoard(BoardDTO board){
        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;

        try {
            conn = DriverManager.getConnection(url,id,pw);

            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO           ");
            query.append("      BOARDS (        ");
            query.append("      bo_no,          ");
            query.append("      bo_title,       ");
            query.append("      bo_content,     ");
            query.append("      mem_id,         ");
            query.append("      bo_date         ");
            query.append(") VALUES (            ");
            query.append("   (select count(*)+1 from boards),       "); //값이 들어오는 곳에 ? 표기 가능
            query.append("          ?,          ");
            query.append("          ?,          ");
            query.append("          ?,          ");
            query.append("          sysdate     ");
            query.append("      )               ");

            ps = conn.prepareStatement(query.toString());

            int idx = 1;
            ps.setString(idx++, board.getBoTitle());
            ps.setString(idx++, board.getBoContent());
            ps.setString(idx++, board.getMemId());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(ps != null){try { ps.close();} catch (SQLException e){}}
            if(conn != null){try { conn.close();} catch (SQLException e){}}
        }
        return result;
    }

    public BoardDTO readBoard(int n){
        BoardDTO result = new BoardDTO();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url,id,pw);

            StringBuffer query = new StringBuffer();
            query.append("SELECT                        ");
            query.append("      a.bo_no,                ");
            query.append("      a.bo_title,             ");
            query.append("      a.bo_content,           ");
            query.append("   TO_CHAR(a.BO_DATE, 'yyyy.mm.dd HH24:mi:ss') AS BO_DATE,       ");
            query.append("      b.MEM_NAME              ");
            query.append("FROM                          ");
            query.append("      BOARDS a,               ");
            query.append("      MEMBERS b               ");
            query.append("WHERE                         ");
            query.append("      a.mem_id =  b.MEM_ID    ");
            query.append("      AND                     ");
            query.append("      a.bo_no = ?             ");

            ps = conn.prepareStatement(query.toString());
            ps.setInt(1,n);
            rs = ps.executeQuery();

            while (rs.next()){
                result.setBoNo(rs.getInt("bo_no"));
                result.setBoTitle(rs.getString("bo_title"));
                result.setBoContent(rs.getString("bo_content"));
                result.setBoDate(rs.getString("bo_date"));
                result.setMemName(rs.getString("mem_name"));

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

