/**
 * SYST 17796 Project Winter 2020 - BlackJack(Group-11).
 * Students can modify and extend to implement their game.
 * Modifier- Shubh Patel
 *           Nidhi Nidhi
 *           Manan Pathak
 *           Faraz Naqvi
 */
package BlackJack_Project;

import java.util.ArrayList;


public class Dealer extends Player {
    
    private int handvalue=0;//value of the dealer's handOfDealer (starts at 0)  
    private Card[] aHand = new Card[]{};//used to convert the dealer's handOfDealer to an array
    private int ace = 0;//counts the aces in the dealer's handOfDealer
    private ArrayList<Card> handOfDealer = new ArrayList<>();;//represents the dealer's handOfDealer
    
    public Dealer(Deck deck){      
    
        for(int i=0; i<=1; i++){
            handOfDealer.add(deck.drawCard());
        }   
        aHand = handOfDealer.toArray(aHand);
        
        for(int i=0; i<aHand.length; i++){
        handvalue += aHand[i].getValue();
            if(aHand[i].getValue()==11){
                ace++;
            }while(ace>0 && handvalue>21){
                handvalue-=10;
                ace--;
            }
        }
    }

    //Assigns first card to dealer (face-up card)
    public String firstCard(){
        Card[] fCard = new Card[]{};
        fCard = handOfDealer.toArray(fCard);
        return ""+fCard[0];
    }

    //Method gives dealer a second card (accounts for points value such as aces)
    public void Hit(Deck deck) {
        handOfDealer.add(deck.drawCard());
        aHand = handOfDealer.toArray(aHand);
        handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                ace++;
            }
            while (ace > 0 && handvalue > 21) {
                handvalue -= 10;
                ace--;
            }
        }
    }

    //If dealers value is <17, he is dealt another card until condition is false
    public boolean ifHit(){
        if(handvalue<17){
        return true;
    }
    return false;
    }

    //Blackjack statement for dealer (if value = 21)
    public boolean hasBlackJack(){
        
        if(handOfDealer.size()==2 && handvalue==21){
            System.out.println("The dealer has blackjack!");
        return true;
        }
    return false;
    }

    //Prints the dealer's handOfDealer.
    public String dealerHand(){    
        return handOfDealer.toString();
    }

    //Returns the value of the dealer's handOfDealer.
    public int getHandValue(){
        return handvalue;
    }
    
    
    //Automatic turns are taken for dealer and returns value of handOfDealer.
    public int takeTurn(Deck deck){
        while(ifHit()){
            System.out.println("The dealer hits");
            Hit(deck);
            if(super.checkBust(handvalue)){
                break;
            }
        }
        if(handvalue<=21){
            System.out.print("The dealer stands.");
        }
    return handvalue;
    }

}
