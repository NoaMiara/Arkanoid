

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Countdown animantion.
 */
public class CountdownAnimantion implements Animation {
    private double numOfSeconds;
    private int count;
    private SpriteCollection spriteCollection;
    private boolean shouldStop;
    private int countDowner;

    /**
     * Instantiates a new Countdown animantion.
     *
     * @param numOfSeconds     the num of seconds
     * @param count            the count from
     * @param spriteCollection the sprite collection
     */
    public CountdownAnimantion(double numOfSeconds, int count, SpriteCollection spriteCollection) {
        this.numOfSeconds = numOfSeconds;
        this.spriteCollection = spriteCollection;
        this.count = count;
        this.shouldStop = false;
        this.countDowner = 3;
    }

    /**
     * do One Frame.
     *
     * @param d the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        double millisecondsPerFrame = 1000 * (numOfSeconds / count);
        long startTime = System.currentTimeMillis(); // timing
        d.fillRectangle(0, 0, 800, 600);
        this.spriteCollection.drawAllOn(d);
        d.setColor(new Color(150, 13, 55));
        if (countDowner > 0) {
            // d.drawCircle(400, 330, 180);
            d.drawText(350, 350, (countDowner) + "", 150);
            countDowner--;
        } else {
            this.shouldStop = true;
        }
        if (countDowner == 2) {
            return;
        }
        double usedTime = System.currentTimeMillis() - startTime;
        long milliSecondLeftToSleep = (long) (millisecondsPerFrame - usedTime);
        if (milliSecondLeftToSleep > 0) {
            sleeper.sleepFor(milliSecondLeftToSleep);
        }
    }

    /**
     * should Stop.
     *
     * @return this.shouldStop.
     */
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}
