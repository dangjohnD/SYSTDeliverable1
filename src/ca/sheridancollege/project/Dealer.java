package ca.sheridancollege.project;

/**
 *
 * Date: 2022-04-16 Authors: Suhjin Min
 * John Dang
 * Oldri Kecaj
 * Qiong Liao
 */
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
