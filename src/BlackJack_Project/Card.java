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


public class Card {

    
    //Using enum classes to build a card object (suit and value given)

     private Suit suit;
     private Value value;

     public Card(Suit suit, Value value){ 
        this.value = value;
        this.suit = suit;
    }
     
     public int getValue(){
         return value.getValue();
     }
     
     public String getName(){
         return value.getName();
     }

	public String toString(){
		return value.getName()+" of "+suit.getSuit();
	}
}
