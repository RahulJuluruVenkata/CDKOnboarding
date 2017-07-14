package com.cdk.onboarding.dao;

/**
 * Created by julurur on 14/07/17.
 */
import com.cdk.onboarding.cdkapplication.raise_ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketsDAO implements ITickets{
    public List<Ticket> getListOfTickets(){
        List<Ticket> tickets = new ArrayList<Ticket>();
        Ticket t = new Ticket("ONBOARD-1","Get admin access","As a new joinee need to obtain admin access to my laptop");
        Ticket t1 = new Ticket("ONBOARD-2","Update personal details","Please update personal details.");
        Ticket t2 = new Ticket("ONBOARD-3","Update flexible declaration details","LTA :50000 , MA : 125000");
        Ticket t3 = new Ticket("ONBOARD-4","Update bank details","As I already have bank account,please link my existing account as salary account");
        return tickets;
    }
}
