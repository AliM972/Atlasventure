import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoreScreen extends JPanel {
    private JButton returnButton;
    private GameManager gameManager;
    private JList<String> highScoreList;

    public HighScoreScreen(GameManager gameManager) {
        this.gameManager = gameManager;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        highScoreList = new JList<>();
        //placeholder data
        String[] placeholderScores = new String[] {"Alice: 1000", "Bob: 900", "Charlie: 800"};
        highScoreList.setListData(placeholderScores);
        this.add(new JScrollPane(highScoreList));

        returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.changeGameState("MAIN_MENU");
            }
        });
        this.add(returnButton);
    }
}
