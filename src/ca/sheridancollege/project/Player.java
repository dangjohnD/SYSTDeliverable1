package ca.sheridancollege.project;
import java.util.*;

public abstract class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<>();



    public Player(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    abstract boolean canPlay();

    public boolean wantToPlay(){
        return true;
    }
 
    public static int getTotalPoints(ArrayList<Card> hand) {
        int minTotal = 0; 
        int maxTotal = 0; 
        for (Card c : hand) {
            int points = c.getPoints();
            minTotal += points;
            maxTotal += (c.getPoint() == Card.Point.C_ACE_1) ? 11 : points;
        }

        return (maxTotal > 21) ? minTotal : maxTotal;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public String toString() {
        return name;
    }
}
