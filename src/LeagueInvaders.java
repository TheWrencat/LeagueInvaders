import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	GamePanel panel;
	static final int FRAME_WIDTH = 500;
	static final int FRAME_HEIGHT = 800;
	
	LeagueInvaders(){
		
		frame = new JFrame();
		panel = new GamePanel();
		
		
	}
	
	void setup(){
		
		frame.setVisible(true);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		LeagueInvaders LeagueInvaders = new LeagueInvaders();
		LeagueInvaders.setup();
	}
	
}
