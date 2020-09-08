package homeworks.lesson_2;

import homeworks.lesson_2.task_5.ReverseIterator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestProcessWords {
    String text;
    Properties props = new Properties();

    @Before
    public void init() {
        String PROPERTIES_FILENAME = "file.properties";
        InputStream inputStream;

        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_FILENAME);
            props.load(inputStream);
            text = String.join("\n", Files.readAllLines(Paths.get(props.getProperty("path"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TASK 1
    @Test
    public void testCountWords() {
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }

        assert words.size() == 43;
    }

    // TASK 2
    @Test
    public void testSortAndShowWords() {
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }

        words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
    }

    // TASK 3
    @Test
    public void testCountEveryWords() {
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+");
        Matcher matcher = pattern.matcher(text);
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group());
        }

        Map<String, Long> wordsGrouped = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        System.out.println(wordsGrouped);
    }

    // TASK 4
    @Test
    public void testReverseOrderOfRows() {
        List<String> rows = Arrays.stream(text.split("\\n"))
                .collect(Collectors.toList());
        Collections.reverse(rows);
        rows.forEach(System.out::println);
    }

    // TASK 5
    @Test
    public void testReverseIterator() {
        List<String> rows = Arrays.stream(text.split("\\n"))
                .collect(Collectors.toList());

        for (String s : new ReverseIterator<>(rows)) {
            System.out.println(s);
        }
    }

    // TASK 6
    @Test
    public void testShowSpecifiedRows() {
        List<String> rows = Arrays.stream(text.split("\\n"))
                .collect(Collectors.toList());

        Arrays.stream(props.getProperty("allowed-rows")
                .split(","))
                .map(i -> Integer.parseInt(i) - 1)
                .map(rows::get)
                .forEach(System.out::println);
    }
}
