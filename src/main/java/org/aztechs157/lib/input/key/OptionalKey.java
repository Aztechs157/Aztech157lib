package org.aztechs157.lib.input.key;

public interface OptionalKey extends KeyBase {
    @Override
    default boolean optional() {
        return false;
    }
}
