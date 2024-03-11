/**
 * The HintSystem class manages the hints mechanism in the game,
 * keeping track of available free hints, their cost, and the player's points.
 */


public class HintSystem {
    private int freeHints;
    private int hintCost;
    private int playerPoints;

    // Constructor to initialize the hint system with free hints and cost per hint
    public HintSystem(int freeHints, int hintCost, int playerPoints) {
        this.freeHints = freeHints;
        this.hintCost = hintCost;
        this.playerPoints = playerPoints;
    }

    // Provides a hint to the player if they have free hints or enough points
    public String provideHint(Question question) {
        if (freeHints > 0) {
            freeHints--;  // Use a free hint
            return question.getHint();
        } else if (playerPoints >= hintCost) {
            playerPoints -= hintCost;  // Deduct points for a hint
            return question.getHint();
        } else {
            return "Not enough points to get a hint.";
        }
    }

    // Checks if there are free hints available
    public boolean checkFreeHintAvailability() {
        return freeHints > 0;
    }

    // Deducts points from the player, if they have enough
    public boolean deductPoints(int points) {
        if (playerPoints >= points) {
            playerPoints -= points;
            return true;
        } else {
            return false;
        }
    }

    // Confirm if the player has enough points to purchase a hint
    public boolean confirmPurchase() {
        return playerPoints >= hintCost;
    }

    // Display a message if the player does not have enough points for a hint
    public void displayInsufficientPointsMessage() {
        System.out.println("Insufficient points. You need at least " + hintCost + " points to buy a hint.");
    }

    // Handle the logic for using a hint
    public void handleHintUsage(Question question) {
        String message = provideHint(question);
        System.out.println(message);
    }

    // Getters and Setters for freeHints, hintCost, and playerPoints
    public int getFreeHints() {
        return freeHints;
    }

    public void setFreeHints(int freeHints) {
        this.freeHints = freeHints;
    }

    public int getHintCost() {
        return hintCost;
    }

    public void setHintCost(int hintCost) {
        this.hintCost = hintCost;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    // Additional method to add points for the player
    public void addPoints(int points) {
        this.playerPoints += points;
    }
}