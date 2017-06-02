import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int xSpeed;
	int ySpeed;

	
	Rocketship(int x, int y, int width, int height){
		super(x, y, width, height);
		xSpeed = 0;
		ySpeed = 0;
	}

	void update(){
		super.update();
		x += xSpeed*4;
		y += ySpeed*4;
		
		
	}
	
	void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	

}
