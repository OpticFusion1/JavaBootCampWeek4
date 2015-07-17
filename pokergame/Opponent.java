package javabootcampweek4.pokergame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Abram on 7/8/2015.
 */
public class Opponent {

    Random rand = new Random();
    Hand hand = new Hand();
    private int numberOfOpponents;
    private String[] names = {"Ben", "Mike", "Chris", "Kim", "Reed", "Megha", "Abram", "Nife"};

    public int getNumberOfOpponents() {
        return numberOfOpponents;
    }

    public void setNumberOfOpponents(int numberOfOpponents) {
        this.numberOfOpponents = numberOfOpponents;
    }

    public ArrayList<Player> getOpponents(int numberOfOpponents, int userStack) {
        Set<Player> players = new HashSet<>();
        ArrayList<Player> opponents = new ArrayList<>();
        for ( ; players.size() < numberOfOpponents ; ) {
            Player player = new Player(names[rand.nextInt(8)], (int) (userStack * (rand.nextDouble() + .5)));
            if (players.add(player)) {
                opponents.add(player);
            }
        }
        return opponents;
    }

    public void showTable (ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + " -  $" + player.getStack());
        }
        System.out.println();
    }

    public void showTableAndUserCards(ArrayList<Player> opponents, Player user, int pot) {
        for (Player opponent : opponents) {
            System.out.println(opponent.getName() + " - $" + opponent.getStack());
        }
        System.out.println(user.getName() + " - $" + user.getStack() + "  Your hand:  " + hand.showHand(user));
        System.out.println("Pot: " + pot);
        System.out.println();
    }

    public void showTableAndAllCards (ArrayList<Player> table, int pot) {
        for (Player player : table) {
            System.out.println(player.getName() + " -  $" + player.getStack() +  "  Hand:  " + hand.showHand(player));
        }
        System.out.println("Pot: " + pot);
        System.out.println();
    }
}
