

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game environment.
 */
public class GameEnvironment {

    private List<Collidable> collidables;

    /**
     * Instantiates a new Game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * Add collidable.
     *
     * @param c the Collidable.
     */
// add the given collidable to the environment.
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * Object moving from line.start() to line.end() if this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //We will create an array that will store all the information we receive.
        ArrayList<CollisionInfo> inform = new ArrayList<>();
        //We'll go over all the collisions on the given line, if a collision can occur, add it to the array.
        for (Collidable c : collidables) {
            Point clossestToLine = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (clossestToLine != null) {
                inform.add(new CollisionInfo(clossestToLine, c));
            }
        }
        //If the list is empty, it means that there are no conflicts and can be advanced, so we return null.
        if (inform.size() == 0) {
            return null;
        }
        //Otherwise, we would like to review the information for the nearest point of conflict
        // Set a minimum distance, and be the distance from the first point on the list
        double minDistance = trajectory.start().distance(inform.get(0).collisionPoint());
        CollisionInfo rightInform = inform.get(0);
        //We'll go through the whole list
        for (int i = 0; i < inform.size(); i++) {
            double rightDistance = trajectory.start().distance(inform.get(i).collisionPoint());
            if (rightDistance < minDistance) {
                //If the new distance is smaller, it means we have identified a closer point.
                minDistance = rightDistance;
                rightInform = inform.get(i);
            }
        }
        //We will return the updated and new list.
        return rightInform;
    }

    /**
     * remove Collidable.
     *
     * @param c the Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
}