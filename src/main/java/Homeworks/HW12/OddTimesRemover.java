package Homeworks.HW12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddTimesRemover {
    public static void main(String[] args) {
        int [] ourArray = {1,2,3,1,4,3,2,3};

        System.out.println(remover(ourArray));

    }

    public static List<Integer> remover(int [] arr) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int counter = 0;

            if (res.contains(arr[i])) {
                res.add(arr[i]);
                continue;
            }

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    counter++;
            }

            if (counter % 2 == 0) {
                res.add(arr[i]);
            }
        }

        return res;

    }
}
