/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package silanislottery;

/**
 *
 * @author sharathsind
 */
public class Ticket {

    int ticket_number, draw_number, state;
    String first_name;

    public Ticket(int ticket_number, int draw_number, String first_name) {
        this.ticket_number = ticket_number;
        this.draw_number = draw_number;
        this.first_name = first_name;
    }

    public int getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(int ticket_number) {
        this.ticket_number = ticket_number;
    }

    public int getDraw_number() {
        return draw_number;
    }

    public void setDraw_number(int draw_number) {
        this.draw_number = draw_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
