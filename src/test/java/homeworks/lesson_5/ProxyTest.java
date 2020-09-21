package homeworks.lesson_5;

import homeworks.lesson_5.proxy.CachedInvocationHandler;
import homeworks.lesson_5.proxy.PerformanceInvocationHandler;
import org.junit.Test;

import java.util.stream.Stream;

public class ProxyTest {
    @Test
    public void testCacheProxy() {
        ICalculator calculator = new Calculator();
        ICalculator proxyCalc = CachedInvocationHandler.proxyFactory(calculator);

        Stream.of(1, 1, 2, 3, 3, 5, 1).forEachOrdered(proxyCalc::calc);
    }

    @Test
    public void testPerformanceProxy() {
        ICalculator calculator = new Calculator();
        ICalculator proxyCalc = PerformanceInvocationHandler.proxyFactory(calculator);

        Stream.of(1, 1, 2, 3, 3, 5, 1).forEachOrdered(proxyCalc::calc);
    }

    @Test
    public void testCacheAndPerformanceProxy() {
        ICalculator calculator = new Calculator();
        ICalculator cacheProxyCalc = CachedInvocationHandler.proxyFactory(calculator);
        ICalculator perfProxyCalc = PerformanceInvocationHandler.proxyFactory(cacheProxyCalc);

        Stream.of(1, 1, 2, 3, 3, 5, 1)
                .forEachOrdered(number -> {
                    perfProxyCalc.calc(number);
                    System.out.println("-------");
                });
    }
}
