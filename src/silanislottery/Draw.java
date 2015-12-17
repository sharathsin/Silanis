/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package silanislottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author sharathsind
 */
class Draw{
List<Ticket>tickets;//to store tickets
int sold_tickets;//counter to store number of sold tickets
HashMap<Integer, Ticket> winnersList;//to store the rank and winner
int draw;
double pot;
boolean draw_finished;//to know whether the draw is finished
//constructer
    public Draw(int draw_no,double pot,int ticketnumber)
{
    tickets=new ArrayList<>();
    sold_tickets=0;
    winnersList=new HashMap<>();
    draw=draw_no;
    this.pot=pot;
            for(int i=0;i<50;i++)
            {
                Ticket temp=new Ticket(i, draw, "silanis");
                tickets.add(temp);
            }

}
    //intializing random winner
    public void intialize_winner()
    {
        for(int i=0;i<3;i++)
        {
            Random r=new Random();
            int winner=r.nextInt(50)+1;
            winnersList.put(i+1,tickets.get(winner));
        }
        draw_finished=true;
    }
    //printing the winner
    public void print_winners()
    {
        System.out.println("Winner \t Prizemoney");
      for(int i=1;i<=3;i++)
      {
      System.out.print("\n"+winnersList.get(i).first_name+"\t");
      switch(i)
      {
          case 1:    System.out.print("$"+Math.round(0.75*(pot/2))); break;
          case 2:     System.out.print("$"+Math.round(0.15*(pot/2))); break;   
          case 3:     System.out.print("$"+Math.round(0.10*(pot/2))); break;
      }
      } 
        
    }
    
   //helps to purchase tickets
    public Ticket purchaseTicket(String firstName) throws TicketException
    {
        if(sold_tickets>50)
        {
            throw new TicketException();
        }
        sold_tickets++;
        Ticket t=tickets.get(sold_tickets);
        t.setFirst_name(firstName);
        t.setState(1);
        tickets.remove(sold_tickets);
        tickets.add(sold_tickets,t);
        return t;
    }

    class TicketException extends Exception
            {

        @Override
        public String getMessage() {
            return "Tickets are unavailable"; //To change body of generated methods, choose Tools | Templates.
        }
        
       }

}