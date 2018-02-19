package at.kuchel.util;

public class ObjectUtils {
    @SuppressWarnings("unchecked")
    public static <T> T cast(final Object obj) {
        return (T) obj;
    }
}
