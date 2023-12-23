import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

		public class Game extends JFrame{
			//private JFrame raceFrame;
			private JLabel label1,label2,label3,title;
			private JButton carbtn;
			private RoadPanel roadPanel;
			private long lastKeyPressTime = 0;
		    private static final int SPACE_IGNORE_INTERVAL = 110; // 500 밀리초 (0.5초) 동안의 연타를 무시

			//public main JPanel;
//			private CardLayout cardLayout;
//		    private JPanel cardPanel;
//		    private yPanel YPanel;
//		    private CarGamePanel carGamePanel;
			public Game() {
				JPanel main=new JPanel();
				setTitle("미니게임모음");
				setSize(600,400);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		        cardLayout = new CardLayout();
//		        cardPanel = new JPanel(cardLayout);
		//
//		        YPanel = new yPanel();
//		        carGamePanel = new CarGamePanel();
		//
//		        cardPanel.add(YPanel, "YourTurn");
//		        cardPanel.add(carGamePanel, "CarGame");
		//
//		        add(cardPanel);
				main.setLayout(null);
				JLabel title=new JLabel("미니게임모음");
				title.setBounds(130,50,350,50);
				title.setFont(new Font("Serif",Font.BOLD,50));
				main.add(title);
				
				JButton carbtn=new JButton("자동차 시합");
				carbtn.setBounds(130,130,140,60);
				main.add(carbtn);
				carbtn.addActionListener(new ActionListener(){
					//main.setVisible(false);
					public void actionPerformed(ActionEvent e) {
						main.setVisible(false);
						Cargame();
					}});
				
				
				JButton don=new JButton("시간 맞추기");
				don.setBounds(280,130,140,60);
				main.add(don);
				don.addActionListener(e->time());
				add(main);
		        setVisible(true);
		        
//		        JButton Bubble=new JButton("풍선 맞추기");
//				Bubble.setBounds(230,200,140,60);
//				main.add(Bubble);
//				Bubble.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						main.setVisible(false);
//						Bubble();
//					}
//				});
				add(main);
		        setVisible(true);
			}
//			class yPanel extends JPanel{
//				public yPanel(){
//				}
//			}
//				class CarGamePanel extends JPanel {
//			        private JLabel label1, label2, label3;
//			        private RoadPanel roadPanel;
		//
//			        public CarGamePanel() {
//			            setLayout(null);
		//
//			            label1 = new JLabel();
//			            label2 = new JLabel();
//			            label3 = new JLabel();
		//
//			            JButton start = new JButton("시작");
//			            roadPanel = new RoadPanel();
		//
//			            add(label1);
//			            add(label2);
//			            add(label3);
//			            add(start);
//			            add(roadPanel);
		//
//			            start.setBounds(275, 450, 60, 50);
//			            start.addActionListener(new ActionListener() {
//			                public void actionPerformed(ActionEvent e) {
//			                    start.setEnabled(false);
//			                    new CarGameThread().start();
//			                }
//			            });
//			            label1.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
//			            label1.getActionMap().put("space", new AbstractAction() {
//			                public void actionPerformed(ActionEvent e) {
//			                    if (label1.getX() <= 600 && label2.getX() <= 600 && label3.getX() <= 600) {
//			                        label1.setLocation(label1.getX() + 10, label1.getY());
//			                    }
//			                    if (label1.getX() >= 600 || label2.getX() >= 600 || label3.getX() >= 600) {
//			                        start.setEnabled(true);
//			                    }
//			                }
//			            });
//			        }
//			        public void drawRoad() {
//			            roadPanel.repaint();
//			        }
//			        class CarGameThread extends Thread {
//			            public void run() {
//			                while (true) {
//			                    SwingUtilities.invokeLater(() -> label2.setLocation((int) (label2.getX() + 10 * Math.random()), label2.getY()));
//			                    SwingUtilities.invokeLater(() -> label3.setLocation((int) (label3.getX() + 10 * Math.random()), label3.getY()));
//			                    try {
//			                        Thread.sleep(70);
//			                    } catch (InterruptedException e) {
//			                        e.printStackTrace();
//			                    }
//			                    if (label2.getX() >= 600 || label3.getX() >= 600 || label1.getX() >= 600) {
//			                        break;
//			                    }
//			                }
//			                if (label1.getX() >= 600) {
//			                    System.out.println("car1 Win the game");
//			                }
//			                if (label2.getX() >= 600) {
//			                    System.out.println("car2 Win the game");
//			                }
//			                if (label3.getX() >= 600) {
//			                    System.out.println("car3 Win the game");
//			                }
//			                drawRoad();
//			            }
//			        }
//			    }
		//
//			    class RoadPanel extends JPanel {
//			        @Override
//			        public void paintComponent(Graphics g) {
//			            super.paintComponent(g);
//			            Graphics2D g2d = (Graphics2D) g;
//			            g2d.setColor(Color.BLACK);
//			            g2d.setStroke(new BasicStroke(5));
//			            g2d.drawLine(0, 450, 600, 450);
//			        }
//			    }
//			    // CardLayout에서 특정 카드를 보여주는 메소드
//			    private void showCard(String cardName) {
//			        cardLayout.show(cardPanel, cardName);
//			    }
			public void Cargame() {
				JPanel car=new JPanel();
				getContentPane().removeAll();
				getContentPane().repaint();
				//JPanel cr=new JPanel();
				label1=new JLabel();
				label2=new JLabel();
				label3=new JLabel();
				
				JButton start=new JButton("시작");
				//JButton back = new JButton("돌아가기");
				roadPanel=new RoadPanel();
				
				class cargame extends Thread{
					
					public void drawRoad() {
						//roadPanel.repaint();
						roadPanel.repaint();
					}
					public cargame() {
						JLabel label=new JLabel("스페이스 바를 많이 눌러서 우승하세요!");
						label.setFont(new Font("Serif",Font.BOLD,25));
						label.setBounds(120,50,450,50);
						car.add(label);
						
						label2.setIcon(new ImageIcon("C:\\Users\\KimMJ\\Downloads\\car1\\car2.gif"));
						label2.setBounds(100,150,100,100);
						car.add(label2);
						
						
						label3.setIcon(new ImageIcon("C:\\Users\\KimMJ\\Downloads\\car1\\car3.gif"));
						label3.setBounds(100, 200, 100, 100);
						car.add(label3);
						
						label1.setFocusable(true);
					}
					//JLabel car1w=new JLabel("car1 Win the game");
					//JLabel car2w=new JLabel("car2 Win the game");
					//JLabel car3w=new JLabel("car3 Win the game");
					public void run() {
						repaint();
						
						while(true) {
							SwingUtilities.invokeLater(() ->label2.setLocation((int) (label2.getX()+10*Math.random()),label2.getY()));
							SwingUtilities.invokeLater(() ->label3.setLocation((int) (label3.getX()+10*Math.random()),label3.getY()));
							try {
								Thread.sleep(70);
							}catch(InterruptedException e) {
								e.printStackTrace();
							}
							if (label2.getX()>=600 || label3.getX()>=600 || label1.getX()>=600) {
								break;
							}
						}
						if (label1.getX()>=600) {
							JOptionPane.showMessageDialog(car, "car1 Win the game");
							System.out.println("car1 Win the game");
						}
						if (label2.getX()>=600) {
							JOptionPane.showMessageDialog(car, "car2 Win the game");
//							car2w.setBounds(200,400,300,400);
//							car.add(car2w);
							System.out.println("car2 Win the game");
						}
						if (label3.getX()>=600) {
							JOptionPane.showMessageDialog(car, "car3 Win the game");
//							car3w.setBounds(200,400,300,400);
//							car.add(car3w);
							System.out.println("car3 Win the game");
						}
						drawRoad();
						start.setEnabled(true);
					}
				}
				setTitle("CarRace");
				setSize(700,500);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				car.setLayout(null);
				
				label1=new JLabel();
				label1.setIcon(new ImageIcon("C:\\Users\\KimMJ\\Downloads\\car1\\car1.gif"));
				label1.setBounds(100, 100, 100, 100);
				car.add(label1);
				cargame cg=new cargame();
				start.setBounds(275,350,60,50);
				start.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						cg.drawRoad();
						cg.start();
						start.setEnabled(false);
						
//						addKeyListener(new KeyListener() {
//							public void keyTyped(KeyEvent e) {}
//							public void keyReleased(KeyEvent e) {}
//							public void keyPressed(KeyEvent e) {
//								if(e.getKeyCode()==KeyEvent.VK_SPACE) {
//									label1.setLocation(label1.getX()+10,label1.getY());
//									if (label1.getX()>=600 || label2.getX()>=600 || label3.getX()>=600) {
//										removeKeyListener(this);
//									}
//								}
//							}
//						});
					}
				});
				
				label1.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "space");
		        label1.getActionMap().put("space", new AbstractAction() {
		            public void actionPerformed(ActionEvent e) {
		            	long currentTime = System.currentTimeMillis();
		            	long elapsedTime = currentTime - lastKeyPressTime;
		            	if (elapsedTime >= SPACE_IGNORE_INTERVAL) {
		            	cg.drawRoad();
		            	if (label1.getX()<=600 && label2.getX()<=600 && label3.getX()<=600) {
		            		label1.setLocation(label1.getX() + 10, label1.getY());
		            	}
		                if (label1.getX() >= 600 || label2.getX() >= 600 || label3.getX() >= 600) {
		                    start.setEnabled(true);
		                    //label1.setLocation(x,label1.getY());
		                }
		                lastKeyPressTime=currentTime;
		            	}
		            }
		        });
