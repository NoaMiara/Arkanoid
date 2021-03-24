

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Direct hit.
 */
public class DirectHit implements LevelInformation {

    /**
     * number Of Balls.
     *
     * @return number Of Balls.
     */
    public int numberOfBalls() {
        return 1;
    }

    /**
     * initial Ball Velocities.
     *
     * @return List of Velocity.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> listV = new ArrayList<Velocity>();
        listV.add(Velocity.fromAngleAndSpeed(0, 5));
        return listV;
    }

    /**
     * paddle Speed.
     *
     * @return paddle Speed.
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * paddle Width.
     *
     * @return paddle Width.
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name .
     */
    public String levelName() {
        return "Name Level: Direct Hit";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return sprite with the background of the level.
     */
    public Sprite getBackground() {
        Sprite sprite = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.BLACK);
                d.fillRectangle(0, 0, 800, 600);
                for (int y = 60; y < 600; y = y + 30) {
                    if (y % 60 == 0) {
                        for (int x = 25; x < 800; x = x + 60) {
                            d.setColor(Color.WHITE);
                            d.fillRectangle(x, y, 30, 30);
                        }
                    } else {
                        for (int x = 55; x < 800; x = x + 60) {
                            d.setColor(Color.WHITE);
                            d.fillRectangle(x, y, 30, 30);
                        }

                    }
                }
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
     * @return List of blocks.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Rectangle rectangle = new Rectangle(new Point(385, 150), 30, 30);
        Block block = new Block(rectangle, Color.RED);
        blockList.add(block);
        return blockList;
    }

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return number Of Blocks To Remove.
     */
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
