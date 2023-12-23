import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Q3 {
	public static Connection makeConnection() {
		String url="jdbc:mysql://localhost:3306/duksung";
		String id="root";
		String password="";
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con=DriverManager.getConnection(url,id,password);
			System.out.println("데이터베이스 연결 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}catch(SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}return con;
	}

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Connection con=makeConnection();
		try {
			String sql=""+
					"INSERT INTO student (stuId,name,tel,dept)"+
					"VALUES (?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, 2022001);
			pstmt.setString(2, "Minji lee");
			pstmt.setString(3, "000-0000-0001");
			pstmt.setString(4, "Cyber Security");
			PreparedStatement pstmu=con.prepareStatement(sql);
			pstmu.setInt(1, 2022002);
			pstmu.setString(2, "Hanni park");
			pstmu.setString(3, "000-0000-0002");
			pstmu.setString(4, "Computer");
			PreparedStatement pstmv=con.prepareStatement(sql);
			pstmv.setInt(1, 2022003);
			pstmv.setString(2, "Danielle chung");
			pstmv.setString(3, "000-0000-0003");
			pstmv.setString(4, "IT Media");
			PreparedStatement pstmw=con.prepareStatement(sql);
			pstmw.setInt(1, 2022004);
			pstmw.setString(2, "Hyein choi");
			pstmw.setString(3, "000-0000-0004");
			pstmw.setString(4, "Software");
			pstmt.executeUpdate();
			pstmu.executeUpdate();
			pstmv.executeUpdate();
			pstmw.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if (con!=null) {
				try {
					con.close();
				}catch(SQLException e) {}
		
			}
		}
	}
}