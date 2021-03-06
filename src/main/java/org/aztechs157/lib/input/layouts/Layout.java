package org.aztechs157.lib.input.layouts;

import org.aztechs157.lib.input.inputs.Axis;
import org.aztechs157.lib.input.inputs.Button;
import org.aztechs157.lib.input.inputs.Pov;
import org.aztechs157.lib.input.inputs.Raw;

public interface Layout {
    /**
     * Retrieve the {@link Button} associated with a {@link Button.Key}
     *
     * @param key The key a button was assigned to
     * @return The associated button
     */
    public Button button(final Button.Key key);

    /**
     * Retrieve the {@link Axis} associated with a {@link Axis.KeyBase}
     *
     * @param key The key an axis was assigned to
     * @return The associated axis
     */
    public Axis axis(final Axis.Key key);

    /**
     * Retrieve the {@link Pov} associated with a {@link Pov.KeyBase}
     *
     * @param key The key an pov was assigned to
     * @return The associated pov
     */
    public Pov pov(final Pov.Key key);

    public Raw raw(final Raw.Key key);
}
