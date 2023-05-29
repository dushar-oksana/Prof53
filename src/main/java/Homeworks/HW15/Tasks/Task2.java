package Homeworks.HW15.Tasks;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        // Дан список строк в котором некоторые элементы повторяются. Распечатать все элементы списка и количество повторений.
        String [] strings = {"java", "map", "map", "key", "dog"};
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String str : strings) {
            if (!stringIntegerMap.containsKey(str)) {
                stringIntegerMap.put(str, 1);
            } else {
                int val = stringIntegerMap.get(str) + 1;
                stringIntegerMap.put(str, val);
            }
        }
        System.out.println(stringIntegerMap);
    }
}
