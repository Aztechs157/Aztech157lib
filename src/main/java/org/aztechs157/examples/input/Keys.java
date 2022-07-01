package org.aztechs157.examples.input;

import org.aztechs157.lib.input.Axis;
import org.aztechs157.lib.input.Button;

public class Keys {
    public static final Axis.Key driveSpeedX = new Axis.Key().label("Drive Speed X");
    public static final Axis.Key driveSpeedY = new Axis.Key().label("Drive Speed Y");
    public static final Axis.Key driveRotation = new Axis.Key().label("Drive Rotation");

    public static final Button.Key hello = new Button.Key().label("Hello");
    public static final Button.Key intakeRun = new Button.Key().label("Intake Run");
    public static final Button.Key lowShoot = new Button.Key().label("Low Shoot");
}
