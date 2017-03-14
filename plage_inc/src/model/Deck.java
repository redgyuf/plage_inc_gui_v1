package model;
import java.util.Collection;
import java.util.Vector;

import game.DiseaseCard;
import utility.CSVReader;

public class Deck {

	protected Collection<DiseaseCard> cards;
	private CSVReader reader;
	
	public Deck(){
		 cards = new Vector<DiseaseCard>();
		 reader = new CSVReader();
	}

	public void addCards() {
		cards = reader.getDeck();
	}

	public int getSize() {
		return cards.size();
	}

	public void removeCard(int index) {
		cards.remove(cards.toArray()[index]);
	}
	
	public void removeCard(DiseaseCard card){
		cards.remove(card);
	}
	
	public Vector<DiseaseCard> getCards(){
		return (Vector<DiseaseCard>)cards;
	}
}
