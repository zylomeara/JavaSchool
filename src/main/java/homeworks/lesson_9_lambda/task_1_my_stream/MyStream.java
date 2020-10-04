package homeworks.lesson_9_lambda.task_1_my_stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyStream<P> {
    List<P> list;

    public MyStream(P[] args) {
        list = Arrays.asList(args);
    }

    public static <T> MyStream<T> of (T ...args) {
        return new MyStream<T>(args);
    }

    public void forEach(Consumer<P> fn) {
        for(P el: list) {
            fn.accept(el);
        }
    }

    public MyStream<P> filter(Function<P, Boolean> fn) {
        List<P> newList = new ArrayList<>();
        for(P el: list) {
            if(fn.apply(el)) {
                newList.add(el);
            }
        }
        list = newList;
        return this;
    }

    public MyStream<P> map(Function<P, P> fn) {
        List<P> newList = new ArrayList<>();
        for(P el: list) {
            newList.add(fn.apply(el));
        }
        list = newList;
        return this;
    }

    public MyStream<P> distinct() {
        Set<P> set = new HashSet<>(list);
        list = new ArrayList<>(set);
        return this;
    }
}
