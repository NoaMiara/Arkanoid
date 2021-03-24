

import java.util.List;

/**
 * The class line gets points and creates a line.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Instantiates a new Line.
     *
     * @param start the start of line.
     * @param end   the end of line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x of the start point.
     * @param y1 the y of the start point.
     * @param x2 the x of the end point.
     * @param y2 the y of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Middle point of the line.
     *
     * @return the point
     */
    public Point middle() {
        Point middle = new Point(((start.getX() + end.getX()) / 2), ((start.getY() + end.getY()) / 2));
        return (middle);
    }

    /**
     * Start point.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return (this.start);
    }

    /**
     * End point.
     *
     * @return the end point of the line.
     */
    public Point end() {
        return (this.end);
    }

    /**
     * A function that calculates a straight line incline with two points.
     *
     * @param s the point.
     * @param e the point.
     * @return the incline.
     */
    public double incline(Point s, Point e) {
        double deltaY = (e.getY() - s.getY());
        double deltaX = (e.getX() - s.getX());
        return (deltaY / deltaX);
    }

    /**
     * A function that returns the b value in equation y = ax + b with a point and incline.
     *
     * @param x the point.
     * @param a the incline.
     * @return the b.
     */
    public double b(Point x, double a) {
        double b = x.getY() - (x.getX() * a);
        return b;
    }

    /**
     * A function that returns the x value of the intersection point by two incline and two b.
     *
     * @param incline1 the incline of one point.
     * @param incline2 the incline of other point.
     * @param b1       the b of one point.
     * @param b2       the b of one point.
     * @return the x value of the intersection point.
     */
    public double x(double incline1, double incline2, double b1, double b2) {
        double x = (b2 - b1) / (incline1 - incline2);
        return x;
    }

    /**
     * A function that returns the y value of the intersection point by incline, x and b.
     * y=ax+b.
     *
     * @param incline of the point.
     * @param x       of the point.
     * @param b       of the point.
     * @return the y value of the intersection point.
     */
    public double y(double incline, double x, double b) {
        double y = (incline * x) + b;
        return y;
    }

    /**
     * Is in boolean - A function that checks whether the cut point is within range, by calculating whether the cut
     * point is large-equal to the minimum point and also small-equal to the maximum point,
     * the function returns true or false.
     *
     * @param x1   the x of one point.
     * @param x2   the x of other point.
     * @param comX the common x.
     * @return true if it's in range and false if not.
     */
    public boolean isIn(double x1, double x2, double comX) {
        if ((Math.min(x1, x2) <= comX) && (Math.max(x1, x2) >= comX)) {
            return true;
        }
        return false;
    }

    /**
     * Is in boolean - A function that checks whether the cut point is within range, by calculating whether the cut
     * point is large-equal to the minimum point and also small-equal to the maximum point,
     * the function returns true or false.
     *
     * @param collisionP the collision p
     * @return true or false.
     */
    public boolean isIn(Point collisionP) {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double distance = Math.pow(10, -14);
        if (((Math.min(x1, x2) - distance) <= collisionP.getX()) && ((Math.max(x1, x2) + distance)
                >= collisionP.getX())) {
            if (((Math.abs(Math.min(y1, y2)) - distance) <= Math.abs(collisionP.getY()))
                    && (((Math.abs(Math.max(y1, y2)) + distance) >= collisionP.getY()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function will check different options for cutting between two straight, check if the cut point is within
     * the appropriate range and extent and return the point. For the purpose of testing, different functions are used.
     *
     * @param other point.
     * @return the intersection point if the lines intersect, and null otherwise.
     */
    public Point intersectionWith(Line other) {
        //We will define incline a1 for straight 1 by sending to the function that checks incline.
        double a1 = incline(other.start(), other.end());
        //We will define incline a. for straight 2 by sending to the function that checks incline.
        double a2 = incline(this.start, this.end);
        //we define point b1 for straight 1 by sending to a suitable function.
        double b1 = b(other.start(), a1);
        //we define point b2 for straight 2 by sending to a suitable function.
        double b2 = b(this.start, a2);
        double x = x(a1, a2, b1, b2);
        //Represents the x, y of the beginning and ending of other point.
        double x1 = other.start.getX();
        double x2 = other.end.getX();
        double y1 = other.start.getY();
        double y2 = other.end.getY();
        //Represents the x, y of the beginning and ending of this point.
        double x3 = this.start.getX();
        double x4 = this.end.getX();
        double y3 = this.start.getY();
        double y4 = this.end.getY();
        //Now let's look at a condition that other point parallel to the y axis (it has the same x value for the 2
        //start and end points) and this point is not parallel to the axis y.
        if ((x1 == x2) && (x3 != x4)) {
            //We will check if the y value of the straight cut point is within range.
            double y = y(a2, x2, b2);
            if (isIn(y1, y2, y) && isIn(x3, x4, x2)) {
                //If within range we will return the cut point.
                return new Point(x1, y);
            }
            //Otherwise we will return NULL
            return null;
        }
        //Now let's look at a condition that this point parallel to the y axis (it has the same x value for the 2 start
        // and end points) and other point is not parallel to the axis y.
        if ((x3 == x4) && (x1 != x2)) {
            //We will check if the y value of the straight cut point is within range.
            double y = y(a1, x3, b1);
            if (isIn(y3, y4, y) && isIn(x1, x2, x3)) {
                //If within range we will return the cut point.
                return new Point(x3, y);
            }
            //Otherwise we will return NULL
            return null;
        }
        //Now let's look at a situation that the two straight are parallel to the y axis.
        if ((x1 == x2) && (x3 == x4)) {
            //If the 4 points do not have the same value x, they are parallel, so we will certainly not cut and
            // return null
            if (x2 != x3) {
                return null;
                //Otherwise, they may continue with each other.
            } else {
                //We will check the y values ​​in terms of the range, if they continue with each other from the same
                // point, then return the point
                if ((Math.max(y3, y4) == Math.min(y1, y2))) {
                    return new Point(x3, Math.max(y3, y4));
                }
                if (Math.max(y1, y2) == Math.min(y3, y4)) {
                    return new Point(x3, Math.min(y3, y4));
                }
                //Otherwise we will return NULL
                return null;
            }

        }
        //If the incline is equal - either they are parallel or they intersect.
        if (a1 == a2) {
            //We will check in terms of the x values ​​if they continue with each other if we return the point.
            if ((Math.max(x3, x4) == Math.min(x1, x2))) {
                return new Point(Math.min(x1, x2), y1);
            }
            if (Math.max(x1, x2) == Math.min(x3, x4)) {
                return new Point(Math.min(x3, x4), y1);
            }
            //Otherwise we will return NULL
            return null;
            //The incline is not equal, we will check the cut point.
        } else {
            //  Find the X value of the cut point by sending to a suitable function.
            double comX = x(a1, a2, b1, b2);
            if (isIn(x1, x2, comX) && isIn(x3, x4, comX)) {
                //We will check whether the x of the intersection point is within range, then return the point.
                return new Point(comX, y(a2, x, b2));
            }
            //Otherwise we will return NULL
            return null;
        }
    }

    /**
     * Function checks whether two sections are equal.
     *
     * @param other point.
     * @return true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start()) && this.end.equals(other.end()));
    }

    /**
     * Closest intersection to start of line point- If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line..
     *
     * @param rect the rectangle.
     * @return the Closest intersection to start of line point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //We will create a new list of cutting points between line and rectangle.
        List<Point> newList = rect.intersectionPoints(this);
        Point pointClosest;
        //If there is no cut, we will return Null
        if (newList.size() == 0) {
            return null;
            //else,return the closest point calculate with the help of a distance between the collision point
            // and our point.
        } else {
            pointClosest = newList.get(0);
            double minDis = this.start.distance(pointClosest);
            double length;
            for (int i = 1; i < newList.size(); i++) {
                length = this.start.distance(newList.get(i));
                if (length < minDis) {
                    pointClosest = newList.get(i);
                    minDis = length;
                }
            }
        }
        return pointClosest;
    }
}