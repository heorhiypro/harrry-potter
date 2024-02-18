package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        LocalDateTime start = LocalDateTime.now();
        String content = new String(Files.readAllBytes(Paths.get("src/edu/pro/txt/harry.txt")));

        String contentCleaned = content.replaceAll("[^A-Za-z ]"," ").toLowerCase(Locale.ROOT);

        String[] words = contentCleaned.split(" +");
        List<String> list = new ArrayList<>(
                Arrays.asList(words)
        );
        List<Word> wordsList = new ArrayList<>();
        List<String> unique = list.stream().distinct().collect(Collectors.toList());
        unique.stream()
                        .forEach(word -> {
                            int freq = (int) list.stream()
                                    .filter(item -> item.equals(word))
                                    .count();
                            wordsList.add(new Word(word, freq));
                           }
                        );

        List<Word> result = wordsList.stream()
                        .sorted(Comparator.comparingInt(Word::getFreq).reversed())
                        .collect(Collectors.toList());
        result.stream().limit(10)
                        .forEach(System.out::println);
        System.out.println("------");
        System.out.println(ChronoUnit.MILLIS.between(LocalDateTime.now(), start));
    }
}
