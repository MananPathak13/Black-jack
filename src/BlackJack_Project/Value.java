/**
 * SYST 17796 Project Winter 2020 - BlackJack(Group-11).
 * Modifier- Shubh Patel 
 *           Nidhi Nidhi 
 *           Manan Pathak
 *           Faraz Naqvi
 */
package BlackJack_Project;

/**
 * This is an enumeration class that contains different value of the cards 
 *
 */

public enum Value {
    TWO(2,"Two"),THREE(3,"Three"),FOUR(4,"Four"),FIVE(5,"Five"),SIX(6,"Six"),
    SEVEN(7,"Seven"),EIGHT(8,"Eight"),NINE(9,"Nine"),TEN(10,"Ten"),
    JACK(10,"Jack"),QUEEN(10,"Queen"),KING(10,"King"),ACE(1,"Ace");
    
    private int value;
    private String name;

    private Value(int value, String name) {
        this.value = value;
        this.name = name;
    }
    
    public int getValue(){
        return value;
    }
    public String getName(){
        return name;
    }
}
