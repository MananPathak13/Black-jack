/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * Modifier- Shubh Patel
 *           Nidhi Nidhi
 *           Manan Pathak
 *           Faraz Naqvi
 */
package BlackJack_Project;

/**
 * A class to be used as the base Card class for the project.
 *
 * @author dancye
 * @modifier Shubh Patel - 12/03/2020
 */
public class Card {

    /**
     * Using enum classes to build a card object
     */

     private Suit suit;
     private Value value;

     public Card(Suit suit, Value value){
    
        this.value = value;
        this.suit = suit;
    
    }

	public void getValue() {
		// TODO - implement Card.getValue
		throw new UnsupportedOperationException();
	}

	public int toString() {
		// TODO - implement Card.toString
		throw new UnsupportedOperationException();
	}



}
