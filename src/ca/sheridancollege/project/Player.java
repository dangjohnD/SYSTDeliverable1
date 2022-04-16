/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.*;
=======
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Suhjin Min Feb 17 2022
 */
public abstract class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<>();

    abstract boolean canPlay();

    abstract boolean wantToPlay();

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

    public static int getTotalPoints(ArrayList<Card> hand) {
        // count the points in two ways and select the best for the player 
        int minTotal = 0; // with C_ACE worth 1 point
        int maxTotal = 0; // with C_ACE worth 11 point
        for (Card c : hand) {
            int points = c.getPoints();
            minTotal += points;
            // this would be the count with ACE counting for 11 points
            maxTotal += (c.getPoint() == Card.Point.C_ACE_1) ? 11 : points;
        }
        // return the most favorable outcome. If considering C_ACE is worth 11 points pushes the 
        // total count beyond 21, return the count where it is worth 1 instead.
        return (maxTotal > 21) ? minTotal : maxTotal;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public String toString() {
        return name;
    }
}
