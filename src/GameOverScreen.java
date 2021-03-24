
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Game over screen.
 */
public class GameOverScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;

    /**
     * Instantiates a new Game over screen.
     *
     * @param k     the KeyboardSensor.
     * @param score the score.
     */
    public GameOverScreen(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    /**
     * Instantiates a new Game over screen.
     *
     * @param d the DrawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + score, 32);
    }

    /**
     * boolean should Stop.
     *
     * @return stop.
     */

    public boolean shouldStop() {
        return this.stop;
    }
}
