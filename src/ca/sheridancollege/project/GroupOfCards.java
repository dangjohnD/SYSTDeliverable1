package ca.sheridancollege.project;
import java.util.*;

public class GroupOfCards {

    private ArrayList<Card> cards;
    private int size;

    public GroupOfCards() {
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
