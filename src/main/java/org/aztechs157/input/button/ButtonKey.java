package org.aztechs157.input.button;

public interface ButtonKey {
    public default boolean optional() {
        return false;
    }

    public interface Optional extends ButtonKey {
        @Override
        public default boolean optional() {
            return true;
        }
    }
}
