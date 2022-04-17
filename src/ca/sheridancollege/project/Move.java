package ca.sheridancollege.project;

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
        return "Move: " + person.getClass().getSimpleName() + " " + 
        person.toString() + " take Card " + card.toString() + " for " + card.getPoints() + " points";
    }
}
