package day4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Methods {

    public static void startProgram() throws FileNotFoundException {
        createArray();
    }

    private static void createArray() throws FileNotFoundException {
        FileReader file = new FileReader("src/day4/Sections.txt");
        ArrayList<String> Sections = new ArrayList<>();
        int i = 0;
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                Sections.add(i, input.nextLine());
                i++;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        goThroughList(Sections);
    }

    private static void goThroughList(ArrayList<String> list) {
        int pairs = 0;

        for(String a : list) {
            if(findPairs(a)) pairs++;
        }

        System.out.println(pairs);
    }

    private static boolean findPairs(String str) {
        String[] array = new String[4];
        int x = 0;

        int leftPointer = 0;
        int rightPointer = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(rightPointer) != ',' && str.charAt(rightPointer) != '-') rightPointer++;
            else {
                array[x] = str.substring(leftPointer, rightPointer);
                leftPointer = rightPointer + 1;
                x++;
                rightPointer++;
            }
        }

        array[x] = str.substring(leftPointer);

        return contains(array);
    }

    private static boolean contains(String[] array) {
        int[] section = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
        boolean check = false;

        if(section[0] <= section[2]) {
            if(section[1] >= section[3]) check = true;
        }

        if(section[2] <= section[0]) {
            if(section[3] >= section[1]) check = true;
        }

        return check;
    }
}
