/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author okami
 */
import java.util.*;
public class Deck {

    List<Card> cards = new ArrayList<>();

    public Deck() {
        createDeck();
        shuffle();
    }

    public void createDeck() {
        // create a deck by inserting one card of each Point for each Suit
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
        // take the last card off the deck (the top one)
        if (cards.size() == 0) {
            throw new RuntimeException("No more cards");
        }
        Card card = cards.remove(cards.size() - 1);
        return card;
    }
}

