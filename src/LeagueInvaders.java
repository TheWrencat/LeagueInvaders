import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	GamePanel panel;
	final int FRAMEWIDTH = 500;
	final int FRAMEHEIGHT = 800;
	
	LeagueInvaders(){
		
		frame = new JFrame();
		panel = new GamePanel();
		
		
	}
	
	void setup(){
		
		frame.setVisible(true);
		frame.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		LeagueInvaders LeagueInvaders = new LeagueInvaders();
		LeagueInvaders.setup();
	}
	
}
