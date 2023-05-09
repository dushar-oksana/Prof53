package Homeworks.HW10;


import java.util.LinkedHashSet;

public class Concordance {
    public static void main(String[] args) {
        String str = "one plus one equals one";

        Concordance concordance = new Concordance();
        LinkedHashSet<Word> strConcordance = concordance.stringConcordance(str);
        System.out.println(strConcordance);

    }


    public LinkedHashSet<Word> stringConcordance(String str) {
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
