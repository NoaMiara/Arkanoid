

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Game.
 *
 * @param <getScoreTrackingListener> the type parameter
 */
public class GameLevel<getScoreTrackingListener> implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private biuoop.KeyboardSensor keyboard;
    private Counter counterBlock;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private Counter counterBall;
    private Counter counterScore;
    private ScoreTrackingListener scoreTrackingListener;
    private ScoreIndicator scoreIndicator;
    private AnimationRunner runner;
    private boolean running;
    private LevelIndicator levelIndicator;
    private LevelInformation levelInformation;

    private static final int RADIUS_BALL = 4;


    /**
     * Instantiates a new Game.
     *
     * @param levelInformation      the level information
     * @param keyboard              the keyboard
     * @param runner                the runner
     * @param scoreTrackingListener the score tracking listener
     */
    public GameLevel(LevelInformation levelInformation, biuoop.KeyboardSensor keyboard, AnimationRunner runner,
                     ScoreTrackingListener scoreTrackingListener) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = runner;
        this.gui = this.runner.getGui();
        this.keyboard = keyboard;
        this.levelInformation = levelInformation;
        this.counterBlock = new Counter(this.levelInformation.numberOfBlocksToRemove());
        this.counterBall = new Counter(this.levelInformation.numberOfBalls());
        this.counterScore = new Counter(0);
        this.scoreTrackingListener = scoreTrackingListener;
    }

    /**
     * Gets counter ball.
     *
     * @return the counter ball
     */
    public Counter getCounterBall() {
        return this.counterBall;
    }

    /**
     * Gets counter block.
     *
     * @return the counter block
     */
    public Counter getCounterBlock() {
        return this.counterBlock;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return this.scoreTrackingListener.getCurrentScore().getValue();
    }

    /**
     * Add collidable to environment.
     *
     * @param c the Collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite to environment.
     *
     * @param s the Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball and Paddle and add them to the game.
     */
    public void initialize() {
        this.blockRemover = new BlockRemover(this, this.counterBlock);
        this.ballRemover = new BallRemover(this, this.counterBall);
        //create the paddle
        Sprite s = levelInformation.getBackground();
        s.addToGame(this);
        Rectangle rectangle = new Rectangle(new Point(400 - (levelInformation.paddleWidth() / 2), 560),
                levelInformation.paddleWidth(), 20);
        Paddle paddle = new Paddle(rectangle, Color.YELLOW, keyboard, levelInformation.paddleSpeed());
        paddle.addToGame(this);
        List<Block> blockList = levelInformation.blocks();
        for (Block block : blockList) {
            block.addHitListener(this.blockRemover);
            block.addHitListener(this.scoreTrackingListener);
            block.addToGame(this);
        }
        //We will create 4 more rectangles that will form the frame of the board
        Rectangle rectangle1 = new Rectangle(new Point(0, 25), 800, 35);
        Block block1 = new Block(rectangle1, Color.GRAY);
        Rectangle rectangle2 = new Rectangle(new Point(0, 25), 25, 575);
        Block block2 = new Block(rectangle2, Color.GRAY);
        Rectangle rectangle3 = new Rectangle(new Point(775, 25), 100, 575);
        Block block3 = new Block(rectangle3, Color.GRAY);
        Block[] blocks = new Block[]{block1, block2, block3};
        //Each ball is given the appropriate attributes and add them to the game
        for (Block block : blocks) {
            block.addToGame(this);
            this.addSprite(block);
            this.addCollidable(block);
            // ball.getGameEnvironment().addCollidable(block);
        }
        Rectangle rectangle4 = new Rectangle(new Point(0, 600), 800, 20);
        Block block4 = new Block(rectangle4, Color.GRAY);
        block4.addHitListener(this.ballRemover);
        block4.addToGame(this);
        Rectangle rectangleScore = new Rectangle(new Point(0, 0), 800, 25);
        this.scoreIndicator = new ScoreIndicator(new Counter(0), rectangleScore);
        scoreIndicator.addToGame(this);
        this.levelIndicator = new LevelIndicator(levelInformation.levelName());
        levelIndicator.addToGame(this);
    }

    /**
     * Remove collidable.
     *
     * @param c the Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        // the logic from the previous run method goes here.
        // the `return` or `break` statements should be replaced with
        // this.running = false;
        this.scoreIndicator.setCounter(this.scoreTrackingListener.getCurrentScore());
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.counterBlock.getValue() == 0) {
            this.scoreTrackingListener.setCurrentS(100);
            this.running = false;
        }
        if (this.counterBall.getValue() == 0) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            KeyPressStoppableAnimation keyPressStoppableAnimation = new
                    KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.keyboard));
            while (!keyPressStoppableAnimation.shouldStop()) {
                this.runner.run(keyPressStoppableAnimation);
            }
        }
    }

    /**
     * boolean should Stop.
     *
     * @return not this.running.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Run.
     */
    public void run() {
        this.runner.run(new CountdownAnimantion(2, 3, this.sprites));
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * create Balls On Top Of Paddle.
     */
    private void createBallsOnTopOfPaddle() {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 550, RADIUS_BALL, Color.WHITE);
            ballList.add(ball);
            ball.addToGame(this);
        }
        int i = 0;
        for (Ball ball : ballList) {
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            i++;
        }
    }

}