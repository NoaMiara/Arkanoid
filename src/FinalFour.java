
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Final four.
 */
public class FinalFour implements LevelInformation {
    private static final int BLOCK_WIDTH = 55;
    private static final int BLOCK_HEIGHT = 20;

    /**
     * Number of balls .
     *
     * @return the number of balls.
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * The initial velocity of each ball.
     *
     * @return the list
     */

    public List<Velocity> initialBallVelocities() {
        List<Velocity> listV = new ArrayList<>();
        listV.add(Velocity.fromAngleAndSpeed(40, 3));
        listV.add(Velocity.fromAngleAndSpeed(0, 3));
        listV.add(Velocity.fromAngleAndSpeed(-40, 3));
        return listV;
    }

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * Paddle width int.
     *
     * @return the int
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the string the level name.
     */
    public String levelName() {
        return "Name Level: Final Four";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        Sprite sprite = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.WHITE);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.BLUE);
                d.drawCircle(280, 150, 45);
                d.setColor(Color.BLACK);
                d.drawCircle(360, 150, 45);
                d.setColor(Color.RED);
                d.drawCircle(440, 150, 45);
                d.setColor(Color.YELLOW);
                d.drawCircle(300, 220, 45);
                d.setColor(Color.GREEN);
                d.drawCircle(400, 220, 45);
            }

            @Override
            public void timePassed() {
            }

            public void addToGame(GameLevel gameLevel) {
                gameLevel.addSprite(this);
            }
        };
        return sprite;

    }

    /**
     * The Blocks that make up this level, each block contains its size, color and location..
     *
     * @return the list of blocks.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>(numberOfBlocksToRemove());
        int firstLeftPointX = 25;
        int firstLeftPointY = 115;
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX, firstLeftPointY), 50,
                    20), Color.GRAY);
            blockList.add(block);
            firstLeftPointX = firstLeftPointX + 50;
        }
        int firstLeftPointX2 = 25;
        int firstLeftPointY2 = 135;
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX2, firstLeftPointY2), 50,
                    20), Color.RED);
            blockList.add(block);
            firstLeftPointX2 = firstLeftPointX2 + 50;
        }
        int firstLeftPointX3 = 25;
        int firstLeftPointY3 = 155;
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX3, firstLeftPointY3), 50,
                    20), Color.YELLOW);
            blockList.add(block);
            firstLeftPointX3 = firstLeftPointX3 + 50;
        }
        int firstLeftPointX4 = 25;
        int firstLeftPointY4 = 175;
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX4, firstLeftPointY4), 50,
                    20), Color.GREEN);
            blockList.add(block);
            firstLeftPointX4 = firstLeftPointX4 + 50;
        }
        int firstLeftPointX5 = 25;
        int firstLeftPointY5 = 195;
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX5, firstLeftPointY5), 50,
                    20), Color.WHITE);
            blockList.add(block);
            firstLeftPointX5 = firstLeftPointX5 + 50;
        }
        int firstLeftPointX6 = 25;
        int firstLeftPointY6 = 215;
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX6, firstLeftPointY6), 50,
                    20), Color.PINK);
            blockList.add(block);
            firstLeftPointX6 = firstLeftPointX6 + 50;
        }
        int firstLeftPointX7 = 25;
        int firstLeftPointY7 = 235;
        for (int i = 0; i < 15; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX7, firstLeftPointY7), 50,
                    20), new Color(0, 255, 255));
            blockList.add(block);
            firstLeftPointX7 = firstLeftPointX7 + 50;
        }
        return blockList;
    }

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return Number of blocks.
     */
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
