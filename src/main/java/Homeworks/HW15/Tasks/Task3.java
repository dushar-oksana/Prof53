package Homeworks.HW15.Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        // Сгруппируйте элементы списка по уникальному набору символов
        String [] strings = {"student", "students", "dog", "god", "cat", "act", "flow", "wolf"};
        Map<String, ArrayList<String>> groupedWords = groupWords(strings);
        System.out.println(groupedWords.values());
}

    public static String strToSymbols(String str) {
        char charArray[] = str.toCharArray();
        Arrays.sort(charArray);
        str = Arrays.toString(charArray);
        return str;
    }

    public static Map<String, ArrayList<String>> groupWords(String [] s) {
        String [] strings = s.clone();
        Map<String, ArrayList<String>> groupedWords = new HashMap<>();
        for (int i = 0; i < strings.length-1; i++) {
            if (strings[i] == null)
                continue;
            for (int j = i+1; j < strings.length; j++) {
                if (strings[j] == null)
                    continue;
                String s1 = strings[i];
                String s2 = strings[j];
                if (s1.length() < s2.length()) {
                    s2 = s2.substring(0, s1.length());
                } else {
                    s1 = s1.substring(0, s2.length());
                }

                if (strToSymbols(s1).contentEquals(strToSymbols(s2))) {
                    ArrayList<String> val = new ArrayList<>();
                    val.add(strings[i]);
                    val.add(strings[j]);
                    String key = strToSymbols(s1);
                    groupedWords.put(key, val);
                    strings[j] = null;
                }
            }

        }
        return groupedWords;
    }
}
