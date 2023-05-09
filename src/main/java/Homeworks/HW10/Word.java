package Homeworks.HW10;

import java.util.ArrayList;
import java.util.Arrays;

public class Word {
    private String word;

    private ArrayList<Integer> positions = new ArrayList<>();

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void addToPositions(Integer i) {
        positions.add(i);
    }

    @Override
    public String toString() {
        return word + ':' + positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
