import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	int ySpeed = 1;
	int xSpeed = 1;
	
	
	Alien(int x, int y, int width, int height){
		super(x, y, width, height);
	
	}
	void update(){
		super.update();
		y += ySpeed;
		int alienMove = new Random().nextInt(2);
		if (alienMove == 1){
			x+= xSpeed;
		}else if(alienMove == 0){
			x -= xSpeed;
		}
		
			
		}
		
		void draw(Graphics g){
			g.setColor(Color.YELLOW);
			g.drawImage(GamePanel.alienImg, x, y, width, height, null);

		}
		
}
