import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Repair<JCheckbox> extends JPanel{
	JCheckBox[] buttons=new JCheckBox[4];
	String[] items= {"엔진오일 교환", "자동변속기오일교환","에어콘필터교환","타이어 교환"};
	int[] prices= {45000,80000,30000,100000};
	int money=0;
	JLabel label;
	
	public Repair() {
		super();

		int i=0;
		while(i<buttons.length) {
			buttons[i]=new JCheckBox(items[i]);
			add(buttons[i]);
			i++;
		}
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Repair();
	}

}
