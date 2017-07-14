package com.cdk.onboarding.dao;

import com.cdk.onboarding.cdkapplication.raise_ticket.Ticket;

import java.util.List;
/**
 * Created by julurur on 14/07/17.
 */

public interface ITickets {
    List<Ticket> getListOfTickets();
}
