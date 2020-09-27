package homeworks.lesson_5_reflection_proxy_annotations;

import org.javatuples.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods. *
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        List<Method> gettersOfFrom = Stream.of(from.getClass().getMethods())
                .filter(method ->
                        method.getName().matches("^get[A-Z]+.*")
                                && method.getParameterCount() == 0
                                && !method.getReturnType().equals(Void.TYPE))
                .collect(Collectors.toList());

        List<Method> settersOfTo = Stream.of(to.getClass().getMethods())
                .filter(method ->
                        method.getName().matches("^set[A-Z]+.*")
                                && method.getParameterCount() == 1
                                && method.getReturnType().equals(Void.TYPE))
                .collect(Collectors.toList());

        ArrayList<Pair<Method, Method>> listPairs = gettersOfFrom.stream().reduce(
                new ArrayList<>(),
                (acc, getter) -> {
                    Pattern patternForGetter = Pattern.compile("^get(.+)$");
                    Matcher matcherForGetter = patternForGetter.matcher(getter.getName());
                    matcherForGetter.find();
                    String getterFieldName = matcherForGetter.group(1);

                    Optional<Method> method = settersOfTo.stream().filter(setter -> {
                        Pattern patternForSetter = Pattern.compile("^set(.+)$");
                        Matcher matcherForSetter = patternForSetter.matcher(setter.getName());
                        matcherForSetter.find();
                        String setterFieldName = matcherForSetter.group(1);

                        return getterFieldName.equals(setterFieldName);
                    }).findAny();

                    method.ifPresent(value -> acc.add(new Pair<>(getter, value)));

                    return acc;
                },
                (arrayList, arrayList2) -> {
                    arrayList.addAll(arrayList2);
                    return arrayList;
                });

        listPairs.forEach(pair -> {
            try {
                Object returnedMethodValueOfFrom = pair.getValue0().invoke(from);
                pair.getValue1().invoke(to, returnedMethodValueOfFrom);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }
}
