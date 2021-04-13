package Problem3;

import java.io.PrintStream;
import java.util.Scanner;

// This main function builds a story and prints it on the screen
// GitHub bot does NOT run this as a test

public class Main {
    public static void main(String[] args) {
        System.out.print("let's play Improv!! type 'over' when done. Start: ... ");

        StoryBuilder storyBuilder = new StoryBuilder();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("over")) {
            storyBuilder.buildWithYesAnd(input);
            System.out.print("yes, and ... ");
            input = scanner.nextLine();
        }

        System.out.println("In summary:");
        PrintStream toScreen = System.out;
        storyBuilder.tellStory(toScreen);
    }

    /*
    TODO: extra credit
     */
}