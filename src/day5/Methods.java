package day5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Methods {
    public static ArrayDeque<Character> stack1 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack2 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack3 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack4 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack5 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack6 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack7 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack8 = new ArrayDeque<>();
    public static ArrayDeque<Character> stack9 = new ArrayDeque<>();


    public static void startProgram() throws FileNotFoundException {
        createArrayCrates();
        createArrayInstrutions();
    }

    private static void createArrayCrates() throws FileNotFoundException {
        FileReader file = new FileReader("src/day5/Crates.txt");
        ArrayList<String> crates = new ArrayList<>();
        int i = 0;
        try {
            Scanner input = new Scanner(file);
            while(input.hasNextLine()) {
                crates.add(i, input.nextLine());
                i++;
            }
            input.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        goThroughCrates(crates);
    }

    private static void createArrayInstrutions() throws FileNotFoundException {
        FileReader file = new FileReader("src/day5/Instructions.txt");
        ArrayList<String> instructions = new ArrayList<>();
        int i = 0;
        try {
            Scanner input = new Scanner(file);
            while(input.hasNextLine()) {
                instructions.add(i, input.nextLine());
                i++;
            }
            input.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        followInstructions(instructions);
    }

    private static void createStacks(String str) {
        int stack = 1;
        int spaces = 0;
        int pointer = 0;

        while(pointer < str.length()) {
            while(str.charAt(pointer) == ' ') {
                pointer++;
                spaces++;
                if(spaces == 4) {
                    stack++;
                    spaces = 0;
                }
            }
            pointer++;
            switch (stack) {
                case 1 -> stack1.addLast(str.charAt(pointer));
                case 2 -> stack2.addLast(str.charAt(pointer));
                case 3 -> stack3.addLast(str.charAt(pointer));
                case 4 -> stack4.addLast(str.charAt(pointer));
                case 5 -> stack5.addLast(str.charAt(pointer));
                case 6 -> stack6.addLast(str.charAt(pointer));
                case 7 -> stack7.addLast(str.charAt(pointer));
                case 8 -> stack8.addLast(str.charAt(pointer));
                case 9 -> stack9.addLast(str.charAt(pointer));
            }
            pointer += 2;
            stack++;
            spaces = 0;
        }
    }

    private static void goThroughCrates(ArrayList<String> crates) {
        for(int i = crates.size() - 1; i >= 0; i--) {
            createStacks(crates.get(i));
        }
    }

    private static void followInstructions(ArrayList<String> instructions) {
        for(int i = 0; i < instructions.size(); i++) {
            String str = instructions.get(i).replaceAll("[^0-9]", "");
            int amount;
            int from;
            int to;

            if(str.length() == 4) {
                amount = Integer.parseInt(str.substring(0, 2));
                from = Integer.parseInt(String.valueOf(str.charAt(2)));
                to = Integer.parseInt(String.valueOf(str.charAt(3)));
            } else {
                amount = Integer.parseInt(String.valueOf(str.charAt(0)));
                from = Integer.parseInt(String.valueOf(str.charAt(1)));
                to = Integer.parseInt(String.valueOf(str.charAt(2)));
            }

            ArrayDeque<Character> fromStack = assign(from);
            ArrayDeque<Character> toStack = assign(to);

            for(int j = 0; j < amount; j++) {
                if(!fromStack.isEmpty()) {
                    toStack.addLast(fromStack.removeLast());
                }
            }
        }

        topOfStacks();
    }

    private static ArrayDeque<Character> assign(int stack) {
        switch (stack) {
            case 1 -> {
                return stack1;
            }
            case 2 -> {
                return stack2;
            }
            case 3 -> {
                return stack3;
            }
            case 4 -> {
                return stack4;
            }
            case 5 -> {
                return stack5;
            }
            case 6 -> {
                return stack6;
            }
            case 7 -> {
                return stack7;
            }
            case 8 -> {
                return stack8;
            }
            case 9 -> {
                return stack9;
            }
        }

        return stack1;
    }

    public static void topOfStacks() {
        StringBuilder str = new StringBuilder();

        if(!stack1.isEmpty()) str.append(stack1.peekLast());
        if(!stack2.isEmpty()) str.append(stack2.peekLast());
        if(!stack3.isEmpty()) str.append(stack3.peekLast());
        if(!stack4.isEmpty()) str.append(stack4.peekLast());
        if(!stack5.isEmpty()) str.append(stack5.peekLast());
        if(!stack6.isEmpty()) str.append(stack6.peekLast());
        if(!stack7.isEmpty()) str.append(stack7.peekLast());
        if(!stack8.isEmpty()) str.append(stack8.peekLast());
        if(!stack9.isEmpty()) str.append(stack9.peekLast());

        System.out.println(str);
    }
}
