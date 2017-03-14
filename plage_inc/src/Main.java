import java.util.Scanner;

import game.DiseaseCardGame;
import game.GameTable;
import player.Player;
import utility.CardComparator;
import utility.Logger;

public class Main {

	public static void main(String[] args) {
		Logger logger = new Logger();
		DiseaseCardGame game = new DiseaseCardGame();
		Player[] players = game.getTable().getPlayers();
		GameTable table = game.getTable();
		CardComparator cComp = new CardComparator();

		logger.clearScreen();
		game.initializePlayers(logger);
		setUpplayerNames(game, logger);
		game.setStartingPlayer(logger);
		game.printDealer(logger);

		while (players[0].getHand().getSize() != 0 || players[1].getHand().getSize() != 0) {
			if (players[0].getHand().getSize() == 0) {
				logger.print("\n" + players[0].getName() + " vesztett! ");
				break;
			} else if (players[1].getHand().getSize() == 0) {
				logger.print("\n" + players[1].getName() + " vesztett!");
				break;
			} else {
				playGame(game, logger, table, cComp);
			}
		}

	}

	public static void setUpplayerNames(DiseaseCardGame game, Logger logger) {
		Player[] players = game.getTable().getPlayers();
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < players.length; i++) {
			game.setPlayerName(players[i], i, logger, sc);
		}
	}

	public static void playGame(DiseaseCardGame game, Logger logger, GameTable table, CardComparator cc) {
		Player winner = null;
		Player currentPlayer = table.getCurrentPlayer();
		Player otherPlayer = table.getOtherPlayer();

		logger.print("\nJelenlegi játékos: " + currentPlayer.getName() +
				" (" + currentPlayer.getHand().getSize() + ")");
		logger.print(currentPlayer.getHand().getTopCard().toString());
		winner = cc.compare(currentPlayer, otherPlayer);

		logger.print(otherPlayer.getName() + ":");
		logger.print(otherPlayer.getHand().getTopCard().toString());
		logger.print("A kör nyertesese: " + winner.getName(), true);

		logger.print("A választott szempont: " + currentPlayer.getChoosedStat());
		logger.print(currentPlayer.getName() + " kártyája : " + currentPlayer.getHand().getTopCard().toString());
		logger.print(otherPlayer.getName() + " kártyája: " + otherPlayer.getHand().getTopCard().toString());

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

	}

}
