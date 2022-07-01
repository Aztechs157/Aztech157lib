package org.aztechs157.examples.input;

import org.aztechs157.lib.input.parts.Axis;
import org.aztechs157.lib.input.parts.Button;

public class Keys {
    public enum ButtonKeys implements Button.Key {
        Hello, UptakeRun, KickerRun, IntakeRun, ShooterRun, EjectCargo, DebugPrint, AutoAim, LowShoot,
        ResetDrivePosition, TrackCargo, autoTest, Hang, ExtendHanger, RetractHanger, RotateHangLeft, RotateHangRight,
        CenterTurret
    }

    public enum DebugButtonKeys implements Button.Key {
        PrintFoo, PrintBar
    }

    public enum AxisKeys implements Axis.Key {
        TurnTurret, DriveSpeedX, DriveSpeedY, DriveRotation,
        TurretSpeed, AimerSpeed, ExtendSpeed, RotateSpeed
    }
}
