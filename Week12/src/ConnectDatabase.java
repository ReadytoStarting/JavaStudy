import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame{
	JTextField id, title, publisher, year, price, search;
	JButton previousButton, nextButton, InsertButton, deleteButton,
			searchButton, ClearButton;
	ResultSet rs;
	Statement stmt;
	
	public MyFrame() throws SQLException {
		super("Database Viewer");
		Connection con = makeConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//ResultsSet�� ó������ ������ �̵��ϸ鼭 �����͸� ��ȸ�� �� ����
		rs = stmt.executeQuery("SELECT * FROM books");
		//��� �����͸� ������
		
		setLayout(new GridLayout(0, 2));
		add(new JLabel("ID", JLabel.CENTER));
		add(id = new JTextField());
		
		add(new JLabel("TITLE", JLabel.CENTER));
		add(title = new JTextField());
		
		add(new JLabel("PUBLISHER", JLabel.CENTER));
		add(publisher = new JTextField());
		
		add(new JLabel("YEAR", JLabel.CENTER));
		add(year = new JTextField());
		
		add(new JLabel("PRICE", JLabel.CENTER));
		add(price = new JTextField());
		
		add(new JLabel("���ǻ� �˻�", JLabel.CENTER));
		add(search = new JTextField());

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous(); //ResultSet���� ������ �����͸� ȭ�鿡 ������Ʈ
					id.setText("" + rs.getInt("book_id"));
					title.setText("" + rs.getString("title"));
					publisher.setText("" + rs.getString("publisher"));
					year.setText("" + rs.getString("year"));
					price.setText("" + rs.getInt("price"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.next();
					id.setText("" + rs.getInt("book_id"));
					title.setText("" + rs.getString("title"));
					publisher.setText("" + rs.getString("publisher"));
					year.setText("" + rs.getString("year"));
					price.setText("" + rs.getInt("price"));

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		InsertButton = new JButton("Insert");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					String query="INSERT INTO books (title, publisher, year, price) VALUES (?,?,?,?)";
					java.sql.PreparedStatement pstmt=stmt.getConnection().prepareStatement(query);
					pstmt.setString(1, title.getText());
					pstmt.setString(2, publisher.getText());
					pstmt.setString(3, year.getText());
					pstmt.setInt(4, Integer.parseInt(price.getText()));
					pstmt.executeUpdate();
					System.out.println("�����Ͱ� �߰��Ǿ����ϴ�.");
				}catch(SQLException e) {
					e.printStackTrace();
				}
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
				int currentBookId=Integer.parseInt(id.getText());
				try {
					
					
					String deleteQuery="DELETE FROM books WHERE book_id=?";
					java.sql.PreparedStatement pstmt=stmt.getConnection().prepareStatement(deleteQuery);
					pstmt.setInt(1, currentBookId);
					pstmt.executeUpdate();
					
					System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
					//rs.close();
					rs = stmt.executeQuery("SELECT * FROM books");
					//rs.next();
					 id.setText(""); 
					 title.setText(""); 
					 publisher.setText(""); 
					 year.setText("");
					 price.setText("");
				
					
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        String searchKeyword = search.getText(); // ���⼭�� search�� �ƴ� searchPublisher�� ����ؾ� ��
		        try {
		            // SQL ������ ����Ͽ� ���� �̸��� �������� �˻�
		            String query = "SELECT * FROM books WHERE publisher LIKE '%" + searchKeyword + "%'";
		            ResultSet searchResult = stmt.executeQuery(query);
		            
		            // �˻� ����� ������ ResultSet���� ������ �����͸� ȭ�鿡 ������Ʈ
		            if (searchResult.next()) {
		                id.setText("" + searchResult.getInt("book_id"));
		                title.setText("" + searchResult.getString("title"));
		                publisher.setText("" + searchResult.getString("publisher"));
		                year.setText("" + searchResult.getString("year"));
		                price.setText("" + searchResult.getInt("price"));
		            } else {
		                System.out.println("�˻� ����� �����ϴ�.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		});
		
		ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				try {
					rs = stmt.executeQuery("SELECT * FROM books");
					id.setText(""); 
					 title.setText(""); 
					 publisher.setText(""); 
					 year.setText("");
					 price.setText("");
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
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
		String url = "jdbc:mysql://localhost:3306/book_db";
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
}


public class ConnectDatabase {

	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
