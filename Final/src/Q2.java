import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Q2 extends JFrame{
	Thread t;
    public Q2() {
        this.setTitle("버블 게임");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(getOwner());
        
        Container c = getContentPane();
        c.setLayout(null);
        
        JButton btn1=new JButton("시작");
        btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t=new Thread();
            	t.start();
			}
        });
        
        c.add(btn1);
        
        
        c.addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent e) {
                Point p = e.getPoint();
                JLabel img = new JLabel(new ImageIcon("bubble.jpg"));
                img.setBounds(p.x, p.y, 50, 50);
                c.add(img);
                repaint();
                
                Thread t = new Thread(new thread(img));
                t.start();
            }
            public void mouseReleased(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
 
        this.setSize(500,500);
        this.setVisible(true);
    }
    
    private class thread implements Runnable {
        private JLabel img;
        private final int bubble_move = 10;
        
        public thread(JLabel img) {
            this.img = img;
        }
        
        public void run() {
            while(true) {
                int x = img.getX();
                int y = img.getY();
                
                img.setLocation(x, y - bubble_move);
                
                if(img.getY() + img.getHeight() < 0) {
                    remove(img);
                }
                
                try {
                    Thread.sleep(20);
                }
                catch(InterruptedException e) { return; }
            }
        }
    }
    
    public static void main(String[] args) {
        new Q2();
    }
}
