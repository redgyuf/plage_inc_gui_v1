package game;

import java.util.Random;
import java.util.Scanner;

import player.Player;
import utility.Logger;

public class DiseaseCardGame {

	private GameTable gameTable;
	
	public DiseaseCardGame(){
		 gameTable = new GameTable();
	}

	public void initializePlayers(Logger logger) {
		logger.print("Játékosok létrehozása...");
		gameTable.distributeCards();
	}

	public void setPlayerName(Player p, int playerNum, Logger logger, Scanner sc) {
		logger.print("Add meg a(z) " + (playerNum + 1) + ". játékos nevét: ");
		p.setName(sc.nextLine());
	}

	public void printDealer(Logger logger) {

		Player[] players = gameTable.getPlayers();
		Player currentPlayer = gameTable.getCurrentPlayer();

		if (currentPlayer.equals(players[0])) {
			logger.print("Az osztó " + gameTable.getPlayers()[1].getName() + " lett.");
		} else {
			logger.print("Az osztó " + gameTable.getPlayers()[0].getName() + " lett.");
		}
	}
	
	public GameTable getTable(){
		return gameTable;
	}

	public void setStartingPlayer(Logger logger) {
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		int index = r.nextInt(2);

		gameTable.setCurrentPlayer(gameTable.getPlayers()[index]);
		logger.print(gameTable.getCurrentPlayer().getName() + " kezdi az első kört.");
	}

}
