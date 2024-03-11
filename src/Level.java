import java.util.ArrayList;
import java.util.List;

/**
 * Represents a level in the game which consists of a list of questions.
 */


public class Level {
    private int levelNum;
    private int currentQuestionIndex;
    private List<Question> questions;
    private int score;

    public Level(int levelNum) {
        this.levelNum = levelNum;
        this.currentQuestionIndex = -1; // So that the first question is at index 0
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        } else {
            return null;
        }
    }

    public void resetLevel() {
        currentQuestionIndex = -1;
        score = 0;
    }

    public int calculateScore(boolean correct) {
        if (correct) {
            score++;
        }
        return score;
    }

    public boolean isLevelCompleted() {
        return currentQuestionIndex >= questions.size() - 1;
    }

    public int getLevelNum() {
        return levelNum;
    }
}
