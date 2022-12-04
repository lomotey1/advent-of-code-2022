package day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("day4/input.txt"));
        ArrayList<String[]> pairs = new ArrayList<>();
        int redundantPairs = 0;

        while (reader.ready()) {
            String[] pair = reader.readLine().split(",");
            pairs.add(pair);
        } // each pair is a String array inside the ArrayList

        reader.close();

        for (String[] pair : pairs) {
            int[] first = { Integer.parseInt(pair[0].substring(0, pair[0].indexOf("-"))),
                    Integer.parseInt(pair[0].substring(pair[0].indexOf("-") + 1)) };

            int[] second = { Integer.parseInt(pair[1].substring(0, pair[1].indexOf("-"))),
                    Integer.parseInt(pair[1].substring(pair[1].indexOf("-") + 1)) };

            if (first[1] - first[0] < second[1] - second[0]) {
                boolean flag = false;
                for (int i = first[0]; i <= first[1]; i++) {
                    if (i >= second[0] && i <= second[1]) {
                        continue;
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    redundantPairs += 1;
            } else {// go through second pair
                boolean flag = false;
                for (int i = second[0]; i <= second[1]; i++) {
                    if (i >= first[0] && i <= first[1]) {
                        continue;
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    redundantPairs += 1;
            }
        }
        System.out.println(redundantPairs);
    }
}
