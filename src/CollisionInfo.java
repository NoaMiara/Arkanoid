

/**
 * The type Collision info.
 */
public class CollisionInfo {
    private Point pointCollision;
    private Collidable collisionObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param pointCollision  the point collision
     * @param collisionObject the collision object
     */
    public CollisionInfo(Point pointCollision, Collidable collisionObject) {
        this.pointCollision = pointCollision;
        this.collisionObject = collisionObject;
    }

    /**
     * the point at which the collision occurs..
     *
     * @return the point
     */
    public Point collisionPoint() {
        return this.pointCollision;
    }

    /**
     * the collidable object involved in the collision..
     *
     * @return the collidable
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}