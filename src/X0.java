import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class X0 extends JFrame {

	private JPanel contentPane;
	private int playerNum = 1;
	private boolean[] arrayx = new boolean[9];
	private boolean[] arrayo = new boolean[9];
	private boolean win = false;
	private JTextArea text = new JTextArea();
	//private AIPlayerMinimax AIPlayer = new AIPlayerMinimax(bool_to_board(arrayx, arrayo));
	
	private Board bool_to_board(boolean[] arrayx, boolean[] arrayo){
		Board board = new Board();
		for(int i = 0; i < 9; i++){
			if(arrayx[i] == true){
				if(i < 3) board.cells[0][i].content = Seed.CROSS;
				else if(i < 6) board.cells[1][i-3].content = Seed.CROSS;
				else if(i < 9) board.cells[2][i-6].content = Seed.CROSS;
			}else if(arrayo[i] == true){
				if(i < 3) board.cells[0][i].content = Seed.NOUGHT;
				else if(i < 6) board.cells[1][i-3].content = Seed.NOUGHT;
				else if(i < 9) board.cells[2][i-6].content = Seed.NOUGHT;
			}
		}
		return board;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					X0 frame = new X0();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class Listen implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evt) {
			repaint();
			win = false;
			text.setText("");
			arrayx = new boolean[9];
			arrayo = new boolean[9];
			playerNum = 1;
			
		}
		
	}

	public class Draw extends JPanel implements MouseListener {

		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			g.setColor(Color.BLACK);
			g.drawLine(200, 0, 200, 200);
			g.drawLine(200, 200, 0, 200);
			g.drawLine(0, 200, 0, 0);
			g.drawLine(0, 0, 200, 0);

			g.setColor(Color.BLACK);
			g.drawLine(70, 0, 70, 200);
			g.drawLine(130, 0, 130, 200);
			g.drawLine(0, 70, 200, 70);
			g.drawLine(0, 130, 200, 130);

		}

		public void Winner(boolean[] array, int player) {
			Graphics g = getGraphics();
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(10));
			g.setColor(Color.YELLOW);
			
			if ((array[0] && array[1]) && array[2]) {
				g2.draw(new Line2D.Float(6, 35, 195, 35));
				win = true;
			} else if (array[3] && array[4] && array[5]) {
				
				g2.draw(new Line2D.Float(6, 100, 195, 100));
				win = true;
			} else if (array[6] && array[7] && array[8]) {
				
				g2.draw(new Line2D.Float(6, 175, 195, 175));
				win = true;
			} else if (array[0] && array[3] && array[6]) {
				
				g2.draw(new Line2D.Float(30, 6, 30, 195));
				win = true;
			} else if (array[1] && array[4] && array[7]) {
				
				g2.draw(new Line2D.Float(100, 6, 100, 195));
				win = true;
			} else if (array[2] && array[5] && array[8]) {
				
				g2.draw(new Line2D.Float(168, 6, 168, 195));
				win = true;
			} else if (array[0] && array[4] && array[8]) {
				
				g2.draw(new Line2D.Float(5, 5, 195, 195));
				win = true;
			} else if (array[2] && array[4] && array[6]) {
				
				g2.draw(new Line2D.Float(195, 5, 5, 195));
				win = true;
			}
			
			if(win&&player==1){
				
				text.setText("PLAYER 1 WINS!!!");
			}else if(win&&player==2){
				g.setColor(Color.BLUE);
				text.setText("PLAYER 2 WINS!!!");
			}
		}

		public void mouseClicked(MouseEvent evt) {
			Graphics g = getGraphics();
			int x = evt.getX();
			int y = evt.getY();

			if (win == false) {
				if (playerNum == 1) {
					g.setColor(Color.RED);
					if (x < 75 && y < 75) {
						if (arrayx[0] == true || arrayo[0] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 10, 60);
						arrayx[0] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 135 && y < 75) {
						if (arrayx[1] == true || arrayo[1] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 80, 60);
						arrayx[1] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 205 && y < 75) {
						if (arrayx[2] == true || arrayo[2] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 145, 60);
						arrayx[2] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 75 && y < 135) {
						if (arrayx[3] == true || arrayo[3] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 10, 120);
						
						arrayx[3] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 135 && y < 135) {
						if (arrayx[4] == true || arrayo[4] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 80, 120);
						
						arrayx[4] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 205 && y < 135) {
						if (arrayx[5] == true || arrayo[5] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 145, 120);
						
						arrayx[5] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 75 && y < 205) {
						if (arrayx[6] == true || arrayo[6] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 10, 190);
						
						arrayx[6] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 135 && y < 205) {
						if (arrayx[7] == true || arrayo[7] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 80, 190);
						
						arrayx[7] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					} else if (x < 205 && y < 205) {
						if (arrayx[8] == true || arrayo[8] == true) {
							return;
						}
						g.setFont(new Font("TimesRoman", Font.BOLD, 60));
						g.drawString("X", 145, 190);
						
						arrayx[8] = true;
						Winner(arrayx,playerNum);
						playerNum = 2;
						player2_move(g);
						return;

					}

				}

				
			}

		}

		public void player2_move(Graphics g){
			if (playerNum == 2) {
				g.setColor(Color.BLUE);
				AIPlayerMinimax AIPlayer = new AIPlayerMinimax(bool_to_board(arrayx, arrayo));
				int[] move = AIPlayer.move();
				
				if (move[0] == 0 && move[1] == 0) { //x < 75 && y < 75
					if (arrayo[0] == true || arrayx[0] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 10, 60);
					
					arrayo[0] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 0 && move[1] == 1) { //x < 135 && y < 75
					if (arrayo[1] == true || arrayx[1] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 80, 60);
					
					arrayo[1] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 0 && move[1] == 2) { //x < 205 && y < 75
					if (arrayo[2] == true || arrayx[2] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 145, 60);
					
					arrayo[2] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 1 && move[1] == 0) { //x < 75 && y < 135
					if (arrayo[3] == true || arrayx[3] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 10, 120);
					
					arrayo[3] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 1 && move[1] == 1) { //x < 135 && y < 135
					if (arrayo[4] == true || arrayx[4] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 80, 120);
					
					arrayo[4] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 1 && move[1] == 2) { //x < 205 && y < 135
					if (arrayo[5] == true || arrayx[5] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 145, 120);
					
					arrayo[5] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 2 && move[1] == 0) { //x < 75 && y < 205
					if (arrayo[6] == true || arrayx[6] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 10, 190);
					
					arrayo[6] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 2 && move[1] == 1) { //x < 135 && y < 205
					if (arrayo[7] == true || arrayx[7] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 80, 190);
					
					arrayo[7] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				} else if (move[0] == 2 && move[1] == 2) { //x < 205 && y < 205
					if (arrayo[8] == true || arrayx[8] == true) {
						return;
					}
					g.setFont(new Font("TimesRoman", Font.BOLD, 60));
					g.drawString("O", 145, 190);
					
					arrayo[8] = true;
					Winner(arrayo,playerNum);
					playerNum = 1;
					return;

				}

			}
		}
		
		@Override
		public void mouseEntered(MouseEvent evt) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent evt) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent evt) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent evt) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * Create the frame.
	 */
	public X0() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 350, 350);
		contentPane = new JPanel();
		Draw paint = new Draw();
		paint.setBackground(Color.white);
		setResizable(false);
		text.setEditable(false);
		JButton button = new JButton("RESTART");
		Listen listener  = new Listen();
		button.addActionListener(listener);
		

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(paint,BorderLayout.CENTER);
		contentPane.add(text, BorderLayout.SOUTH);
		contentPane.addMouseListener(paint);
		contentPane.add(button, BorderLayout.EAST);

	}
}
