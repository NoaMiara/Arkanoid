

import biuoop.DrawSurface;

/**
 * The interface Sprite.
 */
public interface Sprite {
    /**
     * Draw on - // draw the sprite to the screen.
     *
     * @param d the DrawSurface.
     */
    void drawOn(DrawSurface d);

    /**
     * Time passed- notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * Add to game.
     *
     * @param gameLevel the game level
     */
    void addToGame(GameLevel gameLevel);
}