package org.aztechs157.lib.input.layouts;

import java.util.function.Supplier;

import org.aztechs157.lib.input.inputs.Axis;
import org.aztechs157.lib.input.inputs.Button;
import org.aztechs157.lib.input.inputs.Pov;

/**
 * Object that manages layouts. A layout can be selected from Shuffleboard that
 * can then be used by the robot. It maps the inputs of a
 * {@link SelectableLayout}
 * to the desired functions of the robot.
 */
public class SelectableLayout implements Layout {
    private final Supplier<Layout> layoutSupplier;

    public SelectableLayout(final Supplier<Layout> layoutSupplier) {
        this.layoutSupplier = layoutSupplier;
    }

    public Layout getSelected() {
        return layoutSupplier.get();
    }

    /**
     * Get a button from the currently selected layout.
     *
     * @param key Which button to retrieve
     * @return A {@link Button} and {@link Button.Key} representing the input
     */
    public Button button(final Button.Key key) {
        return new Button(() -> getSelected().button(key).get());
    }

    /**
     * Get a axis from the currently selected layout.
     *
     * @param key Which axis to retrieve
     * @return A {@link Axis} representing the input
     */
    public Axis axis(final Axis.Key key) {
        return new Axis(() -> getSelected().axis(key).get());
    }

    /**
     * Get a pov from the currently selected layout.
     *
     * @param key Which pov to retrieve
     * @return A {@link Pov} representing the input
     */
    public Pov pov(final Pov.Key key) {
        return new Pov(() -> getSelected().pov(key).get());
    }
}
