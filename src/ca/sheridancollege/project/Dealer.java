package ca.sheridancollege.project;

public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    // Dealer has no strategy, will always play
    @Override
    public boolean wantToPlay() {
        return true;
    }

    @Override
    public boolean canPlay() {
        return getTotalPoints(this.getHand()) < 21;
    }
}
