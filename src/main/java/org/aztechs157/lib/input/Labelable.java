package org.aztechs157.lib.input;

public interface Labelable<T> {
    public T label(final String label);

    static <T extends Labelable<T>> void experimental_autoLabel(final T object) {
        for (final var field : object.getClass().getFields()) {
            try {
                final var value = field.get(object);
                if (value instanceof Labelable) {
                    ((Labelable<?>) value).label(field.getName());
                }
            } catch (final Exception e) {
                System.err.println(e);
            }
        }
    }
}
