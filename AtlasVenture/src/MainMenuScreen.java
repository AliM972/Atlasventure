import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MainMenuScreen extends GameScreen {
	
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	private int selectedOption;
	private ArrayList<JButton> menuOptions;
	
	public MainMenuScreen() {
		
		initialize();

	}
	
	@Override
	public void initialize() {

		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.gray);
		this.setFocusable(true);
		this.setLayout(null);
		
		JLabel title = new JLabel("AtlasVenture");
		title.setHorizontalAlignment(JLabel.CENTER); 
		title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		title.setForeground(Color.white);
		title.setSize(400, 100);
        title.setLocation((SCREEN_WIDTH - title.getWidth()) / 2, 0);
        this.add(title); 
		
		menuOptions = new ArrayList<JButton>();
		
		menuOptions.add(new JButton("New Game"));
		menuOptions.add(new JButton("Load Saved Game"));
		menuOptions.add(new JButton("Tutorial"));
		menuOptions.add(new JButton("High Scores"));
		menuOptions.add(new JButton("Instructor Dashboard"));
		menuOptions.add(new JButton("Debug Mode"));
		menuOptions.add(new JButton("Exit"));
		
		for(int i = 0, y = 115; i < menuOptions.size(); i++, y+=60) {
			JButton currentButton = menuOptions.get(i);
			currentButton.setBounds(25,y,300,50);
			currentButton.setBackground(Color.white);
			currentButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			this.add(currentButton);
		}
		
		String paragraph = "<html>Team 43<br/>"
                + "Ali, Het, Nikunj, Hamza, Prabnoor<br/>"
                + "Winter 2024<br/>"
                + "CS2212 Western University</html>";
        JLabel projectDetails = new JLabel(paragraph);
        projectDetails.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        projectDetails.setForeground(Color.WHITE);
        projectDetails.setSize(250, 100);
        projectDetails.setLocation(600, 500);
        this.add(projectDetails);
        
		ImageIcon icon = new ImageIcon("earth.jpg");
		JLabel image = new JLabel(icon);
		image.setBounds(100,0,700,600);
		this.add(image);
	}

	@Override
	public void updateScreen() {
		repaint();
	}

	@Override
	public void activate() {
	}

	@Override
	public void deactivate() {
	}

	@Override
	public void handleInput() {
	}

}
