import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Timer timer;
	
	GamePanel(){
		timer = new Timer(1000/60, this);
		this.startGame();
			}
	
	void startGame(){
		
		timer.start();
		
	}
	
	
	void updateMenuState(){
		
	}
	
	void updateGameState(){
		
	}

	void updateEndState(){
		
	}
	

	void drawMenuState(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.FRAME_WIDTH, LeagueInvaders.FRAME_HEIGHT);
	}

	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.FRAME_WIDTH, LeagueInvaders.FRAME_HEIGHT);
	}

	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.FRAME_WIDTH, LeagueInvaders.FRAME_HEIGHT);
	}
	
	
	public void paintComponent(Graphics g){
		g.fillRect(10, 10, 100, 100);
		
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if (currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}
	
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		if(currentState == MENU_STATE){
			updateMenuState();
		}else if (currentState == GAME_STATE){
			updateGameState();
		}else if(currentState == END_STATE){
			updateEndState();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("key pressed");
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			currentState++;
			if(currentState > END_STATE){
				currentState = MENU_STATE;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key released");
	}
	
	
	
}
