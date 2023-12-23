import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//public class CarGame {
//	private JLabel label1, label2, label3;
//    private RoadPanel roadPanel;
//    Game game = new Game();
//		//getContentPane().removeAll();
//		//getContentPane().repaint();
//		//JPanel cr=new JPanel();
//    public void initComponents() {
//		label1=new JLabel();
//		label2=new JLabel();
//		label3=new JLabel();
//		
//		roadPanel=new RoadPanel();
//		
//		label1.setFocusable(true);
//    }
//    public void startGame() {
//    	
//			
//				JLabel label=new JLabel("키보드를 많이 눌러서 우승하세요!");
//				label.setFont(new Font("Serif",Font.BOLD,25));
//				label.setBounds(140,50,450,50);
//				
//				label1.setIcon(new ImageIcon("C:\\Users\\KimMJ\\Downloads\\car1\\car1.gif"));
//				label1.setBounds(100, 100, 100, 100);
//				
//				label2.setIcon(new ImageIcon("C:\\Users\\KimMJ\\Downloads\\car1\\car2.gif"));
//				label2.setBounds(100,150,100,100);
//	
//				label3.setIcon(new ImageIcon("C:\\Users\\KimMJ\\Downloads\\car1\\car3.gif"));
//				label3.setBounds(100, 200, 100, 100);
//				
//				Game.getInstance().add(label);
//		        Game.getInstance().add(label2);
//		        Game.getInstance().add(label3);
//				
//			}
//			
//			public void run() {
//				
//				game.repaint();
//				
//				while(true) {
//					SwingUtilities.invokeLater(() ->label2.setLocation((int) (label2.getX()+10*Math.random()),label2.getY()));
//					SwingUtilities.invokeLater(() ->label3.setLocation((int) (label3.getX()+10*Math.random()),label3.getY()));
//					try {
//						Thread.sleep(70);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//					if (label2.getX()>=600 || label3.getX()>=600 || label1.getX()>=600) {
//						break;
//					}
//				}
//				if (label1.getX()>=600) {
//					System.out.println("car1 Win the game");
//				}
//				if (label2.getX()>=600) {
//					System.out.println("car2 Win the game");
//				}
//				if (label3.getX()>=600) {
//					System.out.println("car3 Win the game");
//				}
//				drawRoad();
//				start.setEnabled(true);
//			}
//		}
//		setTitle("CarRace");
//		setSize(800,600);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(null);
//		
//		label1=new JLabel();
//		
//		add(label1);
//		CarGame cg=new CarGame();
//		start.setBounds(380,450,60,50);
//		start.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//				cg.drawRoad();
//				cg.start();
//				start.setEnabled(false);
//				
////				addKeyListener(new KeyListener() {
////					public void keyTyped(KeyEvent e) {}
////					public void keyReleased(KeyEvent e) {}
////					public void keyPressed(KeyEvent e) {
////						if(e.getKeyCode()==KeyEvent.VK_SPACE) {
////							label1.setLocation(label1.getX()+10,label1.getY());
////							if (label1.getX()>=600 || label2.getX()>=600 || label3.getX()>=600) {
////								removeKeyListener(this);
////							}
////						}
////					}
////				});
//			}
//		});
//		
//		label1.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
//        label1.getActionMap().put("space", new AbstractAction() {
//            public void actionPerformed(ActionEvent e) {
//            	cg.drawRoad();
//            	if (label1.getX()<=600 && label2.getX()<=600 && label3.getX()<=600) {
//            		label1.setLocation(label1.getX() + 10, label1.getY());
//            	}
//                if (label1.getX() >= 600 || label2.getX() >= 600 || label3.getX() >= 600) {
//                    start.setEnabled(true);
//                    //label1.setLocation(x,label1.getY());
//                }
//                
//            }
//        });
//        
//		add(start);
//		add(roadPanel);
//
//		setVisible(true);
//	}
//	public void drawRoad() {
//		roadPanel.repaint();
//	}
//	class RoadPanel extends JPanel {
//        @Override
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            Graphics2D g2d = (Graphics2D) g;
//            g2d.setColor(Color.BLACK);
//            g2d.setStroke(new BasicStroke(5));
//            g2d.drawLine(0, 450, 600, 450);
//        }
//    }
//}
