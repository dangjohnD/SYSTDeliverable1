/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author okami
 */
public class Move {
    // a move is done by the dealer or the player.

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
        return person.getClass().getSimpleName() + " " + person.toString() + " take Card " + card.toString() + " worth " + card.getPoints() + " points";
    }
}
