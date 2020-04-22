/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack_Project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shivu
 */
public class BlackJackTest {
    
    public BlackJackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up Class");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tear Down Class");
    }
    
    @Before
    public void setUp() {
        System.out.println(" Set up");
    }
    
    @After
    public void tearDown() {
        System.out.println("Tear Down");
    }

   
    @Test
    public void testBet_int_intGood() {
        System.out.println("Bet");
        int cash = 100;
        int bet = 40;
        boolean expResult = true;
        boolean result = BlackJack.Bet(cash, bet);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testBet_int_intBoundary() {
        System.out.println("Bet");
        int cash = 100;
        int bet = 100;
        boolean expResult = true;
        boolean result = BlackJack.Bet(cash, bet);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testBet_int_intBad() {
        System.out.println("Bet");
        int cash = 100;
        int bet = 120;
        boolean expResult = false;
        boolean result = BlackJack.Bet(cash, bet);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testHasBlackJackGood() {
        System.out.println("hasBlackJack Good");
        int handValue = 20;
        boolean expResult = false;
        boolean result = BlackJack.hasBlackJack(handValue);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testHasBlackJackBad() {
        System.out.println("hasBlackJack Bad");
        int handValue = 25;
        boolean expResult = false;
        boolean result = BlackJack.hasBlackJack(handValue);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testHasBlackJackBoundary() {
        System.out.println("hasBlackJack Boundary");
        int handValue = 21;
        boolean expResult = true;
        boolean result = BlackJack.hasBlackJack(handValue);
        assertEquals(expResult, result);
       
    }
}