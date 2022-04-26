package org.aztechs157.examples.input;

import org.aztechs157.lib.input.axis.AxisKey;
import org.aztechs157.lib.input.button.ButtonKey;
import org.aztechs157.lib.input.key.RequiredKey;
import org.aztechs157.lib.input.key.OptionalKey;

public class Keys {
    public enum Button implements ButtonKey, RequiredKey {
        Hello, UptakeRun, KickerRun, IntakeRun, ShooterRun, EjectCargo, DebugPrint,
        AutoAim, LowShoot, ResetDrivePosition, TrackCargo, autoTest, Hang,
        ExtendHanger, RetractHanger, RotateHangLeft, RotateHangRight, CenterTurret
    }

    public enum DebugButton implements ButtonKey, OptionalKey {
        PrintFoo, PrintBar
    }

    public enum Axis implements AxisKey, RequiredKey {
        TurnTurret, DriveSpeedX, DriveSpeedY, DriveRotation,
        TurretSpeed, AimerSpeed, ExtendSpeed, RotateSpeed
    }
}
