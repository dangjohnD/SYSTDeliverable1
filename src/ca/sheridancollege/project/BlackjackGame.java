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

public class BlackjackGame extends Game {

    // initalize our variables player, dealer,deck and moves
    private Player dealer = new Dealer("Dealer Kyle");
    private Card dealerFlippedCard = null;
    private BlackjackPlayer player = null;
    private Deck deckOfCards = new Deck();
    private ArrayList<Move> moves = new ArrayList<>();

    public BlackjackGame(String playerName) {
        player = new BlackjackPlayer(playerName);
    }

    public static void main(String[] args) {
        BlackjackGame g = new BlackjackGame("John Dang"); // 
        g.play();
    }

    public void play() {
        Scanner input = new Scanner(System.in);

        dealerFlippedCard = deckOfCards.removeOneCard();

        giveNewCard(dealer);
        giveNewCard(player);

        // get the players bet
        double bet = 0;
        boolean validBet = false;
        do {
            System.out.println("How much do you want to bet?");
            System.out.println("You have" + player.getBank());
            bet = input.nextDouble();
            switch (checkBet(bet)) {
                case 1:
                    System.out.println("Bet is under bank total");
                    validBet = true;
                    break;
                case 2:
                    System.out.println("Bet is over bank total");
                    break;
                default:
                    System.out.println("Bet is exactly bank total");
                    validBet = true;
            }
        } while (!validBet);

        // ask the player if they want to hit or stand and check their total
        while (player.canPlay() && wantToPlay() && !gameEnded()) {
            giveNewCard(player);

        }

        // let the dealer play if player did not go over 21
        if (!gameEnded()) {
            giveCard(dealer, dealerFlippedCard);
            while (dealer.canPlay() && !gameEnded()) {
                giveNewCard(dealer);
            }
        }

        declareWinner(bet);
    }

    public boolean wantToPlay() {
        Scanner input = new Scanner(System.in);
        System.out.println("do you want to hit or stand(h or s)");

        String playerInput = input.next();

        boolean wantToPlay = false;
        if (playerInput.equals("h")) {
            wantToPlay = true;
        } else {
            wantToPlay = false;
        }
        return wantToPlay;
    }

    public void giveNewCard(Player p) {
        giveCard(p, deckOfCards.removeOneCard());
    }

    public void giveCard(Player p, Card c) {
        Move move = new Move(p, c);
        moves.add(move);
        p.addCard(move.getCard());
        System.out.println(move.toString() + "-Hand is worth[" + p.getTotalPoints(p.getHand()) + "]");
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    public boolean gameEnded() {
        if (player.getTotalPoints(player.getHand()) >= 21) {
            return true;
        } else if (dealer.getTotalPoints(dealer.getHand()) >= 21) {
            return true;
        }
        return false;
    }

    public int checkBet(double bet) {
        if (bet < player.getBank()) {
            return 1;
        } else if (bet > player.getBank()) {
            return 2;
        } else {
            return 3;
        }
    }

    public int declareWinner(double bet) {
        if (player.getTotalPoints(player.getHand()) >= 21) {
            System.out.println(player.getName() + " has lost... " + player.getTotalPoints(player.getHand()) + " > 21");
            System.out.println("You lost $" + bet);
            System.out.println("Your bank total is now $" + (1000 - bet));
            return 1;
        } else if (dealer.getTotalPoints(dealer.getHand()) >= 21) {
            System.out.println(dealer.getName() + " has lost... " + dealer.getTotalPoints(dealer.getHand()) + " > 21");
            return 1;
        } else {
            Player winner = (player.getTotalPoints(player.getHand()) > dealer.getTotalPoints(dealer.getHand())) ? player : dealer;
            System.out.println(winner.getName() + " wins... " + winner.getTotalPoints(winner.getHand()));
            if (winner == player) {
                return 1;
            } else {
                return 2;
            }
        }

    }
}
