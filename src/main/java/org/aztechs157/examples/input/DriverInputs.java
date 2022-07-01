package org.aztechs157.examples.input;

import org.aztechs157.lib.input.MapLayout;
import org.aztechs157.lib.input.models.LogitechGamepadF310;

public class DriverInputs {
    final MapLayout layout = new MapLayout("Default");

    public DriverInputs() {
        final var logitech = new LogitechGamepadF310(0);

        layout.assign(
                Keys.AxisKeys.DriveSpeedX,
                logitech.leftStickX.scaled(1));
        layout.assign(
                Keys.AxisKeys.DriveSpeedY,
                logitech.leftStickY.scaled(1).inverted());
        layout.assign(
                Keys.AxisKeys.DriveRotation,
                logitech.rightStickX.scaled(1));

        layout.assign(Keys.ButtonKeys.Hello, logitech.start);
        layout.assign(Keys.ButtonKeys.IntakeRun, logitech.rightBumper);
        layout.assign(Keys.ButtonKeys.LowShoot, logitech.back);
    }
}
