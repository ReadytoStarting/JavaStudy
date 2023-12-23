import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
class Person{
	String name;
	String num;
	String grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num=num;
	}
	public String getGrade() {
		return grade;
	}
	public void setAddress(String grade) {
		this.grade=grade;
	}
	
	public Person(String name, String num, String grade) {
		super();
		this.name=name;
		this.num=num;
		this.grade=grade;
	}
}
public class Q1 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Person>list=new ArrayList<>();
	
	
	public Q1(){
		setTitle("덕성여대 화이팅");
		setSize(200,300);
		
		JPanel panel=new JPanel();
		add(panel);
		JLabel label1=new JLabel("학생 등록하기");
		panel.add(label1);
		JLabel l1=new JLabel("이름   ");
		panel.add(l1);
		JTextField tf1=new JTextField(15);
		panel.add(tf1);
		JLabel l2=new JLabel("학번   ");
		panel.add(l2);
		JTextField tf2=new JTextField(15);
		panel.add(tf2);
		JLabel l3=new JLabel("성적   ");
		panel.add(l3);
		JTextField tf3=new JTextField(15);
		panel.add(tf3);
		JButton b1=new JButton("등록하기");
		panel.add(b1);
		b1.addActionListener(e->{
			String name=tf1.getText();
			String num=tf2.getText();
			String grade=tf3.getText();
			list.add(new Person(name,num,grade));
			System.out.println("이름:"+name+" 학번: "+num+" 성적: "+grade);
		});
		JButton b2=new JButton("취소");
		panel.add(b2);
		b2.addActionListener(e->{
			System.exit(0);
		});
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Q1 frame=new Q1();
					frame.setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
