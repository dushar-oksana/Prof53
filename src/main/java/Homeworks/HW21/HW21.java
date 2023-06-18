package Homeworks.HW21;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HW21 {
    public static void main(String[] args) {
        String [] lines = {
                "one two three four we need this", // 0
                "can one be happy", // 1
                "three of us make one need", // 2
                "this will be four" }; // 3



        // 1. Создать map из строки в ее длину
        Map<String, Integer> linesStringToLength = Arrays.stream(lines)
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                String::length
                        )
                );
        System.out.println(linesStringToLength);

        // *2. Создать map из слова и списка из номеров строк, к которых эти слова присутствуют, например, для слова "one" пара в map должна быть "one" -> [0, 1, 2]

    }
}
