package homeworks.lesson_5.proxy;

import homeworks.lesson_5.annotations.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.ClassLoader.getSystemClassLoader;

public class CachedInvocationHandler implements InvocationHandler {
    final Object delegate;
    final Map<Method, Map<Integer, Object>> cache = new HashMap<>();

    public CachedInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T proxyFactory(Object delegate) {
        return (T) Proxy.newProxyInstance(
                getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new CachedInvocationHandler(delegate)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            int argsHashCode = Arrays.hashCode(args);
            Object result;

            cache.putIfAbsent(method, new HashMap<>());
            Map<Integer, Object> cachedMethod = cache.get(method);

            if (cachedMethod.containsKey(argsHashCode)) {
                result = cachedMethod.get(argsHashCode);
                System.out.printf("Get from cache (method=%s, args=%s, result=%s)%n", method.getName(), Arrays.toString(args), result);
            } else {
                result = method.invoke(delegate, args);
                cachedMethod.put(argsHashCode, result);
                System.out.printf("Set to cache (method=%s, args=%s, result=%s)%n", method.getName(), Arrays.toString(args), result);
            }

            return result;
        } else {
            return method.invoke(delegate, args);
        }
    }
}
