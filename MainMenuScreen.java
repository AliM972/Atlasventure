import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuScreen extends JPanel {
    private JButton highScoreButton;
    private GameManager gameManager;

    public MainMenuScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        initializeUI();
    }

    private void initializeUI() {
        highScoreButton = new JButton("View High Scores");
        highScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.changeGameState("HIGH_SCORES");
            }
        });
        this.add(highScoreButton);
    }
}
