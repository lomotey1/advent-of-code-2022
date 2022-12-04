package day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Day3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        ArrayList<String> items = new ArrayList<>();

        while (reader.ready()) {
            items.add(reader.readLine());
        }
        reader.close();

        part1(items);
        part2(items);

    }

    public static void part1(ArrayList<String> items) {
        int prioritySum = 0;

        boolean continueLoop = false;

        for (String item : items) {
            continueLoop = false;

            String firstHalf = item.substring(0, item.length() / 2);
            String secondHalf = item.substring(item.length() / 2);

            for (int i = 0; i < firstHalf.length(); i++) {

                for (int j = 0; j < secondHalf.length(); j++) {
                    if (continueLoop)
                        continue;

                    if (Character.valueOf(firstHalf.charAt(i)) == Character.valueOf(secondHalf.charAt(j))) {

                        char temp = firstHalf.charAt(i);
                        if (Character.isLowerCase(temp)) {
                            prioritySum += ((int) (temp) - 96);
                            continueLoop = true;
                            break;
                        } else {
                            prioritySum += ((int) (temp) - 38);
                            continueLoop = true;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Sum for part 1: " + prioritySum);

    }

    public static void part2(ArrayList<String> items) {
        int prioritySum = 0;
        boolean continueLoop = false;

        for (int i = 0; i < items.size(); i += 3) {
            continueLoop = false;

            String first = items.get(i);
            String second = items.get(i + 1);
            String third = items.get(i + 2);

            for (int j = 0; j < first.length(); j++) {
                for (int k = 0; k < second.length(); k++) {
                    for (int l = 0; l < third.length(); l++) {
                        if (continueLoop)
                            continue;

                        if (Character.valueOf(first.charAt(j)) == Character.valueOf(second.charAt(k))
                                && Character.valueOf(second.charAt(k)) == Character.valueOf(third.charAt(l))) {
                            char temp = first.charAt(j);
                            if (Character.isLowerCase(temp)) {
                                prioritySum += ((int) (temp) - 96);
                                continueLoop = true;
                                break;
                            } else {
                                prioritySum += ((int) (temp) - 38);
                                continueLoop = true;
                                break;
                            }
                        }
                    }

                }
            }

        }
        System.out.println("Sum for part 2: " + prioritySum);
    }
}
