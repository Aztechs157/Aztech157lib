package org.aztechs157.lib.input;

public abstract class BaseKey<T extends BaseKey<T>> implements Labelable<BaseKey<T>> {
    private String label = "Unlabeled Key";

    @SuppressWarnings("unchecked")
    public T label(final String label) {
        this.label = label;
        return (T) this;
    }

    @Override
    public String toString() {
        return label;
    }
}
