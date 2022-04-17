package ca.sheridancollege.project;
import java.util.*;

public class Deck {

    List<Card> cards = new ArrayList<>();

    public Deck() {
        createDeck();
        shuffle();
    }

    public void createDeck() {
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.Point p : Card.Point.values()) {
                cards.add(new Card(s, p));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card removeOneCard() {
        if (cards.size() == 0) {
            throw new RuntimeException("No more cards");
        }
        Card card = cards.remove(cards.size() - 1);
        return card;
    }
}

