/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 *Date 2022-02-17 -Qiong
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @author Suhjin_Min
 */
public  class Card {
    //default modifier for child classes

    public enum Suit {
        CLOVERS, DIAMONDS, SPADES, HEARTS
    }

    public enum Point {
        C_ACE_1, C_2, C_3, C_4, C_5, C_6, C_7, C_8, C_9, C_10, C_JACK, C_QUEEN, C_KING
    }
    public static final int FIRST_SUIT_ORDINAL = 10;

    private Suit suit;
    private Point point;

    public Card(Suit s, Point p) {
        this.point = p;
        this.suit = s;
    }

    public Suit getSuit() {
        return suit;
    }

    public Point getPoint() {
        return point;
    }

    public int getPoints() {
        if (getPoint().ordinal() <= Point.C_10.ordinal()) {
            return getPoint().ordinal() + 1;
        } else {
            // value of face cards
            return 10;		
        }
    }

    public String toString() {
        return point.name() + " of " + suit.name();
    }
}
//added comment for test - Oldri
//add comment -Qiong
