

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Sprite collection.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.sprites = new LinkedList<>();
    }

    /**
     * Add sprite.
     *
     * @param s the Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Notify all time passed- call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> newListSprite = new ArrayList<>(sprites);
        for (Sprite s : newListSprite) {
            s.timePassed();
        }
    }

    /**
     * Draw all on-call drawOn(d) on all sprites.
     *
     * @param d the DrawSurface .
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }
}