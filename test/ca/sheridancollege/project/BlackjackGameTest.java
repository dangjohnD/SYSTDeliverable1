/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author okami
 */
public class BlackjackGameTest {

    public BlackjackGameTest() {
    }

    /**
     * Test of giveCard method, of class BlackjackGame.
     */
    @Test
    public void testGiveCardGood() {
        //test givecard when card results in hand under 21
        System.out.println("giveCard");
        Card c = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        BlackjackGame instance = new BlackjackGame("Tester");
        instance.giveCard(instance.getPlayer(), c);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(c);
        assertEquals(instance.getPlayer().getHand(), cards);
    }

    @Test
    public void testGiveCardBad() {
        //test givecard when card results in hand over 21
        System.out.println("giveCard");
        Card c = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        Card c2 = new Card(Card.Suit.CLUBS, Card.Point.C_QUEEN);
        Card c3 = new Card(Card.Suit.CLUBS, Card.Point.C_7);
        BlackjackGame instance = new BlackjackGame("Tester");
        instance.giveCard(instance.getPlayer(), c);
        instance.giveCard(instance.getPlayer(), c2);
        instance.giveCard(instance.getPlayer(), c3);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(c);
        cards.add(c2);
        cards.add(c3);
        assertEquals(instance.getPlayer().getHand(), cards);
    }

    @Test
    public void testGiveCardBoundary() {
        //test givecard when card results in hand exactly 21
        System.out.println("giveCard");
        Card c = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        Card c2 = new Card(Card.Suit.CLUBS, Card.Point.C_ACE_1);
        BlackjackGame instance = new BlackjackGame("Tester");
        instance.giveCard(instance.getPlayer(), c);
        instance.giveCard(instance.getPlayer(), c2);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(c);
        cards.add(c2);
        assertEquals(instance.getPlayer().getHand(), cards);
    }

    /**
     * Test of DeclareWinner method, of class BlackjackGame.
     */
    @Test
    public void testDeclareWinnerBad() {
        // Player hand is worth less than dealer
        System.out.println("DeclareWinner");
        Card c = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        Card c2 = new Card(Card.Suit.CLUBS, Card.Point.C_9);
        double bet = 100;
        BlackjackGame instance = new BlackjackGame("Tester");
        instance.giveCard(instance.getDealer(), c);
        instance.giveCard(instance.getPlayer(), c2);
        int result = instance.declareWinner(bet);
        int resExpected = 2;
        assertEquals(result, resExpected);
    }

    @Test
    public void testDeclareWinnerGood() {
        // Player hand is worth more than dealer
        System.out.println("DeclareWinner");
        Card c = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        Card c2 = new Card(Card.Suit.CLUBS, Card.Point.C_9);
        double bet = 100;
        BlackjackGame instance = new BlackjackGame("Tester");
        instance.giveCard(instance.getDealer(), c2);
        instance.giveCard(instance.getPlayer(), c);
        int result = instance.declareWinner(bet);
        int resExpected = 1;
        assertEquals(result, resExpected);
    }
 
    @Test
    public void testDeclareWinnerBoundary() {
        // Player hand is worth the same as dealer, house always wins
        System.out.println("DeclareWinner");
        Card c = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        Card c2 = new Card(Card.Suit.HEARTS, Card.Point.C_10);
        double bet = 100;
        BlackjackGame instance = new BlackjackGame("Tester");
        instance.giveCard(instance.getDealer(), c2);
        instance.giveCard(instance.getPlayer(), c);
        int result = instance.declareWinner(bet);
        int resExpected = 2;
        assertEquals(result, resExpected);
    }
    
    @Test
    public void testCheckBetGood(){
        System.out.println("testCheckBet");
        BlackjackGame instance = new BlackjackGame("Player");
        double bet = 900;
        int result = instance.checkBet(bet);
        int resExpected = 1;
        assertEquals(result, resExpected);
    }

    @Test
    public void testCheckBetBad(){
        System.out.println("testCheckBet");
        BlackjackGame instance = new BlackjackGame("Player");
        double bet = 9100;
        int result = instance.checkBet(bet);
        int resExpected = 2;
        assertEquals(result, resExpected);
    }

    @Test
    public void testCheckBetBoundary(){
        System.out.println("testCheckBet");
        BlackjackGame instance = new BlackjackGame("Player");
        double bet = 1000;
        int result = instance.checkBet(bet);
        int resExpected = 3;
        assertEquals(result, resExpected);
    }

    @Test
    public void testGameEndedGood(){
        System.out.println("testGameEnded");
        BlackjackGame instance = new BlackjackGame("Test Player");
        boolean result = instance.gameEnded();
        boolean resExpected = false;
        assertEquals(result, resExpected);
    }

    @Test
    public void testGameEndedBad(){
        System.out.println("testGameEnded");
        BlackjackGame instance = new BlackjackGame("Test Player");
        Card c1 = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        Card c2 = new Card(Card.Suit.CLUBS, Card.Point.C_9);
        Card c3 = new Card(Card.Suit.CLUBS, Card.Point.C_8);
        instance.giveCard(instance.getPlayer(), c1);
        instance.giveCard(instance.getPlayer(), c2);
        instance.giveCard(instance.getPlayer(), c3);
        boolean result = instance.gameEnded();
        boolean resExpected = true;
        assertEquals(result, resExpected);
    }

    @Test
    public void testGameEndedBoundary(){
        System.out.println("testGameEnded");
        BlackjackGame instance = new BlackjackGame("Test Player");
        Card c1 = new Card(Card.Suit.CLUBS, Card.Point.C_10);
        Card c2 = new Card(Card.Suit.CLUBS, Card.Point.C_ACE_1);
        instance.giveCard(instance.getPlayer(), c1);
        instance.giveCard(instance.getPlayer(), c2);
        boolean result = instance.gameEnded();
        boolean resExpected = true;
        assertEquals(result, resExpected);
    }

    @Test
    public void testWantToPlayGood(){
        System.out.println("testWantToPlay");
        BlackjackGame instance = new BlackjackGame("Test Player");
        String input = "h";
        boolean result = instance.wantToPlay(input);
        boolean resExpected = true;
        assertEquals(result, resExpected);
    }

    @Test
    public void testWantToPlayBad(){
        System.out.println("testWantToPlay");
        BlackjackGame instance = new BlackjackGame("Test Player");
        String input = "s";
        boolean result = instance.wantToPlay(input);
        boolean resExpected = false;
        assertEquals(result, resExpected);
    }
    
    @Test
    public void testWantToPlayBoundary(){
        System.out.println("testWantToPlay");
        BlackjackGame instance = new BlackjackGame("Test Player");
        String input = "efnwekj";
        boolean result = instance.wantToPlay(input);
        boolean resExpected = false;
        assertEquals(result, resExpected);
    }
}