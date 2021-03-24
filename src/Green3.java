
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Green 3.
 */
public class Green3 implements LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * The initial velocity of each ball.
     *
     * @return the list
     */

    public List<Velocity> initialBallVelocities() {
        List<Velocity> listV = new ArrayList<>();
        listV.add(Velocity.fromAngleAndSpeed(40, 3));
        listV.add(Velocity.fromAngleAndSpeed(-40, 3));
        return listV;
    }

    /**
     * Paddle speed int.
     *
     * @return the int paddle Speed.
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * Paddle width int.
     *
     * @return the int paddle Width.
     */
    public int paddleWidth() {
        return 100;
    }

    /**
     * the level name will be displayed at the top of the screen..
     *
     * @return the string - level name.
     */
    public String levelName() {
        return "Name Level: Green 3";
    }

    /**
     * sprite with the background of the level.
     *
     * @return the sprite with the background of the level.
     */
    public Sprite getBackground() {
        Sprite sprite = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(56, 154, 53));
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.YELLOW);
                d.fillRectangle(40, 300, 160, 190);
                d.setColor(new Color(153, 153, 0));
                d.drawRectangle(40, 300, 160, 190);
                d.setColor(new Color(153, 153, 0));
                d.drawRectangle(40, 300, 160, 190);
                d.setColor(new Color(153, 76, 0));
                d.fillRectangle(40, 490, 160, 40);
                d.setColor(new Color(204, 0, 0));
                d.fillCircle(120, 420, 40);
                d.setColor(Color.WHITE);
                d.fillRectangle(96, 400, 15, 27);
                d.setColor(Color.WHITE);
                d.fillRectangle(125, 400, 15, 27);
                d.setColor(Color.YELLOW);
                d.fillCircle(120, 380, 40);
                d.setColor(Color.WHITE);
                d.fillRectangle(40, 470, 160, 20);
                d.setColor(Color.WHITE);
                d.fillCircle(90, 350, 20);
                d.setColor(Color.BLACK);
                d.drawCircle(90, 350, 20);
                d.setColor(Color.WHITE);
                d.fillCircle(150, 350, 20);
                d.setColor(Color.BLACK);
                d.drawCircle(150, 350, 20);
                d.setColor(Color.BLACK);
                d.fillCircle(95, 350, 10);
                d.setColor(Color.BLACK);
                d.fillCircle(145, 350, 10);
                d.setColor(Color.BLUE);
                d.fillCircle(95, 350, 5);
                d.setColor(Color.BLUE);
                d.fillCircle(145, 350, 5);
                d.setColor(new Color(153, 153, 0));
                d.fillCircle(50, 350, 7);
                d.setColor(new Color(153, 153, 0));
                d.fillCircle(70, 400, 7);
                d.setColor(new Color(153, 153, 0));
                d.fillCircle(100, 400, 7);
                d.setColor(new Color(153, 153, 0));
                d.fillCircle(170, 430, 3);
                d.setColor(new Color(153, 153, 0));
                d.fillCircle(180, 350, 7);
                d.setColor(new Color(153, 153, 0));
                d.fillCircle(190, 380, 10);
                d.setColor(Color.WHITE);
                d.drawText(380, 250, "Proud to be proud", 35);
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
     * @return the list of block.
     */
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        int firstLeftPointX = 275;
        int firstLeftPointY = 215;
        for (int i = 0; i < 10; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX, firstLeftPointY), 50,
                    20), Color.GRAY);
            blockList.add(block);
            firstLeftPointX = firstLeftPointX + 50;
        }
        int firstLeftPointX2 = 325;
        int firstLeftPointY2 = 235;
        for (int i = 0; i < 9; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX2, firstLeftPointY2), 50,
                    20), Color.RED);
            blockList.add(block);
            firstLeftPointX2 = firstLeftPointX2 + 50;
        }
        int firstLeftPointX3 = 375;
        int firstLeftPointY3 = 255;
        for (int i = 0; i < 8; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX3, firstLeftPointY3), 50,
                    20), Color.YELLOW);
            blockList.add(block);
            firstLeftPointX3 = firstLeftPointX3 + 50;
        }
        int firstLeftPointX4 = 425;
        int firstLeftPointY4 = 275;
        for (int i = 0; i < 7; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX4, firstLeftPointY4), 50,
                    20), Color.BLUE);
            blockList.add(block);
            firstLeftPointX4 = firstLeftPointX4 + 50;
        }
        int firstLeftPointX5 = 475;
        int firstLeftPointY5 = 295;
        for (int i = 0; i < 6; i++) {
            Block block = new Block(new Rectangle(new Point(firstLeftPointX5, firstLeftPointY5), 50,
                    20), Color.WHITE);
            blockList.add(block);
            firstLeftPointX5 = firstLeftPointX5 + 50;
        }
        return blockList;
    }

    /**
     * Number of blocks that should be removed before the level is considered to be "cleared".
     *
     * @return the number of blocks.
     */
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
