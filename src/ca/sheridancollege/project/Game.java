package ca.sheridancollege.project;

public abstract class Game {

    private final String name = null;
    private Player player; 

    public Game() {}

    public String getName() { return name; }

    public abstract void play();

    public abstract void declareWinner();

}
