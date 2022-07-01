package org.aztechs157.lib.input.models;

import org.aztechs157.lib.input.Axis;
import org.aztechs157.lib.input.Button;
import org.aztechs157.lib.input.Model;
import org.aztechs157.lib.input.Pov;

public class LogitechGamepadF310 extends Model {

    public LogitechGamepadF310(final int joystickId) {
        super(joystickId);
    }

    public final Button a = button(1).name("A");
    public final Button b = button(2).name("B");
    public final Button x = button(3).name("X");
    public final Button y = button(4).name("Y");
    public final Button leftBumper = button(5).name("Left Bumper");
    public final Button rightBumper = button(6).name("Right Bumper");
    public final Button back = button(7).name("Back");
    public final Button start = button(8).name("Start");
    public final Button leftStickPress = button(9).name("Left Stick Press");
    public final Button rightStickPress = button(10).name("Right Stick Press");

    public final Axis leftStickX = axis(0).name("Left Stick X");
    public final Axis leftStickY = axis(1).name("Left Stick Y");
    public final Axis rightTriggerHeld = axis(2).name("Right Trigger Held");
    public final Axis leftTriggerHeld = axis(3).name("Left Trigger Held");
    public final Axis rightStickX = axis(4).name("Right Stick X");
    public final Axis rightStickY = axis(5).name("Right Stick Y");

    public final Pov pov = pov(0).name("");
}
