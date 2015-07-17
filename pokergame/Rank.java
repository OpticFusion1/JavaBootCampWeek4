package javabootcampweek4.pokergame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Abram on 7/9/2015.
 */
public class Rank {

    public ArrayList<Card> sort(ArrayList<Card> hand) {
        Collections.sort(hand, new ValueComparator());
        return hand;
    }

    private boolean flush(ArrayList<Card> hand) {
        char suit = hand.get(0).getSuit();
        for(Card card : hand) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    private boolean straight(ArrayList<Card> hand) {
        int length = hand.size();
        if(hand.get(0).getValue() == 14 && hand.get(1).getValue() == 5) {
            for (int i = 1; i < length - 1; i++) {
                if (hand.get(i).getValue() - 1 != hand.get(i + 1).getValue()) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < length - 1; i++) {
            if (hand.get(i).getValue() - 1 != hand.get(i + 1).getValue()) {
                return false;
            }
        }
        return true;
    }

    public int rank(ArrayList<Card> hand) {
        int rank;
        if (flush(hand) && straight(hand)) {
            if (hand.get(0).getValue() == 14) {
                rank = 10;
            } else {
                rank = 9;
            }
        } else if (flush(hand)) {
            rank = 6;
        } else if (straight(hand)) {
            rank = 5;
        } else {
            rank = match(hand);
        }
        return rank;
    }

    private int match(ArrayList<Card> hand) {
        int rank = 0, same = 0;
        int length = hand.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && hand.get(i).getValue() == hand.get(j).getValue()) {
                    ++same;
                }
            }
        }

        switch (same) {
            case 0:
                rank = 1;
                break;
            case 2:
                rank = 2;
                sortPairs(hand);
                break;
            case 4:
                rank = 3;
                sortPairs(hand);
                break;
            case 6:
                rank = 4;
                sortTrips(hand);
                break;
            case 8:
                rank = 7;
                sortTrips(hand);
                break;
            case 12:
                rank = 8;
                sortQuads(hand);
                break;
        }
        return rank;
    }

    private void sortPairs(ArrayList<Card> hand) {
        int length = hand.size();
        for (int i = 0; i < length - 1; i++) {
            if (hand.get(i).getValue() == hand.get(i + 1).getValue()) {
                hand.get(i).setValue(hand.get(i).getValue() + 20);
                hand.get(i + 1).setValue(hand.get(i + 1).getValue() + 20);
            }
        }
        sort(hand);
    }

    private void sortTrips(ArrayList<Card> hand) {
        int length = hand.size();
        for (int i = 1; i < length - 1; i++) {
            if (hand.get(i).getValue() == hand.get(i).getValue() && hand.get(i).getValue() == hand.get(i).getValue()) {
                hand.get(i).setValue(hand.get(i).getValue() + 20);
                hand.get(i).setValue(hand.get(i).getValue() + 20);
                hand.get(i).setValue(hand.get(i).getValue() + 20);
            }
        }
        sort(hand);
    }

    private void sortQuads(ArrayList<Card> hand) {
        if (hand.get(0).getValue() != hand.get(1).getValue()) {
            for(int i = 1; i < 4; i++) {
                hand.get(i).setValue(hand.get(i).getValue() + 20);
            }
        }
        sort(hand);
    }

}