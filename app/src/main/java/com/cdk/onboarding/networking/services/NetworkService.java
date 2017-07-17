package com.cdk.onboarding.networking.services;


import com.cdk.onboarding.model.CityListResponse;
import com.cdk.onboarding.model.TicketsListResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();

    @GET("v1/tickets")
    Observable<TicketsListResponse> getTicketsList();
}
