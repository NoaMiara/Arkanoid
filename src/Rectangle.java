

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;

    /**
     * Instantiates a new Rectangle-Create a new rectangle with location and width/height..
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.width = width;
        this.height = height;
        this.upperLeft = upperLeft;
    }

    /**
     * Intersection points - Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line the line
     * @return the List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        ////We will create a new list of cutting points between line and line.
        List<Point> newList = new ArrayList<>();
        //Define 4 lines - the rectangle lines and insert them into an array of lines.
        Line[] arr = new Line[4];
        arr[0] = new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + this.height));
        arr[1] = new Line(new Point(upperLeft.getX(), upperLeft.getY() + this.height), new Point(upperLeft.getX()
                + this.width, upperLeft.getY() + this.height));
        arr[2] = new Line(new Point(upperLeft.getX() + this.width, upperLeft.getY() + this.height),
                new Point(upperLeft.getX() + this.width, upperLeft.getY()));
        arr[3] = new Line(new Point(upperLeft.getX() + this.width, upperLeft.getY()), upperLeft);
        //Any cut point found will be added to the cut point list.
        for (int i = 0; i < 4; i++) {
            Point intersectionP = arr[i].intersectionWith(line);
            if (intersectionP != null) {
                newList.add(intersectionP);
            }
        }
        //We will check that there are no duplicate points in our list with the help of creating a new array,
        // and return the new array
        List<Point> clearList = new ArrayList<>();
        for (Point p : newList) {
            if (!clearList.contains(p)) {
                clearList.add(p);
            }
        }
        return clearList;
    }

    /**
     * Gets width.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets down left.
     *
     * @return the down left
     */
    public Point getDownLeft() {
        return new Point(upperLeft.getX(), upperLeft.getY() + this.height);
    }

    /**
     * Gets down right.
     *
     * @return the down right
     */
    public Point getDownRight() {
        return new Point(upperLeft.getX() + this.width, upperLeft.getY() + this.height);
    }

    /**
     * Gets upper right.
     *
     * @return the upper right
     */
    public Point getUpperRight() {
        return new Point(upperLeft.getX() + this.width, upperLeft.getY());
    }

    /**
     * Gets upper left.
     *
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Sets upper left.
     *
     * @param upperLeft1 the upper left
     */
    public void setUpperLeft(Point upperLeft1) {
        this.upperLeft = upperLeft1;
    }
}