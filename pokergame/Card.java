package javabootcampweek4.pokergame;

/**
 * Created by Abram on 7/7/2015.
 */
public class Card {

    private int value;
    private char suit;

    public Card (int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public String showCard () {
        String card = "";
        if (value < 10) {
            card = Integer.toString(value) + Character.toString(suit);
        }
        switch (value) {
            case 10:
                card = "T" + Character.toString(suit);
                break;
            case 11:
                card = "J" + Character.toString(suit);
                break;
            case 12:
                card = "Q" + Character.toString(suit);
                break;
            case 13:
                card = "K" + Character.toString(suit);
                break;
            case 14:
                card = "A" + Character.toString(suit);
                break;
        }
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (value != card.value) return false;
        return suit == card.suit;

    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (int) suit;
        return result;
    }
}
