package day6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Methods {
    public static void startProgram() throws FileNotFoundException {
        createString();
    }

    private static void createString() throws FileNotFoundException {
        FileReader file = new FileReader("src/day6/Signal.txt");
        String signal = "";

        try{
            Scanner input = new Scanner(file);
            signal = input.nextLine();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(goThroughSignal(signal));
    }

    private static int goThroughSignal(String signal) {
        int lp = 0;
        int rp = 14;
        String str;

        for(int i = 0; i < signal.length(); i++) {
            str = signal.substring(lp, rp);
            if(checkSignal(str)) return rp;
            lp++;
            rp++;
        }

        return 0;
    }

    private static boolean checkSignal(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }
}
