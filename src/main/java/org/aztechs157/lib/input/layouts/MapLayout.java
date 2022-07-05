package org.aztechs157.lib.input.layouts;

import java.util.HashMap;
import java.util.Map;

import org.aztechs157.lib.input.inputs.Axis;
import org.aztechs157.lib.input.inputs.Button;
import org.aztechs157.lib.input.inputs.Pov;
import org.aztechs157.lib.input.inputs.Raw;

/**
 * A simple structure that stores the mapping between keys and inputs. These can
 * be used with {@link SelectableLayout} to allow hot-swapping of layouts.
 */
public class MapLayout implements Layout {
    private final Map<Button.Key, Button> buttons = new HashMap<>();
    private final Map<Axis.Key, Axis> axes = new HashMap<>();
    private final Map<Pov.Key, Pov> povs = new HashMap<>();
    private final Map<Raw.Key, Raw> raws = new HashMap<>();

    /**
     * For this Layout, assign a {@link Button.Key} to a {@link Button}.
     * Calling
     * this method multiple times with the same key will override the previous
     * assignment.
     *
     * @param key    The key to assign with
     * @param button The button being assigned
     */
    public void assign(final Button.Key key, final Button button) {
        buttons.put(key, button);
    }

    /**
     * For this Layout, assign a {@link Axis.KeyBase} to a {@link Axis}. Calling
     * this
     * method multiple times with the same key will override the previous
     * assignment.
     *
     * @param key  The key to assign with
     * @param axis The axis being assigned
     */
    public void assign(final Axis.Key key, final Axis axis) {
        axes.put(key, axis);
    }

    /**
     * For this Layout, assign a {@link Pov.KeyBase} to a {@link Pov}. Calling this
     * method multiple times with the same key will override the previous
     * assignment.
     *
     * @param key The key to assign with
     * @param pov The pov being assigned
     */
    public void assign(final Pov.Key key, final Pov pov) {
        povs.put(key, pov);
    }

    public void assign(final Raw.Key key, final Raw pov) {
        raws.put(key, pov);
    }

    /**
     * Retrieve the {@link Button} associated with a {@link Button.Key}
     *
     * @param key The key a button was assigned to
     * @return The associated button
     */
    public Button button(final Button.Key key) {
        return buttons.get(key);
    }

    /**
     * Retrieve the {@link Axis} associated with a {@link Axis.KeyBase}
     *
     * @param key The key an axis was assigned to
     * @return The associated axis
     */
    public Axis axis(final Axis.Key key) {
        return axes.get(key);
    }

    /**
     * Retrieve the {@link Pov} associated with a {@link Pov.KeyBase}
     *
     * @param key The key an pov was assigned to
     * @return The associated pov
     */
    public Pov pov(final Pov.Key key) {
        return povs.get(key);
    }

    public Raw raw(final Raw.Key key) {
        return raws.get(key);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder("Layout\n");
        final var headerFormat = "\n%s:\n";
        final var entryFormat = "%s -> %s\n";

        if (!buttons.isEmpty()) {
            builder.append(String.format(headerFormat, "Buttons"));
            for (final var entry : buttons.entrySet()) {
                builder.append(String.format(
                        entryFormat,
                        entry.getKey(),
                        entry.getValue()));
            }
        }

        if (!axes.isEmpty()) {
            builder.append(String.format(headerFormat, "Axes"));
            for (final var entry : axes.entrySet()) {
                builder.append(String.format(
                        entryFormat,
                        entry.getKey(),
                        entry.getValue()));
            }
        }

        if (!povs.isEmpty()) {
            builder.append(String.format(headerFormat, "Povs"));
            for (final var entry : povs.entrySet()) {
                builder.append(String.format(
                        entryFormat,
                        entry.getKey(),
                        entry.getValue()));
            }
        }

        if (!raws.isEmpty()) {
            builder.append(String.format(headerFormat, "Raws"));
            for (final var entry : raws.entrySet()) {
                builder.append(String.format(
                        entryFormat,
                        entry.getKey(),
                        entry.getValue()));
            }
        }

        return builder.toString();
    }
}
