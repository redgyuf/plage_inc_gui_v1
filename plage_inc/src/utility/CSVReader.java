package utility; /**
 * Created by tamasferenc on 2017.02.28..
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import game.DiseaseCard;

public class CSVReader {

	private static final int NAME = 0;
	private static final int LETHALITY = 1;
	private static final int VICTIMS = 2;
	private static final int INCUBATION = 3;
	private String filepath = "src/diseases.csv";
    private Vector<DiseaseCard> deck = new Vector<DiseaseCard>();
    
    public CSVReader(){
    	readInCards();
    }
    
    public Vector<DiseaseCard> getDeck(){
    	return this.deck;
    }

    public void readInCards() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(filepath));
            
            while ((line = br.readLine()) != null) {

                String[] virus = line.split(cvsSplitBy);

                deck.add(new DiseaseCard(
                		virus[NAME],
						Integer.parseInt(virus[LETHALITY]), 
						Double.parseDouble(virus[VICTIMS]), 
						Short.parseShort(virus[INCUBATION])));
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}