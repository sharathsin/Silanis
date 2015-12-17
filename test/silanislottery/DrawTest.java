/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package silanislottery;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sharathsind
 */
public class DrawTest {
    
    public DrawTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of intialize_winner method, of class Draw.
     */
        @Test
    public void testIntializetickets() {
        System.out.println("intializetickets");
     Draw instance = new Draw(1, 200, 50);
     
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.tickets.size()==50);
    }
    @Test
    public void testIntialize_winner() {
        System.out.println("intialize_winner");
          String firstName = "test";
      Draw instance = new Draw(1, 200, 50);
      try{
      for(int i=0;i<6;i++)    {
         Ticket t=  instance.purchaseTicket(firstName);
      }
      }
      catch(Draw.TicketException e)
      {
          System.err.println("no tickets");
          
      }
        instance.intialize_winner();
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.winnersList.size()==3);
    }

    /**
     * Test of print_winners method, of class Draw.
     */
  

    /**
     * Test of intializetickets method, of class Draw.
     */


    /**
     * Test of purchaseTicket method, of class Draw.
     */
    @Test
    public void testPurchaseTicket() throws Exception {
        System.out.println("purchaseTicket");
        String firstName = "test";
      Draw instance = new Draw(1, 200, 50);
      Ticket t=  instance.purchaseTicket(firstName);
        // TODO review the generated test code and remove the default call to fail.
               assertTrue(t.getFirst_name().equals("test"));
    }
    
}
