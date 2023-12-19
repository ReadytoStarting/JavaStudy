import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame{
	JTextField stuId, name, tel, dept;
	JButton previousButton, nextButton, InsertButton, deleteButton,
			searchButton, ClearButton;
	ResultSet rs;
	Statement stmt;
	
	public MyFrame() throws SQLException {
		super("Student Viewer");
		Connection con = makeConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//ResultsSet�� ó������ ������ �̵��ϸ鼭 �����͸� ��ȸ�� �� ����
		rs = stmt.executeQuery("SELECT * FROM student");
		//��� �����͸� ������
		
		setLayout(new GridLayout(0, 2));
		add(new JLabel("stuId", JLabel.CENTER));
		add(stuId = new JTextField());
		
		add(new JLabel("name", JLabel.CENTER));
		add(name = new JTextField());
		
		add(new JLabel("tel", JLabel.CENTER));
		add(tel = new JTextField());
		
		add(new JLabel("dept", JLabel.CENTER));
		add(dept = new JTextField());
		

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs = stmt.executeQuery("SELECT * FROM student");
					rs.previous(); //ResultSet���� ������ �����͸� ȭ�鿡 ������Ʈ
					stuId.setText("" + rs.getInt("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				try {
					rs = stmt.executeQuery("SELECT * FROM student");
					rs.next();
					stuId.setText("" + rs.getInt("stuId"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
					

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				create();
//				id.setText("");
//				title.setText("");
//				publisher.setText("");
//				year.setText("");
//				price.setText("");
			}
		});
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				delete();
			}
		});
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		       read();
		    }
		});
		
		ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				clear();
				
			}
		});
		
		add(previousButton);
		add(nextButton);
		add(InsertButton);
		add(deleteButton);
		add(searchButton);
		add(ClearButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
		}
	public static Connection makeConnection() {	
		String url = "jdbc:mysql://localhost:3306/duksung";
		String id = "root";
		String password = "";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		return con;
	}
	public void create(){
		try {
			String query="INSERT INTO student (stuId,name,tel,dept) VALUES (?,?,?,?)";
			java.sql.PreparedStatement pstmt=stmt.getConnection().prepareStatement(query);
			pstmt.setString(4, dept.getText());
			pstmt.setString(2, name.getText());
			pstmt.setString(3, tel.getText());
			pstmt.setInt(1, Integer.parseInt(stuId.getText()));
			pstmt.executeUpdate();
			System.out.println("�����Ͱ� �߰��Ǿ����ϴ�.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete() {
		String currentBookId=name.getText();
		try {
			
			
			String deleteQuery="DELETE FROM student WHERE name=?";
			java.sql.PreparedStatement pstmt=stmt.getConnection().prepareStatement(deleteQuery);
			pstmt.setString(1, currentBookId);
			pstmt.executeUpdate();
			
			System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
			//rs.close();
			rs = stmt.executeQuery("SELECT * FROM student");
			//rs.next();
			 stuId.setText(""); 
			 name.setText(""); 
			 tel.setText(""); 
			 dept.setText("");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void read() {
		 String searchKeyword = name.getText(); // ���⼭�� search�� �ƴ� searchPublisher�� ����ؾ� ��
	        try {
	            // SQL ������ ����Ͽ� ���� �̸��� �������� �˻�
	            String query = "SELECT * FROM student WHERE name LIKE '%" + searchKeyword + "%'";
	            ResultSet searchResult = stmt.executeQuery(query);
	            
	            // �˻� ����� ������ ResultSet���� ������ �����͸� ȭ�鿡 ������Ʈ
	            if (searchResult.next()) {
	                stuId.setText("" + searchResult.getInt("stuId"));
	                name.setText("" + searchResult.getString("name"));
	                tel.setText("" + searchResult.getString("tel"));
	                dept.setText("" + searchResult.getString("dept"));
	                
	            } else {
	                System.out.println("�˻� ����� �����ϴ�.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
	public void clear() {
		try {
			rs = stmt.executeQuery("SELECT * FROM student");
			stuId.setText(""); 
			 name.setText(""); 
			 tel.setText(""); 
			 dept.setText("");
			 
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

public class Q4 {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
