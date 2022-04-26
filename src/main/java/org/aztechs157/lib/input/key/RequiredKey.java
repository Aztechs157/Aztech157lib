package org.aztechs157.lib.input.key;

public interface RequiredKey extends KeyBase {
    @Override
    default boolean optional() {
        return false;
    }
}
