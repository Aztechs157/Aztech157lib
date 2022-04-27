package org.aztechs157.lib.util;

public class RangeConverter {
    private final Range inputRange;
    private final Range outputRange;
    private final double scaleFactor;

    public RangeConverter(final Range inputRange, final Range outputRange) {
        this.inputRange = inputRange;
        this.outputRange = outputRange;
        this.scaleFactor = outputRange.length() / inputRange.length();
    }

    public double convert(final double inputValue) {
        // Shift to zero based input range
        final var basedInput = inputValue - inputRange.low;

        // Scale the zero based input
        final var scaled = basedInput * scaleFactor;

        // Shift from zero based to output range
        final var outputValue = scaled + outputRange.low;

        return outputValue;
    }
}
