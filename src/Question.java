import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a single question in the game with possible answers,
 * the correct answer, a hint, and a fun fact.
 */


public class Question {
    private String questionText;
    private List<String> answerChoices;
    private String correctAnswer;
    private String hint;
    private String funFact;

    public Question(String questionText, String correctAnswer, String hint, String funFact, String... choices) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.funFact = funFact;
        this.answerChoices = new ArrayList<>(Arrays.asList(choices));
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < answerChoices.size(); i++) {
            System.out.println((i + 1) + ". " + answerChoices.get(i));
        }
    }

    public boolean isCorrect(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }

    public String getHint() {
        return hint;
    }

    public void revealAnswer() {
        System.out.println("Correct answer: " + correctAnswer);
    }

    public void displayFunFact() {
        System.out.println("Fun Fact: " + funFact);
    }
}

