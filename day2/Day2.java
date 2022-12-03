package day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2 {

    public static int part1(String game) {
        int result = 0;
        int opponent = Integer.parseInt(game.substring(0, 1));
        int player = Integer.parseInt(game.substring(2));

        result += player; // score based on choice alone

        if (player == opponent)
            result += 3;

        else if (player - opponent == 1 || (player == 1 && opponent == 3))  {
            result += 6;
        }

        return result;
    }

    public static int part2(String game) {
        int result = 0;
        int opponent = Integer.parseInt(game.substring(0, 1));
        int gameOutcome = Integer.parseInt(game.substring(2));

        switch(gameOutcome){
            case 1: //lose
            if (opponent == 1)
            result += 3;
        else 
            result += (opponent - 1);
        break;
            case 2: //draw
                result += 3;
                result += opponent;
                break;
            case 3: //win
                result += 6;
                if (opponent == 3)
                    result += 1;
                else 
                    result += (opponent + 1);
                break;
            default:
                break;
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("day2/input.txt"));

        ArrayList<String> games = new ArrayList<>();
        int part1Score = 0;
        int part2Score = 0;

        while (reader.ready()) {

            String next = reader.readLine();
            next = next.replaceAll("[A,X]", "1");
            next = next.replaceAll("[B,Y]", "2");
            next = next.replaceAll("[C,Z]", "3");
            games.add(next);
        }

        reader.close();

        for (String game : games) {

            part1Score += part1(game);
            part2Score += part2(game);
        }

        System.out.println("Part 1 Score: " + part1Score);
        System.out.println("Part 2 Score: " + part2Score);
    }
}
