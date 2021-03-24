

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level indicator.
 */
public class LevelIndicator implements Sprite {
    private String string;

    /**
     * Instantiates a new Level indicator.
     *
     * @param string the string
     */
    public LevelIndicator(String string) {
        this.string = string;
    }

    /**
     * draw On.
     *
     * @param d the DrawSurface.
     */

    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(450, 16, this.string, 15);
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

