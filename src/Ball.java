

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Ball.
 */
public class Ball implements Sprite {
    // constructor
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new Ball.
     *
     * @param x     the x
     * @param y     the y
     * @param r     the r
     * @param color the color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.gameEnvironment = new GameEnvironment();
    }

    /**
     * Gets x.
     *
     * @return the x of center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y of center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets color of center point.
     *
     * @return the color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw draw the ball on the given DrawSurface.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), r);
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), r);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Sets velocity.
     *
     * @param v the velocity of the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity.
     *
     * @param dx the distance.
     * @param dy the distance.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }


    /**
     * Move one step-check can the ball make the move if it has no obstacles in the way.
     * If there is, we will tell him to get almost to the point of the barrier and go back.
     */
    public void moveOneStep() {
        //We will create a line that checks the movement of the ball.
        Line trajectory = new Line(this.center.getX(), this.center.getY(),
                this.center.getX() + this.velocity.getDx(), this.center.getY() + this.velocity.getDy());
        //We will get information for the closest barrier.
        CollisionInfo info = this.gameEnvironment.getClosestCollision(trajectory);
        //If there is information about an obstacle on the way, we will almost change our direction before reaching
        // the barrier.
        if (info != null) {
            this.center = new Velocity(-0.2 * this.velocity.getDx(),
                    -0.2 * this.velocity.getDy()).applyToPoint(this.center);
            this.velocity = info.collisionObject().hit(this, info.collisionPoint(), this.velocity);
            //Otherwise, we will allow it to reach its destination
        } else {
            this.center = this.velocity.applyToPoint(this.center);
        }
    }



    /**
     * Sets game environment.
     *
     * @param gameEnvironment1 the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * Gets game environment.
     *
     * @return the game environment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        this.setGameEnvironment(g.getEnvironment());
    }

    /**
     * remove From Game.
     *
     * @param game the game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}