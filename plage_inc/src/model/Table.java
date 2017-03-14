package model;
import player.Player;

/**
 * Created by tamasferenc on 2017.02.28..
 */
public abstract class Table
{
    protected Player[] players;
    protected Deck baseDeck;
    protected Player currentPlayer;
    protected int rounds;

    public abstract void distributeCards();
    public abstract Player getCurrentPlayer();
    public abstract int getRounds();
    public abstract String toString();
}
