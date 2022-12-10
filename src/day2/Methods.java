package day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
    public static void startProgram() throws FileNotFoundException {
        createArray();
    }

    private static void createArray() throws FileNotFoundException {
        FileReader file = new FileReader("src/day2/StrategyGuide.txt");
        ArrayList<String> guide = new ArrayList<>();
        int i = 0;
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                guide.add(i, input.nextLine());
                i++;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        goThroughArray(guide);
    }

    private static void goThroughArray(ArrayList<String> list) {
        int score = 0;

        for(String a : list) {
            //score += findScoreStepOne(a);
            score += findScoreStepTwo(a);
        }

        System.out.println(score);
    }

    private static int findScoreStepOne(String ab) {
        char a = ab.charAt(0);
        char b = ab.charAt(2);
        int score;

        if (b == 'X') score = 1;
        else if (b == 'Y') score = 2;
        else score = 3;

        if (a == 'A') {
            if (b == 'X') score += 3;
            if (b == 'Y') score += 6;
        }
        if (a == 'B') {
            if (b == 'Y') score += 3;
            if (b == 'Z') score += 6;
        }
        if (a == 'C') {
            if (b == 'Z') score += 3;
            if (b == 'X') score += 6;
        }

        return score;
    }

    private static int findScore(String ab) {
        char a = ab.charAt(0);
        char b = ab.charAt(2);
        int score;

        if (b == 'X') score = 1;
        else if (b == 'Y') score = 2;
        else score = 3;

        if (a == 'A') {
            if (b == 'X') score += 3;
            if (b == 'Y') score += 6;
        }
        if (a == 'B') {
            if (b == 'Y') score += 3;
            if (b == 'Z') score += 6;
        }
        if (a == 'C') {
            if (b == 'Z') score += 3;
            if (b == 'X') score += 6;
        }

        return score;
    }

    private static int findScoreStepTwo(String ab) {
        char a = ab.charAt(0);
        char b = ab.charAt(2);
        String input = "";

        if(a == 'A') {
            if(b == 'X') input = "A Z";
            if(b == 'Y') input = "A X";
            if(b == 'Z') input = "A Y";
        }
        if(a == 'B') {
            if(b == 'X') input = "B X";
            if(b == 'Y') input = "B Y";
            if(b == 'Z') input = "B Z";
        }
        if(a == 'C') {
            if(b == 'X') input = "C Y";
            if(b == 'Y') input = "C Z";
            if(b == 'Z') input = "C X";
        }

        return findScore(input);
    }
}
