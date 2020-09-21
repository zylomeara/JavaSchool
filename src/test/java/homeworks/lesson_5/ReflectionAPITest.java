package homeworks.lesson_5;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ReflectionAPITest {
    @Test
    public void testShowAllMethodsWithPrivateIncludeParents() {
        AtomicReference<Class<?>> container = new AtomicReference<>(Child.class);
        Stream.generate(() -> container.getAndSet(container.get().getSuperclass()))
                .takeWhile(cls -> cls != null && cls != Object.class)
                .flatMap(cls -> Stream.of(cls.getDeclaredMethods()))
                .forEach(method -> System.out.println(method.getName()));
    }

    @Test
    public void testShowAllGetters() {
        Method[] declaredMethods = Parent.class.getDeclaredMethods();

        Stream.of(declaredMethods)
                .filter(method -> method.getName().matches("^get[A-Z]+.*"))
                .forEach(method -> System.out.println(method.getName()));
    }

    @Test
    public void testCheckConstantsStringValues() {
        Field[] declaredFields = Parent.class.getDeclaredFields();

        assert Stream.of(declaredFields)
                .filter(field -> field.getType() == String.class)
                .allMatch(field -> {
                    String fieldName = field.getName();
                    try {
                        String fieldValue = (String) field.get(null);

                        return fieldName.equals(fieldValue);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return false;
                });
    }
}
