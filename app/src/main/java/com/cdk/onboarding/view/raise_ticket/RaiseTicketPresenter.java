package com.cdk.onboarding.view.raise_ticket;

import com.cdk.onboarding.model.TicketsListResponse;
import com.cdk.onboarding.networking.module.NetworkError;
import com.cdk.onboarding.networking.services.RaiseTicketService;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class RaiseTicketPresenter {
    private RaiseTicketService raiseTicketService;
    private final RaiseTicketView raiseTicketView;
    private CompositeSubscription subscriptions;

    public RaiseTicketPresenter(RaiseTicketService service, RaiseTicketView view) {
        this.raiseTicketService = service;
        this.raiseTicketView = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getTicketsList() {
        raiseTicketView.showWait();

        Subscription subscription = raiseTicketService.getTicketsList(new RaiseTicketService.GetTicketsListCallBack() {
            @Override
            public void onSuccess(TicketsListResponse ticketsListResponse) {
                raiseTicketView.removeWait();
                String associateId = "123";
                raiseTicketView.getListOfTickets(ticketsListResponse,associateId);
            }

            @Override
            public void onError(NetworkError networkError) {
                raiseTicketView.removeWait();
                raiseTicketView.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }

    public void onStop() {
        subscriptions.unsubscribe();
    }
}
