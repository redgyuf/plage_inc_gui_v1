package utility;

import player.Player;
import model.Table;

public class CardComparator {
	public Player compare(Player player1, Player player2){
		
		switch(player1.compareTo(player2)){
			case 1:
				return player1;
			case -1:
				return player2;
		}
		return null;
	}
	
public Player compare(Player player1, Player player2, String stat){
		
		switch(player1.compareTo(player2, stat)){
			case 1:
				return player1;
			case -1:
				return player2;
		}
		return null;
	}
}
