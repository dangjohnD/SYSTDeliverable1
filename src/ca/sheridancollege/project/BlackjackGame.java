package ca.sheridancollege.project;
import java.util.*;
/*

Date: 
2022-04-16

Authors:
Suhjin Min
John Dang
Oldri Kecaj
Qiong Liao
 */

public class BlackjackGame extends Game {

    // Intialize variables
    private final Player dealer = new Dealer("Dealer Kyle");
    // Hidden card for dealer
    private Card dealerFlippedCard = null;
    private BlackjackPlayer player = null;
    private final Deck deck;
    // Record moves
    private final ArrayList<Move> moves = new ArrayList<>();

    // Create a player in the constructor
    public BlackjackGame(String playerName) {
        this.deck = new Deck();
        player = new BlackjackPlayer(playerName);
    }

    //Main method
    public static void main(String[] args) {
        BlackjackGame g = new BlackjackGame("John Dang"); // 
        g.play();
    }

    // Play Method
    public void play() {
        Scanner input = new Scanner(System.in);

        dealerFlippedCard = deck.removeOneCard();

        giveNewCard(dealer);
        giveNewCard(player);

        // Betting functionality
        double bet = 0;
        boolean validBet = false;

        //Betting functionality
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

        // Game validation for player to continue to play and not having points over
        while (player.canPlay() && wantToPlay() && !gameEnded()) {
            giveNewCard(player);

        }

        // Validation for dealer to play if game has not ended
        if (!gameEnded()) {
            giveCard(dealer, dealerFlippedCard);
            while (dealer.canPlay() && !gameEnded()) {
                giveNewCard(dealer);
            }
        }

        //Display winner
        declareWinner(bet);
    }

    // Ask player if they want to play
    public boolean wantToPlay() {
        Scanner input = new Scanner(System.in);
        System.out.println("do you want to hit or stand(h or s)");

        String playerInput = input.next();

        boolean wantToPlay = false;
        wantToPlay = playerInput.equals("h");
        return wantToPlay;
    }

    //Give player card for move
    public void giveNewCard(Player p) {
        giveCard(p, deck.removeOneCard());
    }

    public void giveCard(Player p, Card c) {
        Move move = new Move(p, c);
        moves.add(move);
        p.addCard(move.getCard());
        System.out.println(move.toString() + "-Hand is worth["
                + Player.getTotalPoints(p.getHand()) + "]");
    }

    // Return player
    public Player getPlayer() {
        return player;
    }

    // Return dealer
    public Player getDealer() {
        return dealer;
    }

    //Game ending functionality
    public boolean gameEnded() {
        if (BlackjackPlayer.getTotalPoints(player.getHand()) >= 21) {
            return true;
        } else if (Player.getTotalPoints(dealer.getHand()) >= 21) {
            return true;
        }
        return false;
    }

    // Check the current bet
    public int checkBet(double bet) {
        if (bet < player.getBank()) {
            return 1;
        } else if (bet > player.getBank()) {
            return 2;
        } else {
            return 3;
        }
    }

    // Declare winner of game
    @Override
    public int declareWinner(double bet) {
        if (BlackjackPlayer.getTotalPoints(player.getHand()) >= 21) {
            System.out.println(player.getName() + " has lost... " 
                    + BlackjackPlayer.getTotalPoints(player.getHand()) 
                    + " > 21");
            System.out.println("You lost $" + bet);
            System.out.println("Your bank total is now $" + (1000 - bet));
            return 1;
        } else if (Player.getTotalPoints(dealer.getHand()) >= 21) {
            System.out.println(dealer.getName() + " has lost... " 
                    + Player.getTotalPoints(dealer.getHand()) + " > 21");
            return 1;
        } else {
            Player winner = (Player.getTotalPoints(player.getHand()) > Player.getTotalPoints(dealer.getHand())) ? player : dealer;
            System.out.println(winner.getName() + " wins... " + Player.getTotalPoints(winner.getHand()));
            if (winner == player) {
                return 1;
            } else {
                return 2;
            }
        }

    }
}
