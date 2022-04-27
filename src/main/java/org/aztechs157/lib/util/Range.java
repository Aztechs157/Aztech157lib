package org.aztechs157.lib.util;

/**
 * Safe to be constant
 */
public class Range {
    public final double low;
    public final double high;

    public Range(final double low, final double high) {
        this.low = low;
        this.high = high;
    }

    /**
     * Check if a value is contained within the range.
     *
     * @param value The value to check
     * @return The result of the check
     */
    public boolean contains(final double value) {
        return low <= value && value <= high;
    }

    /**
     * Get the length of the range.
     *
     * Specifically, the difference between the high and the low of the range. Also
     * known as the "range" of the range.
     *
     * @return The length of the range
     */
    public double length() {
        return high - low;
    }

    /**
     * Clamp a value to a number within this range.
     *
     * Specifically, any numbers lower than `this.low` will result in `this.low`,
     * any numbers higher than `this.high` will result in `this.high`, and anything
     * in between isn't modified.
     *
     * @param value The value to clamp
     * @return The clamped value
     */
    public double clamp(final double value) {
        if (value > high) {
            return high;
        } else if (value < low) {
            return low;
        } else {
            return value;
        }
    }

    /**
     * Scale a number within `inputRange` to the corresponding number within
     * `outputRange`.
     *
     * @param inputRange  The range of the input value
     * @param inputValue  The input value
     * @param outputRange The range of the output value
     * @return The corresponding number in `outputRange`
     */
    public RangeConverter createConverterTo(final Range outputRange) {
        return new RangeConverter(this, outputRange);
    }
}