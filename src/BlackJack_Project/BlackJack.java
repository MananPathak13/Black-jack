/**
 * SYST 17796 Project Winter 2020 - BlackJack(Group-11).
 * Modifier- Shubh Patel 
 *           Nidhi Nidhi 
 *           Manan Pathak 
 *           Faraz Naqvi 
 * 
 * Citation/Sources: Jared.(2015, June 3). First attempt at a Java Blackjack
   game. StackExchange. Retrieved from: 
   https://codereview.stackexchange.com/questions/92586/first-attempt-at-a-java-blackjack-game
 */
package BlackJack_Project;

import java.util.Scanner;

/**
 * @author dancye
 * @modified Paul Bonenfant 
 * @modified by Shubh Patel 
 */
public class BlackJack {

    public static void main(String[] args) {
        System.out.println("Let's play Blackjack!");
        System.out.println("You have cash: " + Player.getCash());
        Player.play();
    }

    
    //User is allowed to choose bet amount (as long as bet<cash)
    
    public static boolean Bet(int cash, int bet) {
        if (bet > cash) {
            return false;
        }
        return true;
    }

    
    //Users input of hitting or standing is registered
    public static boolean isHitorStand(String hitter) {
        if (hitter.equals("hit") || hitter.equals("stand")) {
            return true;
        }
        return false;
    }

    
    //Method called is five card trick applies (5 cards dealt)
    public static void fivecardtrick() {
        System.out.println("You have achieved a five card trick!");
        Win();
    }

    
    //Method called if there is a push (dealer and player have equal value)
    public static void push() {
        System.out.println("PUSH!\nYou got your money back\nYour Cash "
                + Player.getCash());
    }

    
    //Check to see if user value = 21 (blackajack)
    public static boolean hasBlackJack(int handValue) {
        if (handValue == 21) {
            return true;
        }
        return false;
    }

    
    //Calculates players cash & pool
    public static void money() {
        System.out.println("Cash:" + (Player.getCash() - Player.getBet()));
        System.out.println("Money on the table:" + Player.getBet());
    }

    
    //Win statement
    public static void Win() {
        System.out.println("Congratulations, you win!");
        Player.setCash(Player.getCash() + Player.getBet());
        System.out.println("Cash: " + Player.getCash());
    }

    
    //Loss statement
    public static void Lose() {
        System.out.println("Sorry, you lose!");
        Player.setCash(Player.getCash() - Player.getBet());
        System.out.println("Cash: " + Player.getCash());
    }

    
    //General win/loss statement
    public static void results() {
        System.out.println("Your cash is: " + Player.getCash());
        if (Player.getCash() == 0) {
            System.out.println("Oops, no cash left!");
        } else {
            System.out.println("You won!");
        }
    }

    
    //Method to restart game
    public static boolean playAgain(Scanner sc) {
        System.out.println("Play again(yes/no)");//ask if the user wants to keep going
        String answer = sc.nextLine();
        while (!Player.isyesorno(answer)) {
            System.out.println("Please enter yes or no.");
            answer = sc.nextLine();
        }
        if (answer.equals("no")) {
            return false;
        }
        return true;
    }

}
