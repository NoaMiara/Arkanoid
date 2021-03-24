

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int paddleSpeed;

    /**
     * Instantiates a new Paddle- Consisting of rectangle, color and it moves with the help of a keyboard.
     *
     * @param rectangle   the rectangle
     * @param color       the color
     * @param keyboard    the keyboard
     * @param paddleSpeed the paddle Speed
     */
    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboard, int paddleSpeed) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.color = color;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        //If its displacement distance in the X axis is less than 20 (the X value of the left rectangle in the panel).
        if (this.rectangle.getUpperLeft().getX() > 20) {
            //Move 10 steps to the left
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() - paddleSpeed,
                    this.rectangle.getUpperLeft().getY()));
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        //If its displacement distance in the X axis is less than 780 (the X value of the right rectangle in the panel).
        if ((this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth()) < 780) {
            //Take 10 steps to the right
            this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() + paddleSpeed,
                    this.rectangle.getUpperLeft().getY()));
        }
    }

    /**
     * Sprite - A method that checks the movement of the paddle according to the right or left keyboard.
     */
    public void timePassed() {
        //If pressed the left button on the keyboard, a function that moves to the left will be sent.
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
            // If pressed the right button on the keyboard, a function that moves to the right will be sent.
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * We will paint the paddle.
     *
     * @param d drawSurface the rectangle.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * get Collision Rectangle.
     *
     * @return Rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * The Paddle as having 5 equally-spaced regions. The behavior of the ball's bounce depends on where it hits
     * the paddle. We'll see which part of the paddle the ball hits, according to instructions we'll change the speed
     *
     * @param collisionPoint  the closest point.
     * @param currentVelocity the velocity.
     * @param hitter          the ball.
     * @return Velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //Define a variable that checks the size of a fifth of the Paddle width.
        double newWidth = this.rectangle.getWidth() / 5;
        //We will create 5 different lines so that each line forms part of the top of rib of  Paddle
        Line l1 = new Line(this.rectangle.getUpperLeft().getX(), this.rectangle.getUpperLeft().getY(),
                this.rectangle.getUpperLeft().getX() + newWidth, this.rectangle.getUpperLeft().getY());
        Line l2 = new Line(this.rectangle.getUpperLeft().getX() + newWidth, this.rectangle.getUpperLeft().getY(),
                this.rectangle.getUpperLeft().getX() + 2 * newWidth, this.rectangle.getUpperLeft().getY());
        Line l3 = new Line(this.rectangle.getUpperLeft().getX() + 2 * newWidth, this.rectangle.getUpperLeft().getY(),
                this.rectangle.getUpperLeft().getX() + 3 * newWidth, this.rectangle.getUpperLeft().getY());
        Line l4 = new Line(this.rectangle.getUpperLeft().getX() + 3 * newWidth, this.rectangle.getUpperLeft().getY(),
                this.rectangle.getUpperLeft().getX() + 4 * newWidth, this.rectangle.getUpperLeft().getY());
        Line l5 = new Line(this.rectangle.getUpperLeft().getX() + 4 * newWidth, this.rectangle.getUpperLeft().getY(),
                this.rectangle.getUpperLeft().getX() + 5 * newWidth, this.rectangle.getUpperLeft().getY());
        Velocity velocity = currentVelocity;
        //If we find that the point is within the range of the line, we will change the speed accordingly.
        if (l1.isIn(collisionPoint)) {
            velocity = Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        } else if (l2.isIn(collisionPoint)) {
            velocity = Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
        } else if (l3.isIn(collisionPoint)) {
            velocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        } else if (l4.isIn(collisionPoint)) {
            velocity = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
        } else if (l5.isIn(collisionPoint)) {
            velocity = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }
        return velocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}