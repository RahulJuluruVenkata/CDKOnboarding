package com.cdk.onboarding.networking.services;

import com.cdk.onboarding.model.TicketsListResponse;
import com.cdk.onboarding.networking.module.NetworkError;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RaiseTicketService extends com.cdk.onboarding.networking.services.Service {
    private final NetworkService networkService;

    public RaiseTicketService(){
        this.networkService = null;
    }

    public RaiseTicketService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getTicketsList(final GetTicketsListCallBack callback) {

        return networkService.getTicketsList()
                .subscribeOn(Schedulers.io())
                .observeOn(rx.schedulers.Schedulers.newThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends TicketsListResponse>>() {
                    @Override
                    public Observable<? extends TicketsListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<TicketsListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(TicketsListResponse ticketsListResponse) {
                        callback.onSuccess(ticketsListResponse);
                    }
                });
    }

    public interface GetTicketsListCallBack{
        void onSuccess(TicketsListResponse ticketsListResponse);

        void onError(NetworkError networkError);
    }
}
