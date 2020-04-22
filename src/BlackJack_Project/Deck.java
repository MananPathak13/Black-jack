/**
 * SYST 17796 Project Winter 2020 - BlackJack(Group-11).
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 * Modifier- Shubh Patel
 *           Nidhi Nidhi
 *           Manan Pathak
 *           Faraz Naqvi
 */
package BlackJack_Project;

import java.util.ArrayList;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game.
 *
 * @author dancye
 * @modified Paul Bonenfant Jan 2020
 * @modified Nidhi Nidhi 
 */
public class Deck {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<>();

    ;
    
    //Creates deck with cards (suit and values assigned)
    public Deck() {
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                cards.add(new Card(s, v));
            }
        }
    }

    //Method to randomize card order
    public void shuffle() {
        Random r = new Random();
        Card c;
        for (int i = 0; i < 200; i++) {
            int index1 = r.nextInt(cards.size() - 1);
            int index2 = r.nextInt(cards.size() - 1);
            c = cards.get(index2);
            cards.set(index2, cards.get(index1));
            cards.set(index1, c);
        }

    }
    
    //Drawn card is removed from deck
    public Card drawCard() {
        return cards.remove(0);
    }

}//end class
