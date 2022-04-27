package org.aztechs157.examples.input;

import org.aztechs157.lib.input.Layout;
import org.aztechs157.lib.input.ShuffleLayoutChooser;
import org.aztechs157.lib.input.models.LogitechGamepadF310;

public class DriverInputs extends ShuffleLayoutChooser {

    public DriverInputs() {
        final var defaultLayout = add(new Layout("Default"));
        final var logitech = new LogitechGamepadF310(0);

        defaultLayout.assign(
                Keys.AxisKeys.DriveSpeedX,
                logitech.leftStickX.scaled(1));
        defaultLayout.assign(
                Keys.AxisKeys.DriveSpeedY,
                logitech.leftStickY.scaled(1).inverted());
        defaultLayout.assign(
                Keys.AxisKeys.DriveRotation,
                logitech.rightStickX.scaled(1));

        defaultLayout.assign(Keys.ButtonKeys.Hello, logitech.start);
        defaultLayout.assign(Keys.ButtonKeys.IntakeRun, logitech.rightBumper);
        defaultLayout.assign(Keys.ButtonKeys.LowShoot, logitech.back);
    }
}
