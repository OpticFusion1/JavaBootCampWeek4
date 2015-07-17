package javabootcampweek4.pokergame;

import java.util.ArrayList;

/**
 * Created by Abram on 7/8/2015.
 */
public class Betting {

    ArrayList<Player> table = new ArrayList<>();
    int ante;
    int pot = 0;

    public Betting() {

    }

    public Betting(ArrayList<Player> table) {
        this.table = table;
    }

    public int getAnte() {
        return ante;
    }

    public void setAnte(int ante) {
        this.ante = ante/100;
    }

    public int getPot() {
        return pot;
    }

    public void ante() {
        for(Player player : table) {
            if (player.stack < ante){
                pot += player.stack;
                player.stack = 0;
            } else {
                player.stack -= ante;
                pot += ante;
            }
        }
    }

    public void takeBets(int bet){
        for(Player player : table) {
            if (player.stack < bet){
                pot += player.stack;
                player.stack = 0;
            } else {
                player.stack -= bet;
                pot += bet;
            }
        }
    }

    public void collectWinnings(Player player) {
        player.stack += pot;
        pot = 0;
    }

}
