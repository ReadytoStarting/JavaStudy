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
		setTitle("�������� ȭ����");
		setSize(200,300);
		
		JPanel panel=new JPanel();
		add(panel);
		JLabel label1=new JLabel("�л� ����ϱ�");
		panel.add(label1);
		JLabel l1=new JLabel("�̸�   ");
		panel.add(l1);
		JTextField tf1=new JTextField(15);
		panel.add(tf1);
		JLabel l2=new JLabel("�й�   ");
		panel.add(l2);
		JTextField tf2=new JTextField(15);
		panel.add(tf2);
		JLabel l3=new JLabel("����   ");
		panel.add(l3);
		JTextField tf3=new JTextField(15);
		panel.add(tf3);
		JButton b1=new JButton("����ϱ�");
		panel.add(b1);
		b1.addActionListener(e->{
			String name=tf1.getText();
			String num=tf2.getText();
			String grade=tf3.getText();
			list.add(new Person(name,num,grade));
			System.out.println("�̸�:"+name+" �й�: "+num+" ����: "+grade);
		});
		JButton b2=new JButton("���");
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
