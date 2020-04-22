/**
 * SYST 17796 Project Winter 2020 Base code.
 * Modifier- Shubh Patel 
 *           Nidhi Nidhi 
 *           Manan Pathak
 *           Faraz Naqvi
 */
package BlackJack_Project;

/**
 * This is an enumeration class that contains different suits of the cards 
 *
 * @author Manan Pathak
 * date: 12/03/2020
 */
public enum Suit {
    DIAMOND("Diamond"),HEARTS("Hearts"),SPADE("Spade"),CLUB("Club");
    
    private String suit;

    private Suit(String suit) {
        this.suit = suit;
    }
    
    public String getSuit(){
        return suit;
    }
}