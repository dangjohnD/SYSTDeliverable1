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

public class BlackjackGame {

    // the deck of cards we will use
    private Deck deckOfCards = new Deck();
    private Player dealer = new Dealer("DealerMan");
    private BlackjackPlayer player = null;
    // we will record the moves in the order they are played
    // this could be useful for future extensions
    private ArrayList<Move> moves = new ArrayList<>();
    // the hidden card held by the dealer at the beginning of the game
    private Card hiddenDealerCard = null;

    public static void main(String[] args) {
        BlackjackGame g = new BlackjackGame("John Dang"); // 
        g.play();
    }

    public BlackjackGame(String playerName) {
        player = new BlackjackPlayer(playerName);
    }

    public void play() {
        Scanner input = new Scanner(System.in);

        // the card flipped over given to player
        hiddenDealerCard = deckOfCards.removeOneCard();

        // give a card to each player
        giveNewCard(dealer);
        giveNewCard(player);

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

        // let the player play as long as he wants and we are not over
        while (player.canPlay() && wantToPlay() && !gameEnded()) {
            giveNewCard(player);

        }

        // if the player did not get over (and the game ended), let the dealer play
        if (!gameEnded()) {
            // first, turn the hidden card
            giveCard(dealer, hiddenDealerCard);
            // then play until either wins
            while (dealer.canPlay() && !gameEnded()) {
                giveNewCard(dealer);
            }
        }

        // show who won
        declareWinner(bet);
    }

    public void giveNewCard(Player p) {
        giveCard(p, deckOfCards.removeOneCard());
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

    public void giveCard(Player p, Card c) {
        Move move = new Move(p, c);
        moves.add(move);
        p.addCard(move.getCard());
        System.out.println(move.toString() + "   (" + p.getTotalPoints(p.getHand()) + ")");
    }

    public boolean gameEnded() {
        if (player.getTotalPoints(player.getHand()) >= 21) {
            return true;
        } else if (dealer.getTotalPoints(dealer.getHand()) >= 21) {
            return true;
        }
        return false;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
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
