package day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

    public static void startProgram() throws FileNotFoundException {
        createArray();
    }

    private static void createArray() throws FileNotFoundException {
        FileReader file = new FileReader("src/day3/Rucksacks.txt");
        ArrayList<String> racksacks = new ArrayList<>();
        int i = 0;
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                racksacks.add(i, input.nextLine());
                i++;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        goThroughList(racksacks);
    }

    private static void goThroughList(ArrayList<String> list) {
        int sum = 0;

        for(String a : list) {
            sum += findSum(a);
        }

        System.out.println(sum);
    }

    private static int findSum(String s) {
        String a = s.substring(0, (s.length()/2));
        String b = s.substring((s.length()/2));

        char[] first = a.toCharArray();
        char[] second = b.toCharArray();

        char same = 0;

        for(int i = 0; i < first.length; i++) {
            for(int j = 0; j < second.length; j++) {
                if(first[i] == second[j]) {
                    same = first[i];
                    break;
                }
            }
        }
        return priority(same);
    }

    private static int priority(char c) {
        String priority = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return priority.indexOf(c);
    }
}
