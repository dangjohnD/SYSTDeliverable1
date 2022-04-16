/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author okami
 */
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
        // dealer will keep playing until either he beats the player or goes over.
        return true;
    }
}
