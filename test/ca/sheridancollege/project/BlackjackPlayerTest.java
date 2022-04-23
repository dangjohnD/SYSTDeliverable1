/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

/**
 *
 * @author okami
 */
public class BlackjackPlayerTest {
    
    public BlackjackPlayerTest() {
    }

    /**
     * Test of canPlay method, of class BlackjackPlayer.
     */
    @Test
    public void testGetTotalPointsBoundary() {
        System.out.println("getTotalPoints");
        ArrayList<Card> hand = new ArrayList<>();
        int result = BlackjackPlayer.getTotalPoints(hand);
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalPointsGood() {
        System.out.println("getTotalPoints");
        ArrayList<Card> hand = new ArrayList<>();
        Card card  = new Card(Card.Suit.CLUBS, Card.Point.C_2);
        hand.add(card);
        int result = BlackjackPlayer.getTotalPoints(hand);
        int expResult = 2;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalPointsBad() {
        System.out.println("getTotalPoints");
        ArrayList<Card> hand = new ArrayList<>();
        
        Card card1  = new Card(Card.Suit.CLUBS, Card.Point.C_KING);
        Card card2  = new Card(Card.Suit.CLUBS, Card.Point.C_QUEEN);
        Card card3 = new Card(Card.Suit.CLUBS, Card.Point.C_2);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        int result = BlackjackPlayer.getTotalPoints(hand);
        int expResult = 22;
        assertEquals(expResult, result);
    }

}
