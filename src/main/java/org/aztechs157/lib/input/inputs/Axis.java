package org.aztechs157.lib.input.inputs;

import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

import org.aztechs157.lib.input.BaseKey;
import org.aztechs157.lib.input.Labelable;
import org.aztechs157.lib.util.Range;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Class for getting input from a axis. This class has methods and static
 * methods to modify and compose {@link Axis}s into a new
 * {@link Axis}.
 */
public class Axis implements Labelable<Axis> {
    public static class Key extends BaseKey<Key> {
    }

    private final DoubleSupplier value;

    public Axis(final DoubleSupplier value) {
        this.value = value;
    }

    public static Axis fromDriverStation(final int deviceId, final int axisId) {
        return new Axis(() -> DriverStation.getStickAxis(deviceId, axisId))
                .label("Device " + deviceId + " Axis " + axisId);
    }

    private String label = "Unlabeled Axis";

    public Axis label(final String label) {
        this.label = label;
        return this;
    }

    @Override
    public String toString() {
        return label;
    }

    public double get() {
        return value.getAsDouble();
    }

    public Axis map(final DoubleUnaryOperator function) {
        return new Axis(() -> function.applyAsDouble(get())).label(label);
    }

    /**
     * Inverts the input by negating the number's sign
     *
     * @return A new inverted input
     */
    public Axis inverted() {
        return map(value -> -value);
    }

    /**
     * Scale the input with a scalar value.
     *
     * @param scale The value to scale by
     * @return A new input with the scale applied
     */
    public Axis scaled(final double scale) {
        return map(value -> value * scale);
    }

    /**
     * Scale the input with another input.
     *
     * @param scale The input to retrieve the scale from
     * @return A new input with the scale applied
     */
    public Axis scaled(final DoubleSupplier scale) {
        return map(value -> value * scale.getAsDouble());
    }

    public Axis offset(final double offset) {
        return map(value -> value + offset);
    }

    public Axis offset(final DoubleSupplier offset) {
        return map(value -> value + offset.getAsDouble());
    }

    /**
     * Clamp the input to a number within the provided range.
     *
     * @param range The range to clamp to
     * @return A new input with clamp applied
     */
    public Axis clamp(final Range range) {
        return map(value -> range.clamp(value));
    }

    /**
     * Create a deadzone on the current axis.
     *
     * Any value inside the deadzone will result in 0. Values to the left or right
     * will be scaled from 0 to their respective end. This code assumes the axis is
     * in range of -1 to 1, breaking this assumption results in an Error.
     *
     * @param deadzone The range of the deadzone
     * @return A new input with the deadzone applied
     */
    public Axis deadzone(final Range deadzone) {
        return deadzone(deadzone, new Range(-1, 1), 0);
    }

    public Axis deadzone(final Range deadzone, final Range fullRange, final double fullRangeCenter) {
        final var leftDeadzoneRange = new Range(fullRange.low, deadzone.low);
        final var leftFullRange = new Range(fullRange.low, fullRangeCenter);
        final var leftConverter = leftDeadzoneRange.createConverterTo(leftFullRange);

        final var rightDeadzoneRange = new Range(deadzone.high, fullRange.high);
        final var rightFullRange = new Range(fullRangeCenter, fullRange.high);
        final var rightConverter = rightDeadzoneRange.createConverterTo(rightFullRange);

        return map(value -> {

            if (deadzone.contains(value)) {
                return 0;

            } else if (leftDeadzoneRange.contains(value)) {
                return leftConverter.convert(value);

            } else if (rightDeadzoneRange.contains(value)) {
                return rightConverter.convert(value);
            }

            throw new Error("Attempted to apply deadzone to axis value outside of full range "
                    + fullRange.low + " to " + fullRange.high);
        });
    }
}
