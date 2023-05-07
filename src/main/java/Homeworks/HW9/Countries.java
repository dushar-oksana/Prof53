package Homeworks.HW9;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Countries {
    //  Есть список стран [Andorra, Belize, France, Argentina, Cuba, Sweden]
    //  и список слов [Andorra, Canada, wood, parrot, Cuba, Argentina, Aruba, Alex, Finland]
    //  Нужно получить список всех стран из списка слов, начинающихся на "A" - [Andorra, Argentina]
    public static void main(String[] args) {
        String [] countries = {"Andorra", "Belize", "France", "Argentina", "Cuba", "Sweden"};
        String [] words = {"Andorra", "Canada", "wood", "parrot", "Cuba", "Argentina", "Aruba", "Alex", "Finland"};

        char letter = 'A';

        ArrayList countriesFromA = findCountriesByLetter(countries, words, letter);
        System.out.println(countriesFromA);

    }



    public static ArrayList findCountriesByLetter(String [] countries, String [] words, char letter) {
        ArrayList<String> wordsFromLetter = new ArrayList<>();
        ArrayList<String> countriesFromLetter = new ArrayList<>();
        for (String word : words
             ) {
            if (word.charAt(0) == letter) {
                wordsFromLetter.add(word);
            }
        }

        //Convert String Array to List
        List<String> countriesList = Arrays.asList(countries);
        for (String word: wordsFromLetter
             ) {
            if (countriesList.contains(word)) {
                countriesFromLetter.add(word);
            }
        }

        return countriesFromLetter;
    }
}

