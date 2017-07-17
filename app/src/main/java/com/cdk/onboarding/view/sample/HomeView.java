package com.cdk.onboarding.view.sample;

import com.cdk.onboarding.model.CityListResponse;


/**
 * Created by ennur on 6/25/16.
 */
public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getityListSuccess(CityListResponse cityListResponse);

}
