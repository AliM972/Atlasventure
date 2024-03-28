import java.awt.Dimension;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	public GameFrame() {
		MainMenuScreen mainMenu = new MainMenuScreen();
		HighScoreScreen highScores = new HighScoreScreen();
		GameplayScreen gameplay = new GameplayScreen();
		InstructorDashboardScreen dashboard = new InstructorDashboardScreen();
		GameModeScreen gameMode = new GameModeScreen();
		TutorialScreen tutorial = new TutorialScreen();
		
//		this.add(mainMenu);
//		this.add(highScores);
//		this.add(gameplay);
//		this.add(dashboard);
//		this.add(gameMode);
		this.add(tutorial);
		
		this.setTitle("AtlasVenture");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false); 
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
}