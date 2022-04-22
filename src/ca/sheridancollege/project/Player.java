/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.*;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Suhjin Min Feb 17 2022 Date: 2022-04-16
 *  * Date: 2022-04-16 
 * Authors: Suhjin Min 
 * John Dang 
 * Oldri Kecaj 
 * Qiong Liao
 */
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

    public boolean wantToPlay() {
        return true;
    }

    public static int getTotalPoints(ArrayList<Card> hand) {
        int max = 0;
        int min = 0;
        for (Card c : hand) {
            int points = c.getPoints();
            min += points;
            if (c.getPoint() == Card.Point.C_ACE_1) {
                max += 11;
            } else {
                max += points;
            }
        }
        if (max > 21) {
            return min;
        } else {
            return max;
        }
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public String toString() {
        return name;
    }
}
