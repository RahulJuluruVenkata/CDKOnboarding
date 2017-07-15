package com.cdk.onboarding.view.logout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.cdk.onboarding.view.base.CDKOnboardGenericActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class Logout extends CDKOnboardGenericActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;
    private static final String TAG="LOGOUT";
    private static final int REQ_CODE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"In signout on create method now .. ");
//        googleApiClient = CDKApplication.getGoogleApiHelper().getGoogleApiClient();
//        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
//                new ResultCallback<Status>() {
//                    @Override
//                    public void onResult(@NonNull Status status) {
//                        setContentView(R.layout.activity_google_sign_in);
//                    }
//                }
//        );
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG,"In signout method now .. ");
        signOut();
    }

    private void signOut() {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        Log.i(TAG,"In signout method now post success logout .. ");

                        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                        startActivityForResult(intent, REQ_CODE);
                    }
                }
        );
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
