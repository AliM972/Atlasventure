import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameManager implements ActionListener {
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private String currentState;
    private Timer gameLoopTimer;

    public GameManager() {
        initializeGameWindow();
        initializeGameLoop();
        changeGameState("MAIN_MENU");
    }

    private void initializeGameWindow() {
        // Initialize the main game window
        mainFrame = new JFrame("AtlasVenture");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 800); // Set the size of the game window
        mainFrame.setLocationRelativeTo(null); // Center the window on the screen

        // Set up the panel with CardLayout for switching game screens
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // add game screens to the cardPanel:
        MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
        cardPanel.add(mainMenuScreen, "MAIN_MENU");
        HighScoreScreen highScoreScreen = new HighScoreScreen(this);
        cardPanel.add(highScoreScreen, "HIGH_SCORES");

        // Add the card panel to the main frame
        mainFrame.add(cardPanel);

        // Display the main window
        mainFrame.setVisible(true);
    }

    private void initializeGameLoop() {
         // Set up a game loop timer that calls actionPerformed every 16 ms (~60 FPS)
         gameLoopTimer = new Timer(16, this);
         gameLoopTimer.start();
    }

    public void changeGameState(String newState) {
        // Update the currentState
        currentState = newState;

        // Change the displayed screen based on the newState
        cardLayout.show(cardPanel, newState);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    // Main method
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new GameManager());
    }

}
