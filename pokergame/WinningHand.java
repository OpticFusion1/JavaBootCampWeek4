package javabootcampweek4.pokergame;

import java.util.ArrayList;

/**
 * Created by Abram on 7/10/2015.
 */
public class WinningHand {

    Rank rank = new Rank();
    Opponent opponent = new Opponent();

    public Player findWinningHand (ArrayList<Player> table, int pot) {

        Player winner = new Player();
        int highestRank = 0;
        boolean tie = true;

        opponent.showTableAndAllCards(table, pot);

        for(Player player : table) {
            rank.sort(player.getHand());
            if(rank.rank(player.getHand()) > highestRank) {
                winner = player;
                highestRank = rank.rank(player.getHand());
            } else if (rank.rank(player.getHand()) == highestRank) {
                for (int i = 0; i < 5; i++) {
                    if (player.getHand().get(i).getValue() != winner.getHand().get(i).getValue()) {
                        if (player.getHand().get(i).getValue() > winner.getHand().get(i).getValue()) {
                            winner = player;
                        }
                        tie = false;
                        break;
                    }
                }
                if (tie) {
                    System.out.println("Chop it up!");
                }

            }
        }

        System.out.println(winner.getName() + " wins the pot!");
        return winner;
    }

}
