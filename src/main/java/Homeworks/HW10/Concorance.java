package Homeworks.HW10;


import java.util.LinkedHashSet;

public class Concorance {
    public static void main(String[] args) {
        String str = "one plus one equals one";

        Word wordd = new Word("Hello");
        wordd.addToPositions(0);
        System.out.println(wordd);

        Concorance concorance = new Concorance();
        LinkedHashSet<Word> strConcorance = concorance.stringConcorance(str);
        System.out.println(strConcorance);

    }


    public LinkedHashSet<Word> stringConcorance(String str) {
        String[] strArr = str.split(" ");
        LinkedHashSet<Word> strCon = new LinkedHashSet<>();

        for (int i = 0; i < strArr.length; i++) {

            Word word = new Word(strArr[i]);

            if (!strCon.contains(word)) {
                word.addToPositions(i);
                strCon.add(word);
                continue;
            }

            for (Word w : strCon) {
                if (w.getWord().equals(strArr[i])) {
                    w.addToPositions(i);
                } else {
                    word.addToPositions(i);
                    strCon.add(word);
                }
            }

            }

        return strCon;

    }
}