//		        back.setBounds(500, 500, 100, 40);
//		        add(back);
//				back.addActionListener(new ActionListener() {
//					//Game g=new Game();
//					public void actionPerformed(ActionEvent e) {
//						getContentPane().removeAll();
//		                getContentPane().repaint();
//		                
//		                setTitle("yourTurn");
//		                setSize(600, 600);
//		                getContentPane().setLayout(null);
//		                getContentPane().add(title);
//		                getContentPane().add(carbtn);
//		                setVisible(true);
//					}
//				});
		        
		        car.add(start);
		        car.add(roadPanel);
		        add(car);
				setVisible(true);
			}
			public void drawRoad() {
				roadPanel.repaint();
			}
			class RoadPanel extends JPanel {
		        @Override
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            Graphics2D g2d = (Graphics2D) g;
		            g2d.setColor(Color.BLACK);
		            g2d.setStroke(new BasicStroke(5));
		            g2d.drawLine(0, 450, 600, 450);
		        }
		    }
			int x,y;
			public void time() {
				getContentPane().removeAll();
				getContentPane().repaint();
				
				class Time extends Thread{
					private JLabel time, result;
					private JTextField input;
					int hour;
					
					public Time() {
						setLayout(null);
						setTitle("시간 맞추기");
						setSize(600,400);
//						JLabel time=new JLabel("00시 00분");
//						time.setBounds(200,200,100,50);
						
						time = new JLabel();
		                time.setBounds(100, 100, 200, 30);
		                add(time);

		                JLabel textLabel = new JLabel("오전/오후:");
		                textLabel.setBounds(100, 150, 100, 30);
		                add(textLabel);

		                input = new JTextField();
		                input.setBounds(200, 150, 100, 30);
		                add(input);

		                JButton checkBtn = new JButton("확인");
		                checkBtn.setBounds(320, 150, 80, 30);
		                add(checkBtn);

		                result = new JLabel();
		                result.setBounds(100, 200, 200, 30);
		                add(result);

		                checkBtn.addActionListener(new ActionListener() {
		                    public void actionPerformed(ActionEvent e) {
		                        checkAnswer();
		                    }
		                });
		            }

		            public void run() {
		                Random random = new Random();
		                this.hour = random.nextInt(24);
		                int minute = random.nextInt(60);
		                
		                String timeString = String.format("%02d시%02d분", hour, minute);
		                time.setText(timeString);
		            }

		            private void checkAnswer() {
		            	
		                String inputText = input.getText().trim().toLowerCase();
		                String timeString = time.getText();
		                boolean isCorrect=false;
		                if (hour>=12 && inputText.equals("오후"))
		                	isCorrect=true;
		                if(hour<12 && inputText.equals("오전"))
		                	isCorrect=true;

		                if (isCorrect) {
		                    result.setText("정답입니다!");
		                } else {
		                    result.setText("틀렸습니다.");
		                }
		            }

		            private boolean checkTime(String inputText, String timeString) {
		                String amPm = timeString.substring(6); // "오전" 또는 "오후"
		                int hour = Integer.parseInt(timeString.substring(0, 2));

		                if (amPm.equals("오후")) {
		                    hour += 12;
		                }

		                int inputHour = Integer.parseInt(inputText);

		                return hour == inputHour;
		            }
		        }

		        Time timeThread = new Time();
		        timeThread.start();

//		        JButton backBtn = new JButton("돌아가기");
//		        backBtn.setBounds(500, 500, 100, 40);
//		        add(backBtn);
//		        backBtn.addActionListener(new ActionListener() {
//		            public void actionPerformed(ActionEvent e) {
//		                getContentPane().removeAll();
//		                getContentPane().repaint();
////		                setTitle("yourTurn");
////		                setSize(600, 600);
////		                getContentPane().setLayout(null);
////		                getContentPane().add(title);
////		                getContentPane().add(carbtn);
////		                setVisible(true);
//		                setVisible(true);
//		            }
//		        });
		    }
