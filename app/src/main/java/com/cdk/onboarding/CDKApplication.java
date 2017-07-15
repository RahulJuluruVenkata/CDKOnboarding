package com.cdk.onboarding;

import android.app.Application;

import com.cdk.onboarding.data.db.dao.helper.GoogleApi.GoogleApiHelper;


public class CDKApplication extends Application {
    private GoogleApiHelper googleApiHelper;
    private static CDKApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        googleApiHelper = new GoogleApiHelper(mInstance);
    }

    public static synchronized CDKApplication getInstance(){
        return mInstance;
    }

    public GoogleApiHelper getGoogleApiHelperInstance() {
        return this.googleApiHelper;
    }
    public static GoogleApiHelper getGoogleApiHelper() {
        return getInstance().getGoogleApiHelperInstance();
    }
}
