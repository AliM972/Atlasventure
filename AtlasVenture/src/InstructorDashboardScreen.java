import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

public class InstructorDashboardScreen extends GameScreen {
    
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 600;
    
    public InstructorDashboardScreen() {
        initialize();
    }
    
    @Override
    protected void initialize() {
        this.setLayout(new BorderLayout()); // Set the layout for the main panel.
        this.setBackground(Color.gray);
        this.setFocusable(true);
        
        // Create a panel that will hold all the content.
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(Color.gray);
        contentPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, 950)); // Adjust the height as necessary.

        // Add title.
        JLabel title = new JLabel("Instructor Dashboard");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        title.setForeground(Color.black);
        title.setSize(650, 100);
        title.setLocation((SCREEN_WIDTH - title.getWidth()) / 2, 0);
        contentPanel.add(title);
        
        // Add back button.
        JButton backToMain = new JButton();
		ImageIcon backIcon = new ImageIcon("back.png");
		backToMain.setIcon(backIcon);
		backToMain.setBounds(10, 10, 60, 60);
		backToMain.setBackground(null);
		this.add(backToMain);
        
        // Method to create player panels.
        contentPanel.add(createPlayerPanel("Player 1", 320, 4, "1, 2, 3", 5, 100));
        contentPanel.add(createPlayerPanel("Player 2", 300, 3, "1, 2", 5, 375));
        contentPanel.add(createPlayerPanel("Player 3", 250, 4, "1, 2, 3", 1, 650));
        
        // Wrap the content panel in a scrollpane.
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(15);
        this.add(scrollPane, BorderLayout.CENTER); // Add the scrollPane to the main panel.
    }

    // Helper method to create player panels.
    private JPanel createPlayerPanel(String playerName, int score, int level, String levelsCompleted, int attempts, int yPos) {
        JPanel playerPanel = new JPanel();
        playerPanel.setBackground(Color.white);
        Border blackBorder = BorderFactory.createLineBorder(Color.black, 3);
        playerPanel.setBorder(blackBorder);
        playerPanel.setLayout(null);
        playerPanel.setBounds(100, yPos, 600, 250);
        
        JLabel playerLabel = new JLabel(playerName);
        playerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        playerLabel.setForeground(Color.black);
        playerLabel.setBounds(50, 10, 400, 50);
        
        String details = String.format("<html>Current Score: %d<br/>"
                + "Current Level: %d<br/>"
                + "Levels Completed: %s<br/>"
                + "Number of attempts per level: %d</html>", score, level, levelsCompleted, attempts);
        JLabel playerStats = new JLabel(details);
        playerStats.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        playerStats.setForeground(Color.black);
        playerStats.setBounds(50, 75, 400, 150);
        
        playerPanel.add(playerLabel);
        playerPanel.add(playerStats);
        
        return playerPanel;
    }
    
    @Override
    public void updateScreen() {
        repaint();
    }

    @Override
    public void activate() {
        this.setVisible(true);
    }

    @Override
    public void deactivate() {
        this.setVisible(false);
    }

    @Override
    protected void handleInput() {
        // Handle user input if necessary.
    }
}
