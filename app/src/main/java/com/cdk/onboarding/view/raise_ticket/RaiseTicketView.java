package com.cdk.onboarding.view.raise_ticket;

import com.cdk.onboarding.model.TicketsListResponse;

/**
 * Created by julurur on 17/07/17.
 */

public interface RaiseTicketView {
     /*List<Tickets> */

    void getListOfTickets(TicketsListResponse ticketsListResponse,String associateId);
    void showWait();
    void removeWait();
    void onFailure(String appErrorMessage);

}
