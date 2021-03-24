

/**
 * The type Counter.
 */
public class Counter {
    private int value;

    /**
     * Instantiates a new Counter.
     *
     * @param value the value
     */
    public Counter(int value) {
        this.value = value;
    }

    /**
     * Add number to current count.
     *
     * @param number the number
     */
    void increase(int number) {
        this.value = value + number;
    }

    /**
     * Subtract number from current count..
     *
     * @param number the number
     */
    void decrease(int number) {
        this.value = value - number;
    }

    /**
     * Gets current count.
     *
     * @return the value
     */
    int getValue() {
        return this.value;
    }
}