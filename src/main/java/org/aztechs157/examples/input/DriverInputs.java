package org.aztechs157.examples.input;

import org.aztechs157.lib.input.MapLayout;
import org.aztechs157.lib.input.models.LogitechGamepadF310;

public class DriverInputs {
    final MapLayout layout = new MapLayout();

    public DriverInputs() {
        final var logitech = new LogitechGamepadF310(0);

        layout.assign(
                Keys.driveSpeedX,
                logitech.leftStickX.scaled(1));
        layout.assign(
                Keys.driveSpeedY,
                logitech.leftStickY.scaled(1).inverted());
        layout.assign(
                Keys.driveRotation,
                logitech.rightStickX.scaled(1));

        layout.assign(Keys.hello, logitech.start);
        layout.assign(Keys.intakeRun, logitech.rightBumper);
        layout.assign(Keys.lowShoot, logitech.back);
    }
}
