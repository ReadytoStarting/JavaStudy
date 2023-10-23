import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Repair extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JCheckBox source=(JCheckBox)e.getSource();
					int index=-1;
					for (int j=0;j<buttons.length;j++) {
						if (buttons[j]==source) {
							index=j;
							break;
						}
					}
					if (index!=-1) {
						if (source.isSelected()) {
							money+=prices[index];
						}else {
							money-=prices[index];
						}
						label.setText("총 가격: "+money+"원");
					}
				}
			});
			add(buttons[i]);
			i++;
		}
		label=new JLabel("총 가격: 0원");
		add(label);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane=new Repair();
		newContentPane.setVisible(true);
		frame.setContentPane(newContentPane);
		frame.setSize(500,200);
		frame.setVisible(true);
		
	}

}
