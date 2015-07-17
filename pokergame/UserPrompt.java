package javabootcampweek4.pokergame;

import java.util.Scanner;

/**
 * Created by Abram on 7/7/2015.
 */
public class UserPrompt {

    Scanner in = new Scanner(System.in);
    private String userInput = "";
    String name;

    public String begin(){
        do {
            System.out.println("Start poker game?  (Yes or no)");
            userInput = in.nextLine().toLowerCase();
        } while (!userInput.contains("y") && !userInput.contains("n"));

        if (userInput.contains("y" )) {
            System.out.println("All right!");
            System.out.println("What's your name?");
            name = in.nextLine();
        } else {
            System.out.println("Well fine! Then bye!");
            System.exit(0);
        }
        return name;
    }

    public int setUpOpponents(){
        System.out.println("Ok, " + name + "! How many opponents do you want to play against?  (up to 4)");
        userInput = in.nextLine();
        return Integer.valueOf(userInput);
    }

    public int setUpStack(){
        System.out.println("How much money do you want to play with? (Minimum buy-in is $100, and the max is $1M)");
        userInput = in.nextLine();
        return Integer.valueOf(userInput);
    }

    public void start(){
        System.out.println("All right, " + name + ", welcome to the game! Here's your table.");
    }

    public boolean ante(int ante) {
        System.out.println("The ante is $" + ante);
        System.out.println("Ante up or quit game?  (Any key to ante up or Q to quit)");
        userInput = in.nextLine().toLowerCase();
        if (userInput.contains("q")) {
            return false;
        }
        return true;
    }

    public void deal() {
        System.out.println("Thanks! Here we go!");
    }

    public int bet(){
        System.out.println("How much you want to bet?");
        userInput = in.nextLine();
        return Integer.valueOf(userInput);
    }
}
