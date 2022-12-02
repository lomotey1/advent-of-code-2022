import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        int largest = 0;
        int current = 0;

        while (reader.ready()) {

            String next = reader.readLine();
            if (next.isEmpty()) {
                largest = (current >= largest) ? current : largest;
                current = 0;
                continue;
            }

            current += Integer.parseInt(next);

        }

        reader.close();
        System.out.println(largest);
    }
}