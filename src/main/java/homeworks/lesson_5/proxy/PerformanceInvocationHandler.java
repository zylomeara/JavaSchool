package homeworks.lesson_5.proxy;

import homeworks.lesson_5.annotations.Metric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import static java.lang.ClassLoader.getSystemClassLoader;

public class PerformanceInvocationHandler implements InvocationHandler {
    final Object delegate;

    public PerformanceInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T proxyFactory(Object delegate) {
        return (T) Proxy.newProxyInstance(
                getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new PerformanceInvocationHandler(delegate)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Metric.class)) {
            long timeStart = System.currentTimeMillis();
            Object result =  method.invoke(delegate, args);
            long timeLeft = System.currentTimeMillis() - timeStart;

            System.out.printf("%s is completed in %d ms with args %s%n", method.getName(), timeLeft, Arrays.toString(args));

            return result;
        } else {
            return method.invoke(delegate, args);
        }
    }
}
