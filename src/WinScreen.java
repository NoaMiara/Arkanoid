

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Win screen.
 */
public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;

    /**
     * Instantiates a new Win screen.
     *
     * @param k     the k.
     * @param score the score.
     */
    public WinScreen(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    /**
     * One Frame.
     *
     * @param d the DrawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(230, 145, 17));
        d.fillRectangle(0, 10, 800, 600);
        d.setColor(Color.WHITE);
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score, 32);
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
