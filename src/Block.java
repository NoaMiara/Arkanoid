
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private double width;
    private Point upperLeft;
    private double height;
    private Color color;
    private Rectangle rectangle;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new Block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.height = rectangle.getHeight();
        this.width = rectangle.getWidth();
        this.upperLeft = rectangle.getUpperLeft();
        this.rectangle = new Rectangle(upperLeft, width, height);
    }

    /**
     * Return the "collision shape" of the object.
     *
     * @return rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }


    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * The return is the new velocity expected after the hit (based on the force the object inflicted on us).
     *
     * @param collisionPoint  the closest point.
     * @param currentVelocity the velocity.
     * @param hitter          the ball.
     * @return Velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        //We will create 4 lines from the barrier frame (rectangle shaped).
        Line l1 = new Line(this.getCollisionRectangle().getUpperLeft(), this.getCollisionRectangle().getDownLeft());
        Line l2 = new Line(this.getCollisionRectangle().getDownLeft(), this.getCollisionRectangle().getDownRight());
        Line l3 = new Line(this.getCollisionRectangle().getDownRight(), this.getCollisionRectangle().getUpperRight());
        Line l4 = new Line(this.getCollisionRectangle().getUpperLeft(), this.getCollisionRectangle().getUpperRight());
        // We will check if the point is within the line range (on one of the ribs), this means that a collision is
        // expected, so we will change the speed. We will differentiate between side and bottom and bottom injuries.
        if (l1.isIn(collisionPoint) || l3.isIn(collisionPoint)) {
            dx = -dx;
        }
        if (l2.isIn(collisionPoint) || l4.isIn(collisionPoint)) {
            dy = -dy;
        }
        //the return is the new velocity expected after the hit.
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    /**
     * We will paint the rectangles and create a frame for them.
     *
     * @param drawSurface the rectangle.
     */
    public void drawOn(DrawSurface drawSurface) {
        drawSurface.setColor(this.color);
        drawSurface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        drawSurface.setColor(Color.BLACK);
        drawSurface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add to game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    @Override
    /**
     * add HitListener.
     *
     * @param hl the HitListener.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * remove HitListener.
     *
     * @param hl the HitListener.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * notifyHit.
     *
     * @param hitter the ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


}
