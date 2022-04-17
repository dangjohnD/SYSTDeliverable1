package ca.sheridancollege.project;

public class Dealer extends Player {

    public Dealer(String name) {
        super(name);
    }

    @Override
    public boolean canPlay() {
        return getTotalPoints(this.getHand()) < 21;
    }

    @Override
    public boolean wantToPlay() {
        return true;
    }
}
