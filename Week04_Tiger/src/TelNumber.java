import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Person{
	String name;
	String tel;
	String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	
	public Person(String name, String tel, String address) {
		super();
		this.name=name;
		this.tel=tel;
		this.address=address;
	}
}
public class TelNumber extends JFrame {
	ArrayList<Person> list=new ArrayList<>();
	private JPanel contentPane;
	private JTextField tF;
	private JTextField tF_1;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelNumber frame=new TelNumber();
					frame.setVisible(true);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public TelNumber() {
		setTitle("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,360,252);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lbl=new JLabel("이름");
		lbl.setBounds(12,10,57,15);
		contentPane.add(lbl);
	
		JLabel lbl_1=new JLabel("전화번호");
		lbl_1.setBounds(12,42,57,15);
		contentPane.add(lbl_1);
	
		tF=new JTextField();
		tF.setBounds(81,7,243,21);
		contentPane.add(tF);
		tF.setColumns(10);
	
		tF_1=new JTextField();
		tF_1.setColumns(10);
		tF_1.setBounds(81,39,243,21);
		contentPane.add(tF_1);
	
		JLabel lbl_2=new JLabel("주소");
		lbl_2.setBounds(12,79,57,15);
		contentPane.add(lbl_2);
	
		JTextArea tA=new JTextArea();
		tA.setBounds(12,104,312,67);
		contentPane.add(tA);
		
		JButton btn=new JButton("저장");
		btn.setBounds(12,181,97,23);
		contentPane.add(btn);
		btn.addActionListener(e ->{
				String name=tF.getText();
				String tel=tF_1.getText();
				String address=tA.getText();
				list.add(new Person(name,tel,address));
		});
		
		JButton btn_1=new JButton("검색");
		btn_1.setBounds(117,181,97,23);
		contentPane.add(btn_1);
		btn_1.addActionListener(e ->{
			String name=tF.getText();
			for(Person p:list) {
				if (p.getName().equals(name)) {
					tF_1.setText(p.getTel());
					tA.setText(p.getAddress());
				}
			}
		});
		
		JButton btn_2=new JButton("종료");
		btn_2.setBounds(227,181,97,23);
		contentPane.add(btn_2);
		btn_2.addActionListener(e->{
			System.exit(0);
		});
		
		
		
	}
}
