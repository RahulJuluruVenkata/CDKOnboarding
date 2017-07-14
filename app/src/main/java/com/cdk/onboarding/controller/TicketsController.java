package com.cdk.onboarding.controller;

/**
 * Created by julurur on 14/07/17.
 */
import com.cdk.onboarding.cdkapplication.raise_ticket.Ticket;
import com.cdk.onboarding.dao.TicketsDAO;

import java.util.List;

public class TicketsController {
    private static TicketsController ticketsController;
    private TicketsDAO ticketsDAO ;

    private TicketsController(){
        ticketsController = new TicketsController();
        ticketsDAO = new TicketsDAO();
    }

    public static TicketsController getInstance(){
        return ticketsController;
    }

    public List<Ticket> getListOfTickets(){
        return ticketsDAO.getListOfTickets();
    }
}
