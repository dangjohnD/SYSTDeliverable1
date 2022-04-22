package ca.sheridancollege.project;

/**
 * Date: 2022-04-16 Authors: 
 * Suhjin Min 
 * John Dang 
 * Oldri Kecaj 
 * Qiong Liao
 */
public class Card {

    public enum Suit {
        CLOVERS, DIAMONDS, SPADES, HEARTS
    }

    public enum Point {
        C_ACE_1(1), C_2(2), C_3(3), C_4(4), C_5(5), C_6(6),
        C_7(7), C_8(8), C_9(9), C_10(10), C_JACK(10), C_QUEEN(10), C_KING(10);
        
        private int value;
        
        private Point(final int value){
            this.value=value;
        }
        
        public int getValue(){
            return value;
        }
    }

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
        return point.getValue();
    }

    public String toString() {
        return point.name() + " of " + suit.name();
    }
}
