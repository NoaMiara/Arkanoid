

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter counter;
    private Rectangle rectangle;


    /**
     * Instantiates a new Score indicator.
     *
     * @param counter   the counter
     * @param rectangle the rectangle
     */
    public ScoreIndicator(Counter counter, Rectangle rectangle) {
        this.counter = counter;
        this.rectangle = rectangle;
    }

    /**
     * Set counter.
     *
     * @param counter1 the counter 1
     */
    public void setCounter(Counter counter1) {
        this.counter = counter1;
    }

    @Override
    /**
     * draw on.
     *
     * @param d the DrawSurface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawText(260, 16, "Score: " + counter.getValue(), 15);
    }

    /**
     * Add to game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * time Passed.
     */
    @Override
    public void timePassed() {
    }
}
