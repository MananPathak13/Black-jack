/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack_Project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nidhi
 */
public class PlayerTest {
    
    public PlayerTest() {
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
    public void testCalcHandValueGood() {
        System.out.println("calcHandValue");
        ArrayList<Card> hand = new ArrayList<>();
        int expResult = 0;
        int result = Player.calcHandValue(hand);
        assertEquals(expResult, result);
       
    }

      
    @Test
    public void testCheckBustGood() {
        System.out.println("checkBust Good");
        int handvalue = 23;
        boolean expResult = true;
        boolean result = Player.checkBust(handvalue);
        assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckBustBad() {
        System.out.println("checkBust Bad");
        int handvalue = 19;
        boolean expResult = false;
        boolean result = Player.checkBust(handvalue);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckBustBoundary() {
        System.out.println("checkBust Bad");
        int handvalue = 21;
        boolean expResult = false;
        boolean result = Player.checkBust(handvalue);
        assertEquals(expResult, result);
        
    }
    
    
}
