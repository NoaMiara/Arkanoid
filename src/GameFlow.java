

import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {

    private final GUI gui;
    private AnimationRunner animationRunner;
    private biuoop.KeyboardSensor keyboard;
    private ScoreTrackingListener scoreTrackingListener;

    /**
     * Instantiates a new Game flow.
     *
     * @param animationRunner the animation runner
     */
    public GameFlow(AnimationRunner animationRunner) {
        this.animationRunner = animationRunner;
        this.gui = animationRunner.getGui();
        this.keyboard = gui.getKeyboardSensor();
        this.scoreTrackingListener = new ScoreTrackingListener(new Counter(0));
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboard, this.animationRunner, this.scoreTrackingListener);
            level.initialize();
            while (level.getCounterBall().getValue() != 0 && level.getCounterBlock().getValue() != 0) {
                level.run();
            }
            if (level.getCounterBall().getValue() == 0) {
                KeyPressStoppableAnimation keyPressStoppableAnimation = new
                        KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                        new GameOverScreen(this.keyboard, this.scoreTrackingListener.getCurrentScore().getValue()));
                while (!keyPressStoppableAnimation.shouldStop()) {
                    this.animationRunner.run(keyPressStoppableAnimation);
                }
                this.gui.close();
            }
            this.scoreTrackingListener.setScore(level.getScore());
        }
        KeyPressStoppableAnimation keyPressStoppableAnimation1 = new
                KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new WinScreen(this.keyboard,
                this.scoreTrackingListener.getCurrentScore().getValue()));
        while (!keyPressStoppableAnimation1.shouldStop()) {
            this.animationRunner.run(keyPressStoppableAnimation1);
        }
        this.gui.close();
    }
}
