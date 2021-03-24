

/**
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;
    // private double speed;

    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx.
     * @param dy the dy.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * From angle and speed velocity.
     *
     * @param angle the ball.
     * @param speed the ball.
     * @return the new velocity of the ball.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //angle
        double a = Math.toRadians(angle);
        //vx=v*sin(a), v - velocity, a- angle.
        double dx = speed * Math.sin(a);
        //vy=-v*cos(a), v - velocity, a- angle.
        double dy = -speed * Math.cos(a);
        //new velocity.
        return new Velocity(dx, dy);
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public double getSpeed() {
        return Math.abs(Math.sqrt(dx * dx + dy * dy));
    }

    /**
     * Gets dx.
     *
     * @return the dx the distance in x axis.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy.
     *
     * @return the dy the distance in y axis..
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     *
     * @param p the point.
     * @return the new point.
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }
}