

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Wide easy.
 */
public class WideEasy implements LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * Initial ball velocities list.
     *
     * @return the list of velocity.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> listV = new ArrayList<>();
        int x = 10;
        for (int i = 0; i < 5; i++) {
            listV.add(Velocity.fromAngleAndSpeed(x, 2));
            x = x + 10;
        }
        int y = 10;
        for (int i = 0; i < 5; i++) {
            listV.add(Velocity.fromAngleAndSpeed(-y, 2));
            y = y + 10;
        }
        return listV;
    }

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * Paddle width int.
     *
     * @return the int
     */
    public int paddleWidth() {
        return 620;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the string
     */
    public String levelName() {
        return "Name Level: Wide Easy";
    }

    /**
     * Gets background.
     *
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        Sprite sprite = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(153, 204, 255));
                d.fillRectangle(0, 10, 800, 600);
                d.setColor(Color.RED);
                d.fillCircle(400, 400, 400);
                d.setColor(Color.ORANGE);
                d.fillCircle(400, 400, 310);
                d.setColor(Color.YELLOW);
                d.fillCircle(400, 400, 225);
                d.setColor(Color.GREEN);
                d.fillCircle(400, 400, 160);
                d.setColor(Color.WHITE);
                d.fillRectangle(25, 260, 770, 400);
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
     * The Blocks that make up this level, each block contains its size, color and location.
     *
     * @return the list
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        int x = 25;
        for (int i = 0; i < 15; i++) {
            Rectangle rectangle = new Rectangle(new Point(x, 260), 50, 20);
            if (x < 125) {
                Block block = new Block(rectangle, Color.RED);
                blockList.add(block);
            }
            if (125 <= x && x < 225) {
                Block block = new Block(rectangle, Color.orange);
                blockList.add(block);
            }
            if (225 <= x && x < 325) {
                Block block = new Block(rectangle, Color.YELLOW);
                blockList.add(block);
            }
            if (325 <= x && x < 475) {
                Block block = new Block(rectangle, Color.GREEN);
                blockList.add(block);
            }
            if (475 <= x && x < 575) {
                Block block = new Block(rectangle, Color.YELLOW);
                blockList.add(block);
            }
            if (575 <= x && x < 675) {
                Block block = new Block(rectangle, Color.ORANGE);
                blockList.add(block);
            }
            if (675 <= x && x < 775) {
                Block block = new Block(rectangle, Color.RED);
                blockList.add(block);
            }
            x = x + 50;
        }
        return blockList;
    }

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return the number Of Blocks To Remove.
     */

    public int numberOfBlocksToRemove() {
        return 15;
    }
}
