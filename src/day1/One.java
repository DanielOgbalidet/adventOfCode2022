package day1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class One {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("src/day1/Calories.txt");
        ArrayList<String> calories = new ArrayList<>();
        int i = 0;
        try {
            Scanner input = new Scanner(file);
            while(input.hasNextLine()) {
                String next = input.nextLine();
                if(next.equals("")) calories.add(i, "-1");
                else calories.add(i, next);
                i++;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Integer> newCalories =  convert(calories);

        int big = biggest(newCalories);
        System.out.println(big);

        int threeBiggest = threeBiggest(newCalories);
        System.out.println(threeBiggest);
    }


    public static ArrayList<Integer> convert(ArrayList<String> string) {
        ArrayList<Integer> newList = new ArrayList<>(string.size());
        for(String a : string) {
            newList.add(Integer.valueOf(a));
        }
        return newList;
    }

    public static int biggest(ArrayList<Integer> list) {
        int big = 0;
        int check = 0;

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) != -1) {
                check += list.get(i);
            }

            else {
                if(check > big) big = check;
                check = 0;
            }
        }

        return big;
    }

    public static int threeBiggest(ArrayList<Integer> list) {
        int big = 0;
        int bigger = 0;
        int biggest = 0;
        int check = 0;

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) != -1) {
                check += list.get(i);
            }

            else {
                if(check > big) {
                    if(check > bigger) {
                        if(check > biggest) {
                            big = bigger;
                            bigger = biggest;
                            biggest = check;
                        }
                        else {
                            big = bigger;
                            bigger = check;
                        }
                    }
                    else {
                        big = check;
                    }
                }
                check = 0;
            }
        }

        return big + bigger + biggest;
    }


}
