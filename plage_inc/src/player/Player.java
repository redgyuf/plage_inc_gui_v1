package player;

import java.util.Scanner;

import game.DiseaseCard;
import utility.Logger;

public class Player implements Comparable<Player>{
	
	private Hand hand;
	private String name;
	private int choosedStatID = -1;

	public Player(Hand hand, String name) {
		this.hand = hand;
		this.name = name;
	}

	public Hand getHand(){
		return hand;
	}
	
	public void giveCard(DiseaseCard card, Player target){
		target.getHand().addCard(card);
		hand.removeCard(card);
	}
	
	public void setName(String name) {
		this.name = name;
	}	

	public String getName() {
		return name;
	}

	public String chooseStat(){
		Logger logger = new Logger();
		String choosedStat = null;

		
		Scanner sc = new Scanner(System.in);
		logger.print("Válassz tulajdonságot (1-3, 4 - Kilépés):");
		try{
			choosedStatID = sc.nextInt();
		}catch(NumberFormatException e){
			logger.print("Ilyen lehetőség nincs!");
			logger.print("Add meg a tulajdonság számát.");
		}
		//sc.close();
		
		switch(choosedStatID){
		case 1:
			choosedStat = "lethality";
			break;
		case 2:
			choosedStat = "victims";
			break;
		case 3:
			choosedStat = "incubationTime";
			break;
		case 4:
			System.exit(0);
		}
		
		return choosedStat;
	}
	
	public String toString(){
		return "Név: " + name + "\n, Aktuális kártya: " + hand.getTopCard().toString();
	}

	@Override
	public int compareTo(Player otherPlayer) {
		switch(chooseStat()){
			case "lethality":{
				Integer currentPlayerStat = getHand().getTopCard().getLethality();
				Integer otherPlayerStat = otherPlayer.getHand().getTopCard().getLethality();
				
				if(currentPlayerStat.equals(otherPlayerStat))
					return 0;
				else if(currentPlayerStat > otherPlayerStat)
					return 1;
				else
					return -1;
			}	
			case "victims":{
				double currentPlayerStat = getHand().getTopCard().getVictims();
				double otherPlayerStat = otherPlayer.getHand().getTopCard().getVictims();
				
				if(currentPlayerStat == otherPlayerStat)
					return 0;
				else if(currentPlayerStat > otherPlayerStat)
					return 1;
				else
					return -1;
			}
			case "incubationTime":{
				short currentPlayerStat = getHand().getTopCard().getIncubationTime();
				short otherPlayerStat = otherPlayer.getHand().getTopCard().getIncubationTime();
				
				if(currentPlayerStat == otherPlayerStat)
					return 0;
				else if(currentPlayerStat > otherPlayerStat)
					return 1;
				else
					return -1;
			}	
		}
		return 0;
	}

	public String getChoosedStat()
	{
		switch(choosedStatID)
		{
			case 1:
				return "Halálozás arány";
			case 2:
				return   "Áldozatok";
			case 3:
				return  "Lappangás";
			case 4:
				return "Kilépés";
		}
		return "apadfasza";
	}
	
	public int compareTo(Player otherPlayer, String stat) {
		switch(stat){
			case "lethality":{
				Integer currentPlayerStat = getHand().getTopCard().getLethality();
				Integer otherPlayerStat = otherPlayer.getHand().getTopCard().getLethality();
				
				if(currentPlayerStat.equals(otherPlayerStat))
					return 0;
				else if(currentPlayerStat > otherPlayerStat)
					return 1;
				else
					return -1;
			}	
			case "victims":{
				double currentPlayerStat = getHand().getTopCard().getVictims();
				double otherPlayerStat = otherPlayer.getHand().getTopCard().getVictims();
				
				if(currentPlayerStat == otherPlayerStat)
					return 0;
				else if(currentPlayerStat > otherPlayerStat)
					return 1;
				else
					return -1;
			}
			case "incubationTime":{
				short currentPlayerStat = getHand().getTopCard().getIncubationTime();
				short otherPlayerStat = otherPlayer.getHand().getTopCard().getIncubationTime();
				
				if(currentPlayerStat == otherPlayerStat)
					return 0;
				else if(currentPlayerStat > otherPlayerStat)
					return 1;
				else
					return -1;
			}	
		}
		return 0;
	}
}
