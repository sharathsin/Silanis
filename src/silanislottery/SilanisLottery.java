/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package silanislottery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sharathsind
 */
public class SilanisLottery {

    /**
     * @param args the command line arguments
     */
    
    ArrayList<Draw>draws;
    BufferedReader br;
    public SilanisLottery()
    {
       draws =new ArrayList<>();
      for(int i=0;i<12;i++)
      {
          Draw temp=new Draw(i+1, 200, 50);
          draws.add(temp);
      }
        br = new BufferedReader(new InputStreamReader(System.in));
          
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       SilanisLottery silanis=new SilanisLottery();
       
       while(true)
       {
       String option=silanis.getUserOption();
       switch(option)
       {
            case "purchase":silanis. purchase(); break;
            case  "winners":silanis.winners();break;
            case  "draw":silanis.setDraw();  break;                  
       }
             
       }
      }
    public void setDraw()
    {
        System.out.println("Enter the draw no[1-12]");
        
       int draw=0;
       
        try {
            draw= Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(SilanisLottery.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NumberFormatException e)
        {
            System.err.println("only numbers");
        }
       if(draw>draws.size()|| draw<0)
       {
           System.out.println("Should be between 1to 12");
       }
       else{
           if(draws.get(draw).draw_finished)
           {
               System.out.println("the draw is finished and winners are already chosen");
           }
           else{
               draw_intialize(draw);
               System.out.println("Winners have been choosen");
               
           }
       }
        
       
  
        
    }
    public void winners()
    {
        System.out.println("Enter the draw no[1-12]");
        int draw=0;
       
        try {
            draw= Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(SilanisLottery.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NumberFormatException e)
        {
            System.err.println("only numbers");
        }
       draw--;
       if(draw>draws.size()|| draw<0)
       {
                         System.out.println("Should be between 1to 12");

       }
       else{
           if(draws.get(draw).draw_finished)
           {
              draws.get(draw).print_winners();
           }
           else{
            draw_intialize(draw);
             draws.get(draw).print_winners();
             
               
           }
       }
       
        
    }
    public void draw_intialize(int draw)
    {
        Draw d=draws.get(draw);
        d.intialize_winner();
        draws.remove(draw);
        draws.add(draw, d);
    
    
    }
    public void purchase() 
            
    {
        System.out.println("Enter the draw no[1-12]");
       // Scanner input=new Scanner(System.in);
        
   int draw= 0;
   
        try {
            draw= Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            Logger.getLogger(SilanisLottery.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NumberFormatException e)
        {
            System.err.println("only numbers");
        }
   draw--;
       if(draw>draws.size()|| draw<0)
       {
           System.out.println("Should be between 1to 12");
       }
       else{
           if(draws.get(draw).draw_finished)
           {
               System.out.println("the draw is finished and winners are already chosen");
           }
           else{
               try{
                Draw temp=   draws.get(draw);
                System.out.println("Enter the firstname");
                String s="";
                   try {
                       s = br.readLine();
                   } catch (IOException ex) {
                       Logger.getLogger(SilanisLottery.class.getName()).log(Level.SEVERE, null, ex);
                   }
                temp.purchaseTicket(s);
                           
               }
               catch(Draw.TicketException e)
               {
                   System.err.println(e.getMessage());
                   
               }
               
           }
       }
   
    }
    public String getUserOption()
    {
        int choice=0;
        System.out.println("Choose one of the followung choice \n 1.Purchase \n 2.Winners \n 3.draw\n 4.Exit");
        try {
            choice=Integer.parseInt(br.readLine().trim());
        } catch (IOException ex) {
            Logger.getLogger(SilanisLottery.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NumberFormatException e)
        {
            System.err.println("only numbers");
        }

       
       

        
        
        switch(choice)
        {
            case 1: return "purchase";
            case 2: return "winners";
            case 3: return "draw";    
            case 4: try {
                br.close();
        } catch (IOException ex) {
            Logger.getLogger(SilanisLottery.class.getName()).log(Level.SEVERE, null, ex);
        }
                System.exit(0);
            default:System.err.println("Invalid Option"); return "Invalid Option";
        }
    }
    
}












