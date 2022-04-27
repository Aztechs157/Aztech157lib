package org.aztechs157.lib.input.keys;

public interface OptionalKey extends KeyBase {
    @Override
    default boolean optional() {
        return false;
    }
}
