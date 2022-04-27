package org.aztechs157.lib.input.keys;

public interface RequiredKey extends KeyBase {
    @Override
    default boolean optional() {
        return false;
    }
}
