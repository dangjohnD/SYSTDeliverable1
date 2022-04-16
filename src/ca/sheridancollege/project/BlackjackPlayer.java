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
public class BlackjackPlayer extends Player {
    private int bank = 1000;

    public BlackjackPlayer(String name) {
        super(name);
    }

    @Override
    boolean canPlay() {
        return getTotalPoints(this.getHand()) < 21;
    }

    @Override
    boolean wantToPlay() {
        // here is where the player's strategy could be elaborated. The simple strategy
        // is to keep playing as long as the count is lower than 17.
        return getTotalPoints(this.getHand()) < 17;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }
    
}
