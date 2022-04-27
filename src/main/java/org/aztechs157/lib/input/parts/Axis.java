package org.aztechs157.lib.input.parts;

import java.util.function.DoubleSupplier;

import org.aztechs157.lib.input.keys.KeyBase;
import org.aztechs157.lib.util.Range;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Class for getting input from a axis. This class has methods and static
 * methods to modify and compose {@link Axis}s into a new
 * {@link Axis}.
 */
public class Axis implements DoubleSupplier {
    public interface Key extends KeyBase {
    }

    private final DoubleSupplier value;

    public Axis(final int deviceId, final int axisId) {
        this(() -> DriverStation.getStickAxis(deviceId, axisId));
    }

    public Axis(final DoubleSupplier value) {
        this.value = value;
    }

    @Override
    public double getAsDouble() {
        return value.getAsDouble();
    }

    public double get() {
        return value.getAsDouble();
    }

    public static final double DEFAULT_VALUE = 0;
    public static final Range DEFAULT_RANGE = new Range(-1, 1);
    public static final Axis DEFAULT = new Axis(() -> DEFAULT_VALUE);

    /**
     * Inverts the input by negating the number's sign
     *
     * @return A new inverted input
     */
    public Axis inverted() {
        return new Axis(() -> -get());
    }

    /**
     * Scale the input with a scalar value.
     *
     * @param scale The value to scale by
     * @return A new input with the scale applied
     */
    public Axis scaled(final double scale) {
        return new Axis(() -> get() * scale);
    }

    /**
     * Scale the input with another input.
     *
     * @param scale The input to retrieve the scale from
     * @return A new input with the scale applied
     */
    public Axis scaled(final DoubleSupplier scale) {
        return new Axis(() -> get() * scale.getAsDouble());
    }

    public Axis offset(final double offset) {
        return new Axis(() -> get() + offset);
    }

    public Axis offset(final DoubleSupplier offset) {
        return new Axis(() -> get() + offset.getAsDouble());
    }

    /**
     * Clamp the input to a number within the provided range.
     *
     * @param range The range to clamp to
     * @return A new input with clamp applied
     */
    public Axis clamp(final Range range) {
        return new Axis(() -> range.clamp(get()));
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
        return deadzone(deadzone, DEFAULT_RANGE, DEFAULT_VALUE);
    }

    public Axis deadzone(final Range deadzone, final Range fullRange, final double fullRangeCenter) {
        final var leftDeadzoneRange = new Range(fullRange.low, deadzone.low);
        final var leftFullRange = new Range(fullRange.low, fullRangeCenter);
        final var leftConverter = leftDeadzoneRange.createConverterTo(leftFullRange);

        final var rightDeadzoneRange = new Range(deadzone.high, fullRange.high);
        final var rightFullRange = new Range(fullRangeCenter, fullRange.high);
        final var rightConverter = rightDeadzoneRange.createConverterTo(rightFullRange);

        return new Axis(() -> {
            final var value = get();

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
