package homeworks.lesson_9_lambda.task_4_gamma;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.javatuples.Pair;

public class Gamma {
    private static final int A = 3, C = 2, m = 101;

    public static byte[] encrypt(String text, int key) {
        List<Byte> bytes = Stream.iterate(
                new Pair<>(key, 0),
                pair -> new Pair<>(
                        (pair.getValue0() * A + C) % m,
                        pair.getValue1() + 1
                ))
                .limit(text.length())
                .map(pair -> (byte) (text.charAt(pair.getValue1()) ^ pair.getValue0()))
                .collect(Collectors.toList());

        return ArrayUtils.toPrimitive(bytes.toArray(new Byte[0]));
    }

    public static String decrypt(byte[] text, int key) {
        List<Byte> bytes = Stream.iterate(
                new Pair<>(key, 0),
                pair -> new Pair<>(
                        (pair.getValue0() * A + C) % m,
                        pair.getValue1() + 1
                ))
                .limit(text.length)
                .map(pair -> (byte) (text[pair.getValue1()] ^ pair.getValue0()))
                .collect(Collectors.toList());

        return new String(ArrayUtils.toPrimitive(bytes.toArray(new Byte[0])));
    }
}
