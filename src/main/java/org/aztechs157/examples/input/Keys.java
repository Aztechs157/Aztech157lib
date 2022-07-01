package org.aztechs157.examples.input;

import org.aztechs157.lib.input.Axis;
import org.aztechs157.lib.input.Button;

public class Keys {
    public static final Axis.Key driveSpeedX = new Axis.Key().name("Drive Speed X");
    public static final Axis.Key driveSpeedY = new Axis.Key().name("Drive Speed Y");
    public static final Axis.Key driveRotation = new Axis.Key().name("Drive Rotation");

    public static final Button.Key hello = new Button.Key().name("Hello");
    public static final Button.Key intakeRun = new Button.Key().name("Intake Run");
    public static final Button.Key lowShoot = new Button.Key().name("Low Shoot");
}
