package org.aztechs157.lib.input.inputs;

import java.util.function.Supplier;

import org.aztechs157.lib.input.BaseKey;
import org.aztechs157.lib.input.Labelable;

import edu.wpi.first.wpilibj.GenericHID;

public class Raw implements Labelable<Raw> {
    public static class Key extends BaseKey<Key> {
    }

    private final Supplier<GenericHID> value;

    public Raw(final Supplier<GenericHID> value) {
        this.value = value;
    }

    public static Raw fromDriverStation(final int deviceId) {
        final var cached = new GenericHID(deviceId);

        return new Raw(() -> cached)
                .label("Device " + deviceId + " Raw");
    }

    private String label = "Unknown";

    public Raw label(final String label) {
        this.label = label;
        return this;
    }

    @Override
    public String toString() {
        return label;
    }

    public GenericHID get() {
        return value.get();
    }
}
