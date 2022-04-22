/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * Date: 2022-04-16 Authors: Suhjin Min 
 * John Dang 
 * Oldri Kecaj 
 * Qiong Liao
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

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }
    
}