//					}
//				}
//			}
//			public void Bubble(){
//				
//				Thread t = null;
//			    class Bubble extends JFrame{
//			    	private JLabel pointLabel;
//			        private int point;
//			        private Thread t;
//			        public Bubble() {
//			        	this.setTitle("버블 게임");
//			        	this.setSize(600,600);
//			        	
//			        	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			        	this.setLocationRelativeTo(getOwner());
//				        JPanel c=new JPanel();
//				        c.setLayout(new BorderLayout());
//				        
//				        JButton btn1=new JButton("시작");
//				        btn1.addActionListener(new ActionListener() {
//							@Override
//							public void actionPerformed(ActionEvent e) {
//								// TODO Auto-generated method stub
//								Thread t=new Thread(new Bubblethread());
//				            	t.start();
//							}
//				        });
//				        c.add(btn1,BorderLayout.SOUTH);
//				        
//				        pointLabel=new JLabel("Point:0");
//				        c.add(pointLabel,BorderLayout.NORTH);
//				        
//				        c.addMouseListener(new MouseListener(){
//				            public void mousePressed(MouseEvent e) {
//				            	if (point>=100) {
//				            		JOptionPane.showInputDialog(Bubble.this, "이겼습니다!");
////				            		new Thread(() -> {
////				                        // 예시로 5초 후에 interrupt
////										t.interrupt();
////			                        //t.interrupt();
////			                        return;
////				            	});
//				            		t.interrupt();
//				            		return;
//				            	}
//				            	Point p = e.getPoint();
//				                JLabel img = new JLabel(new ImageIcon("C:\\Users\\KimMJ\\Downloads\\bubble.jpg"));
//				                img.setBounds(p.x, p.y, 50, 50);
//				                c.add(img);
//				                repaint();
//				                
//				                t = new Thread(new Bubblethread(img));
//				                t.start();
//				            }
//				            public void mouseReleased(MouseEvent e) {}
//				            public void mouseClicked(MouseEvent e) {}
//				            public void mouseEntered(MouseEvent e) {}
//				            public void mouseExited(MouseEvent e) {}
//				            
//				        });
//				        add(c);
//				        this.setVisible(true);
//			        }
//			        
//			    class Bubblethread implements Runnable {
//			        private JLabel img;
//			        private final int bubble_move = 10;
//			        public Bubblethread() {
//			        }
//			        
//			        public Bubblethread(JLabel img) {
//			            this.img = img;
//			            SwingUtilities.invokeLater(()->{
//			            	add(img);
//			            	repaint();
//			            });
//			        }
//			        
//			        public void run() {
//			            while(true) {
//			            	if (point>=100) {
//			            		return;
//			            	}
//			            
//			                int x = img.getX();
//			                int y = img.getY();
//			                
//			                SwingUtilities.invokeLater(()->img.setLocation(x,y-bubble_move));
//			                
//			                if(img.getY() + img.getHeight() < 0) {
//			                    SwingUtilities.invokeLater(()->remove(img));
//			                }
//			                
//			                try {
//			                    Thread.sleep(20);
//			                }
//			                catch(InterruptedException e) { return; }
//			            }
//			        }
//			    }}
//			}
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				Game g=new Game();
			}

		

}
