import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoveCar extends JFrame implements ActionListener{
	int img_x=150,img_y=150;
	JButton button;
	JButton button1=new JButton("left");
	JButton button2=new JButton("right");
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			img_x-=10;
		}
		if(e.getSource()==button2) {
			img_x+=10;
		}
		button.setLocation(img_x,img_y);	
	}
	public MoveCar() {
		setSize(600,600);
		setTitle("MoveCar");
		button=new JButton("");
		ImageIcon icon=new ImageIcon("C:/Users/DS/Desktop/car image.jpg");
		button.setLocation(img_x,img_y);
		
		JPanel panel=new JPanel();
		button.setIcon(icon);
		button.setSize(150,100);
		
		panel.add(button);
		panel.add(button1);
		panel.add(button2);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MoveCar();

	}

}
