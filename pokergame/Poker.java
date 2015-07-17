package javabootcampweek4.pokergame;

import java.util.ArrayList;

/**
 * Created by Abram on 7/7/2015.
 */
public class Poker {

    public static void main(String[] args) {

        boolean continuePlaying;
        int remainingPlayers;
        Player user = new Player();
        Opponent opponent = new Opponent();
        UserPrompt userPrompt = new UserPrompt();
        Hand hand = new Hand();
        WinningHand win = new WinningHand();

        user.setName(userPrompt.begin());
        opponent.setNumberOfOpponents(userPrompt.setUpOpponents());
        user.setStack(userPrompt.setUpStack());
        ArrayList<Player> opponents = opponent.getOpponents(opponent.getNumberOfOpponents(), user.getStack());
        ArrayList<Player> table = new ArrayList<>(opponents);
        table.add(user);
        userPrompt.start();
        opponent.showTable(table);
        Betting betting = new Betting(table);
        betting.setAnte(user.getStack());
        continuePlaying = userPrompt.ante(betting.getAnte());

        while (continuePlaying) {
            remainingPlayers = opponent.getNumberOfOpponents();
            betting.ante();
            hand.dealCards(table);
            userPrompt.deal();
            opponent.showTableAndUserCards(opponents, user, betting.getPot());
            betting.takeBets(userPrompt.bet());
            betting.collectWinnings(win.findWinningHand(table, betting.getPot()));
            if(user.stack == 0) {
                System.out.println("You lose!");
                continuePlaying = false;
            }
            for(int i = 0; i < remainingPlayers; i++) {
                if (table.get(i).getStack() == 0) {
                    table.remove(table.get(i));
                }
            }
            opponent.showTable(table);
            if (continuePlaying) {
                continuePlaying = userPrompt.ante(betting.getAnte());
            }
        }

        System.out.println("Bye!");

    }

}
