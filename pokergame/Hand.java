package javabootcampweek4.pokergame;

import java.util.*;

/**
 * Created by Abram on 7/7/2015.
 */
public class Hand {

    private Random rand = new Random();
    private String suits = "SHCD";

    private ArrayList<Card> hand = new ArrayList<>();
    private Set<Card> allCards = new HashSet<>();

    public void dealCards (ArrayList<Player> table) {
        int counter = 0;
        allCards.clear();
        for (; allCards.size() < 5 * table.size();){
            Card card = new Card(rand.nextInt(13) + 2, suits.charAt(rand.nextInt(4)));
            if (allCards.add(card)) {
                hand.add(card);
            }
            if (hand.size() == 5) {
                table.get(counter++).setHand(hand);
                hand = new ArrayList<>();
            }
        }
    }

    public String showHand (Player player) {
        String cards = "";
        for (Card card : player.getHand()){
            cards = cards + card.showCard() + " ";
        }
        return cards;
    }

    public String allCards () {
        String cards = "";
        for (Card card : allCards){
            cards = cards + card.showCard() + " ";
        }
        return cards;
    }

    public String handArray () {
        String cards = "";
        for (Card card : hand){
            cards = cards + card.showCard() + " ";
        }
        return cards;
    }

}
