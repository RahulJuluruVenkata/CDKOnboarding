package com.cdk.onboarding.data.db.dao.helper;

/**
 * Created by julurur on 14/07/17.
 */

import com.cdk.onboarding.model.ticket.TicketModel;

import java.util.ArrayList;
import java.util.List;

public class TicketsHelper{
    private static TicketsHelper ticketsHelper;

    private TicketsHelper(){
        ticketsHelper = new TicketsHelper();
    }

    public static TicketsHelper getInstance(){
        return ticketsHelper;
    }

    public List<TicketModel> getListOfTickets(){
        List<TicketModel> tickets = new ArrayList<TicketModel>();
        TicketModel t = new TicketModel("ONBOARD-1","Get admin access","As a new joinee need to obtain admin access to my laptop");
        TicketModel t1 = new TicketModel("ONBOARD-2","Update personal details","Please update personal details.");
        TicketModel t2 = new TicketModel("ONBOARD-3","Update flexible declaration details","LTA :50000 , MA : 125000");
        TicketModel t3 = new TicketModel("ONBOARD-4","Update bank details","As I already have bank account,please link my existing account as salary account");
        return tickets;
    }
}
