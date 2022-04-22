package ca.sheridancollege.project;
/**
 *
 * Date: 2022-04-16 Authors: Suhjin Min 
 * John Dang 
 * Oldri Kecaj 
 * Qiong Liao
 */
public class Move {

    private Player person;
    private Card card;

    public Move(Player p, Card c) {
        this.person = p;
        this.card = c;
    }

    public Player getPerson() {
        return person;
    }

    public Card getCard() {
        return card;
    }

    public String toString() {
        return person.getClass().getSimpleName() + " " + person.toString()
                + " take Card " + card.toString() + " worth " + card.getPoints() + " points";
    }
}
