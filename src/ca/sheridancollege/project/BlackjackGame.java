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

public class BlackjackGame {

    // Deck of cards
    private Deck deckOfCards = new Deck();
    private Player dealer = new Dealer("DealerMan");
    private BlackjackPlayer player = null;

    // Record moves 
    private ArrayList<Move> moves = new ArrayList<>();

    // Hidden card for dealer
    private Card hiddenDealerCard = null;

    //Main method
    public static void main(String[] args) {
        BlackjackGame g = new BlackjackGame("John Dang"); // 
        g.play();
    }

    //Create blackjack player
    public BlackjackGame(String playerName) {
        player = new BlackjackPlayer(playerName);
    }

    //Play method
    public void play() {
        Scanner input = new Scanner(System.in);

        //Flipped card given to player
        hiddenDealerCard = deckOfCards.removeOneCard();

        // Give card to each player
        giveNewCard(dealer);
        giveNewCard(player);

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
            // first, turn the hidden card
            giveCard(dealer, hiddenDealerCard);
            // then play until either wins
            while (dealer.canPlay() && !gameEnded()) {
                giveNewCard(dealer);
            }
        }

        // Display winner
        declareWinner(bet);
    }

    //Provide new card
    public void giveNewCard(Player p) {
        giveCard(p, deckOfCards.removeOneCard());
    }

    //Ask player if they want to play
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

    //Give player card for move
    public void giveCard(Player p, Card c) {
        Move move = new Move(p, c);
        moves.add(move);
        p.addCard(move.getCard());
        System.out.println(move.toString() + "   (" + Player.getTotalPoints(p.getHand()) + ")");
    }

    //Game ending functionality
    public boolean gameEnded() {
        if (Player.getTotalPoints(player.getHand()) >= 21) {
            return true;
        } else if (Player.getTotalPoints(dealer.getHand()) >= 21) {
            return true;
        }
        return false;
    }

    //Return player
    public Player getPlayer() {
        return player;
    }

    //Return dealer
    public Player getDealer() {
        return dealer;
    }

    //Check current bet
    public int checkBet(double bet) {
        if (bet < player.getBank()) {
            return 1;
        } else if (bet > player.getBank()) {
            return 2;
        } else {
            return 3;
        }
    }

    //Declare winneer of game
    public int declareWinner(double bet) {
        if (Player.getTotalPoints(player.getHand()) >= 21) {
            System.out.println(player.getName() + " has lost... " + Player.getTotalPoints(player.getHand()) + " > 21");
            System.out.println("You lost $" + bet);
            System.out.println("Your bank total is now $" + (1000 - bet));
            return 1;
        } else if (Player.getTotalPoints(dealer.getHand()) >= 21) {
            System.out.println(dealer.getName() + " has lost... " + Player.getTotalPoints(dealer.getHand()) + " > 21");
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
