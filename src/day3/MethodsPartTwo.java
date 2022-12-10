package day3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodsPartTwo {
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
        String a;
        String b;
        String c;

        for(int i = 0; i < list.size(); i += 3) {
            a = list.get(i);
            b = list.get(i + 1);
            c = list.get(i + 2);

            sum += findSum(a, b, c);
        }

        System.out.println(sum);
    }

    private static int findSum(String a, String b, String c) {
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        char[] third = c.toCharArray();

        char same = 0;

        for(int i = 0; i < first.length; i++) {
            for(int j = 0; j < second.length; j++) {
                if(first[i] == second[j]) {
                    for(int x = 0; x < third.length; x++) {
                        if(second[j] == third[x]) {
                            same = third[x];
                            break;
                        }
                    }
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
