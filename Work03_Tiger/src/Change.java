import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Change extends JFrame implements ActionListener{
	int t;
	double c;
	JTextField field1;
	JTextField field2;
	public void actionPerformed(ActionEvent e) {
		t=Integer.parseInt(field1.getText());
		c=t*1.609344;
		field2.setText(c+" km");
		
	}
	public Change() {
		setTitle("Mile->Km");
		setSize(400,150);
		
		JPanel panel=new JPanel();
		JLabel label1=new JLabel("마일을 입력하시오");
		field1=new JTextField();
		field1.setColumns(10);
		field1.setText(field1.getText());
		
		JLabel label2=new JLabel(" ->");
		field2=new JTextField(c+" km");
		field2.setColumns(10);
		JButton button=new JButton("변환");
		button.addActionListener(this);
		
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Change k=new Change();

	}

}
