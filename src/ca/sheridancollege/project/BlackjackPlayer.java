package ca.sheridancollege.project;

public class BlackjackPlayer extends Player {
    private int bank = 1000;

    public BlackjackPlayer(String name) {
        super(name);
    }

    @Override
    boolean canPlay() {
        return getTotalPoints(this.getHand()) < 21;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }
    
}
