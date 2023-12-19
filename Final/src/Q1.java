import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Q1 extends JFrame{
	class MyThread extends Thread{
		private JLabel label;
		private int x,y;
		String fname;
		
		public MyThread(String fname,int x,int y) {
			this.x=x;
			this.y=y;
			this.fname=fname;
			label=new JLabel();
			label.setIcon(new ImageIcon(fname));
			label.setBounds(x,y,100,100);
			add(label);
		}
		public void run() {
			for(int i=0;i<200;i++) {
				x+=10*Math.random();
				label.setBounds(x, y, 100, 100);
				repaint();
				try {
					Thread.sleep(100);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				if (x>600) {
					System.out.println(fname+"가 우승했습니다!");
					return;
				}
			}
		}
	}
	public Q1() {
		setTitle("Cargame");
		setSize(800,600);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		(new MyThread("C:\\Users\\DS\\Downloads\\car1\\car1.gif",100,0)).start();
		(new MyThread("C:\\\\Users\\\\DS\\\\Downloads\\\\car1\\\\car2.gif",100,50)).start();
		(new MyThread("C:\\\\Users\\\\DS\\\\Downloads\\\\car1\\\\car3.gif",100,100)).start();
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q1 g=new Q1();
	}
}
