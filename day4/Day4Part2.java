package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Day4Part2 {
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

            boolean flag = false;
            for (int i = first[0]; i <= first[1]; i++) {
                if (i >= second[0] && i <= second[1]) {
                    flag = true;
                    break;
                }
                else {
                    flag = false;
                }
            }
            if (flag)
                redundantPairs += 1;
        }
        System.out.println(redundantPairs);
    }
}
