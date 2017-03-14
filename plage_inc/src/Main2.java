import java.util.Scanner;

import game.DiseaseCardGame;
import game.GameTable;
import player.Player;
import utility.CardComparator;
import utility.Logger;

public class Main2 {

	static InitWindow GUIstarter = new InitWindow();
	
	static Logger logger = new Logger();
	static DiseaseCardGame game = new DiseaseCardGame();
	static Player[] players = game.getTable().getPlayers();
	static GameTable table = game.getTable();
	static CardComparator cComp = new CardComparator();

	public static void main(String[] args) {
		GUIstarter.open();
	}
	
	public static void continues(){
		GUIstarter.close();
		game.initializePlayers(logger);
		setUpplayerNames(game, logger);
		game.setStartingPlayer(logger);
		GameWindow GUIGame = new GameWindow();
		
		GUIGame.setTable(game.getTable());
		GUIGame.open();		
	}
	
	public static void playGame(DiseaseCardGame game, Logger logger, GameTable table, CardComparator cc, String stat) {
		
		Player winner = null;
		Player currentPlayer = table.getCurrentPlayer();
		Player otherPlayer = table.getOtherPlayer();

		logger.print("Jelenlegi játékos: " + currentPlayer.getName());
		logger.print(currentPlayer.getHand().getTopCard().toString());
		winner = cc.compare(currentPlayer, otherPlayer, stat);
		logger.print(otherPlayer.getName() + ":");
		logger.print(otherPlayer.getHand().getTopCard().toString());
		logger.print("A kör nyertesese: " + winner.getName());

		System.out.println(currentPlayer.getName() + ": " + currentPlayer.getHand().getSize());
		System.out.println(otherPlayer.getName() + ": " + otherPlayer.getHand().getSize());

		if (winner.equals(currentPlayer)) {
			currentPlayer.getHand().putFirstCardToBack();
			currentPlayer.getHand().addCard(otherPlayer.getHand().getTopCard());
			otherPlayer.getHand().removeCard(otherPlayer.getHand().getTopCard());
		} else {
			otherPlayer.getHand().putFirstCardToBack();
			otherPlayer.getHand().addCard(currentPlayer.getHand().getTopCard());
			currentPlayer.getHand().removeCard(currentPlayer.getHand().getTopCard());
			table.setCurrentPlayer(otherPlayer);
		}

		System.out.println(currentPlayer.getName() + ": " + currentPlayer.getHand().getSize());
		System.out.println(otherPlayer.getName() + ": " + otherPlayer.getHand().getSize());

	}

	public static void setUpplayerNames(DiseaseCardGame game, Logger logger){
		Player[] players = game.getTable().getPlayers();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < players.length; i++) {
			players[i].setName(GUIstarter.getPlayers()[i]);
		}
	}

}
