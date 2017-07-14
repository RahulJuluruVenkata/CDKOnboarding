package com.cdk.onboarding.cdkapplication.raise_ticket;

/**
 * Created by julurur on 14/07/17.
 */

public class Ticket {
    private String ticketId;
    private String ticketName;
    private String ticketDescription;

    public String getTicketId() {
        return ticketId;
    }

    public Ticket(String ticketId, String ticketName, String ticketDescription) {
        this.ticketId = ticketId;
        this.ticketName = ticketName;
        this.ticketDescription = ticketDescription;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }
}
