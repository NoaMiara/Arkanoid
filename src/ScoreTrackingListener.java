

/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentS;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentS = scoreCounter;
    }

    /**
     * hitEvent.
     *
     * @param beingHit the block.
     * @param hitter   the Ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentS.increase(5);
    }

    /**
     * Gets current score.
     *
     * @return the current score
     */
    public Counter getCurrentScore() {
        return currentS;
    }

    /**
     * Set current score.
     *
     * @param currentScore the current score 1
     */
    public void setCurrentS(int currentScore) {
        this.currentS.increase(currentScore);
    }

    /**
     * Sets score.
     *
     * @param currentScore the current score.
     */
    public void setScore(int currentScore) {
        this.currentS = new Counter(currentScore);
    }
}