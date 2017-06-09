import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	//Member Variables
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Timer timer;
	Font titleFont;
	Rocketship rocketShip = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	
	
	//Constructor
	GamePanel(){
		timer = new Timer(1000/60, this);
		this.startGame();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		manager.addObject(rocketShip); 
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


			}
	
	void startGame(){
		
		timer.start();
		
	}
	
	
	void updateMenuState(){
		
	}
	
	void updateGameState(){
	manager.update();
	manager.manageEnemies();
	manager.checkCollision();
	//Reset
	if(rocketShip.isAlive == false){
	currentState = 2;
	manager.reset();
	rocketShip = new Rocketship(250, 700, 50, 50);
	manager.addObject(rocketShip);
	}
	}

	void updateEndState(){
		
	}
	
	//Draw States
	void drawMenuState(Graphics g){
		g.drawImage(spaceImg, 0, 0, LeagueInvaders.FRAME_WIDTH, LeagueInvaders.FRAME_HEIGHT, null);		
		g.setFont(titleFont);
		g.setColor(Color.BLUE);
		g.drawString("Leauge Invaders", 70, 200);
		g.drawString("START GAME", 85, 250);
		manager.score = 0;
	}

	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.drawImage(spaceImg, 0, 0, LeagueInvaders.FRAME_WIDTH, LeagueInvaders.FRAME_HEIGHT, null);		
		manager.draw(g);
	}

	void drawEndState(Graphics g){
		g.drawImage(spaceImg, 0, 0, LeagueInvaders.FRAME_WIDTH, LeagueInvaders.FRAME_HEIGHT, null);		
		g.setFont(titleFont);
		g.setColor(Color.RED);
		g.drawString("GAME OVER", 100, 200);
		g.drawString("restart", 180, 250);
		g.drawString("You killed "+ manager.getScore() +" aliens!", 50, 400);
	
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
				manager.reset();
				rocketShip = new Rocketship(250, 700, 50, 50);
				manager.addObject(rocketShip);
				manager.score = 0;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			Projectile pro = new Projectile(rocketShip.x+rocketShip.width/2 -5, rocketShip.y, 10, 10);
			manager.addObject(pro);
			}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			rocketShip.ySpeed=-2;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			rocketShip.ySpeed=+2;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rocketShip.xSpeed=+2;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			rocketShip.xSpeed=-2;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key released");
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			rocketShip.ySpeed= 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			rocketShip.ySpeed=0;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rocketShip.xSpeed=0;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			rocketShip.xSpeed=0;
		}
	}
	
	
	
}
