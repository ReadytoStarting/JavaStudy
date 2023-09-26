import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JFrame{
	public Card() {
		
		
		setSize(600,300);
		JPanel panel=new JPanel();
		JPanel ipanel=new JPanel();
		ipanel.setLayout(new GridLayout(1,2));
		JLabel label=new JLabel("");
		ImageIcon icon=new ImageIcon("C:/Users/DS/Desktop/car image.jpg");
		label.setIcon(icon);
		ipanel.add(label);
		JPanel tpanel=new JPanel(new GridLayout(3,1));
		JLabel name=new JLabel("김덕성");
		JLabel job=new JLabel("프로젝트 매니저");
		JLabel company=new JLabel("덕성주식회사");
		tpanel.add(name);
		tpanel.add(job);
		tpanel.add(company);
		

		panel.add(ipanel);
		panel.add(tpanel);
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Card();
	}

}
