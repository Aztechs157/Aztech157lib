package org.aztechs157.lib.input;

public interface Labelable<T> {
    public T label(final String label);

    @SuppressWarnings("unchecked")
    static <T> void unstable_autoLabel(final T object) {
        try {
            for (final var field : object.getClass().getFields()) {
                final var value = field.get(object);
                if (value instanceof Labelable) {
                    ((Labelable<Object>) value).label(field.getName());
                }
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
