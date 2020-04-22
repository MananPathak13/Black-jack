/**
 * SYST 17796 Project Winter 2020 - BlackJack(Group-11).
 * Modifier- Shubh Patel 
 *           Nidhi Nidhi 
 *           Manan Pathak
 *           Faraz Naqvi
 */
package BlackJack_Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pathak
 */
public class Player {

    private static int cash = 100;//User starting cash
    private static int bet;//Bet amount
    private static int countOfAce;//Counts aces in users hand
    private static ArrayList<Card> hand;//Array representing users hand
    private static int valueOfHand;//Total value of users hand

    //Getters and setters created for above fields
    public static int getCash() {
        return cash;
    }

    public static int getCountOfAce() {
        return countOfAce;
    }

    public static void setCountOfAce(int countOfAce) {
        Player.countOfAce = countOfAce;
    }

    public static int getValueOfHand() {
        return valueOfHand;
    }

    public static void setValueOfHand(int valueOfHand) {
        Player.valueOfHand = valueOfHand;
    }

    public static int getBet() {
        return bet;
    }

    public static void setCash(int cash) {
        Player.cash = cash;
    }

    public static void setBet(int bet) {
        Player.bet = bet;
    }
    
    //Method runs initial game features (betting, hand values)
    public static void play() {
        Scanner sc = new Scanner(System.in);
        while (cash > 0) {
            Deck deck = new Deck();
            deck.shuffle();
            countOfAce = 0;
            Dealer dealer = new Dealer(deck);

            ArrayList<Card> hand = new ArrayList<>();
            hand.add(deck.drawCard());
            hand.add(deck.drawCard());

            System.out.print("Enter amount to bet ");
            try {
                bet = sc.nextInt();
            } catch (IllegalArgumentException e) {
                System.out.println("You must eneter an integer");
                bet = sc.nextInt();
            }
            
            while (!BlackJack.Bet(cash, bet)) {
                System.out.println("You cannot bet more than the $" + cash);
                bet = sc.nextInt();
            }
            BlackJack.money();
            System.out.println("Here is your hand: "+hand);
            int totalValue = calcHandValue(hand);
            System.out.println("Here is dealer's hand: "+dealer.firstCard());
            
            //If statement to check if both parties have a blackjack
            if (BlackJack.hasBlackJack(totalValue) && dealer.hasBlackJack()) {        
                BlackJack.push();
            } else if (BlackJack.hasBlackJack(totalValue)){//User blackjack check
                System.out.println("You have BlackJack!\nYou get double money back.");
                cash = cash + bet;
                BlackJack.Win();
            } else if (dealer.hasBlackJack()){//Dealer blackjack check     
                System.out.println("Here is the dealer's hand:"+dealer.dealerHand());          
                BlackJack.Lose();
            } else{
                //User input taken for whether he wants to hit or stand
                System.out.println("Would you like to hit or stand?");
                String hitter = sc.nextLine();
                while (!BlackJack.isHitorStand(hitter)){
                    System.out.println("Please enter 'hit' or 'stand'.");
                    hitter = sc.nextLine();
                }

                //Hits user if conditions are met
                while (hitter.equalsIgnoreCase("hit")){
                    Hit(deck, hand);
                    System.out.print("Your hand is now: "+hand);
                    totalValue = Player.calcHandValue(hand);
                    if (Player.checkBust(totalValue)){//Bust checker (over 21)    
                        BlackJack.Lose();
                        break;
                    }
                    //Five card trick check
                    if (totalValue <= 21 && hand.size() == 5){
                        BlackJack.fivecardtrick();
                        break;
                    }
                    System.out.println("Would you like to hit or stand?");
                    hitter = sc.nextLine();
                }
                if (hitter.equalsIgnoreCase("stand")){//User may stand
                    int dealerhand = dealer.takeTurn(deck);//Dealers turn occurs
                    stand(dealerhand, dealer, dealerhand);
                }
            }
            boolean answer = BlackJack.playAgain(sc);
            if (!answer) {
                break;
            }
        }
    }

    public static void stand(int dealerhand, Dealer dealer, int handvalue) {

        //Dealers hand is checked (over 21 --> user wins)
        System.out.println("Dealer's hand: ");
        dealer.dealerHand();
        if (dealerhand > 21)
        {
            BlackJack.Win();
        } else {
            int you = 21 - handvalue;//Statements check who is closer to 21 (winner)
            int deal = 21 - dealerhand;
            if (you == deal) {
                BlackJack.push();
            }
            if (you < deal) {
                BlackJack.Win();
            }
            if (deal < you) {
                BlackJack.Lose();
            }
        }
    }

    /*
 * Value of players hand is calculated
     */
    public static int calcHandValue(ArrayList<Card> hand) {
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        int handvalue = 0;
        for (int i = 0; i < aHand.length; i++) {
            handvalue += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                countOfAce++;
            }
            while (countOfAce > 0 && handvalue > 21) {
                handvalue -= 10;
                countOfAce--;
            }
        }
        return handvalue;
    }

    
    //Method checks if user input equates to yes or no
    
    public static boolean isyesorno(String answer) {
        if (answer.equals("yes") || answer.equals("no")) {
            return true;
        }
        return false;
    }

    //Method checks to see if user has busted (Hand value exceeds 21)
    public static boolean checkBust(int handvalue) {
        if (handvalue > 21) {
            System.out.println("You have busted!");
            return true;
        }
        return false;
    }

    
    //Value of hand compared against cards dealt
    public static void Hit(Deck deck, List<Card> hand) {
        hand.add(deck.drawCard());
        Card[] aHand = new Card[]{};
        aHand = hand.toArray(aHand);
        valueOfHand = 0;
        for (int i = 0; i < aHand.length; i++) {
            valueOfHand += aHand[i].getValue();
            if (aHand[i].getValue() == 11) {
                countOfAce++;
            }
            while (countOfAce > 0 && valueOfHand > 21) {
                valueOfHand -= 10;
                countOfAce--;
            }
        }
    }
}
