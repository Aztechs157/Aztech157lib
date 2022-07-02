package org.aztechs157.lib.input.layouts;

import java.util.HashMap;
import java.util.Map;

import org.aztechs157.lib.input.inputs.Axis;
import org.aztechs157.lib.input.inputs.Button;
import org.aztechs157.lib.input.inputs.Pov;

/**
 * A simple structure that stores the mapping between keys and inputs. These can
 * be used with {@link SelectableLayout} to allow hot-swapping of layouts.
 */
public class MapLayout implements Layout {
    private final Map<Button.Key, Button> buttons = new HashMap<>();
    private final Map<Axis.Key, Axis> axes = new HashMap<>();
    private final Map<Pov.Key, Pov> povs = new HashMap<>();

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

    @Override
    public String toString() {
        final var builder = new StringBuilder("Layout\n");

        if (!buttons.isEmpty()) {
            builder.append("\nButtons:\n");
            for (final var entry : buttons.entrySet()) {
                builder.append(entry.getKey());
                builder.append(" -> ");
                builder.append(entry.getValue());
                builder.append("\n");
            }
        }

        if (!axes.isEmpty()) {
            builder.append("\nAxes:\n");
            for (final var entry : axes.entrySet()) {
                builder.append(entry.getKey());
                builder.append(" -> ");
                builder.append(entry.getValue());
                builder.append("\n");
            }
        }

        if (!povs.isEmpty()) {
            builder.append("\nPovs:\n");
            for (final var entry : povs.entrySet()) {
                builder.append(entry.getKey());
                builder.append(" -> ");
                builder.append(entry.getValue());
                builder.append("\n");
            }
        }

        return builder.toString();
    }
}
