package com.cdk.onboarding.util;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.cdk.onboarding.CDKApplication;
import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.view.about_cdk.AboutCDKOnboard;
import com.cdk.onboarding.view.base.CDKOnboardGenericActivity;
import com.cdk.onboarding.view.base.Home;
import com.cdk.onboarding.view.floormap.FloorMap;
import com.cdk.onboarding.view.main.MainActivity;
import com.cdk.onboarding.view.mydetails.MyDetails;
import com.cdk.onboarding.view.raise_ticket.RaiseTicket;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class CDKMenuUtilities {
    private static final String TAG = "CDKMenuUtilities";
    public static Intent getIntentByMenuItem(AppCompatActivity activity, MenuItem item){
        Intent i = null;
        switch (item.getItemId()) {
            case R.id.menu_item_home:
                i = new Intent(activity, Home.class);
                break;
            case R.id.menu_item_about_cdk:
                i = new Intent(activity, AboutCDKOnboard.class);
                break;
            case R.id.menu_item_my_details:
                i = new Intent(activity, MyDetails.class);
                break;
            case R.id.menu_item_floor_plan:
                i = new Intent(activity, FloorMap.class);
                break;
            case R.id.menu_item_raise_ticket:
                i = new Intent(activity, RaiseTicket.class);
                break;
            case R.id.menu_item_logout:
                i = new Intent(activity, MainActivity.class);
                break;
        }

        return i;
    }

    public static boolean preProcessContentByMenuItem(AppCompatActivity activity, MenuItem item){
        boolean isPreProcessingSuccessful = false;
        switch (item.getItemId()) {
            case R.id.menu_item_home:
                // code here
                break;
            case R.id.menu_item_about_cdk:
                // code here
                break;
            case R.id.menu_item_my_details:
                // code here
                break;
            case R.id.menu_item_floor_plan:
                // code here
                break;
            case R.id.menu_item_raise_ticket:
                // code here
                break;
            case R.id.menu_item_logout:
                // code here
                break;
        }

        return isPreProcessingSuccessful;
    }

    public static void startActivity(CDKOnboardGenericActivity cdkOnboardGenericActivity, Intent intent, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item_logout:

                final GoogleApiClient googleApiClient = CDKApplication.getGoogleApiHelper().getGoogleApiClient();
                final CDKOnboardGenericActivity genericActivity = cdkOnboardGenericActivity;
                final Intent loginIntent = intent;

                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(@NonNull Status status) {
                            //broadcasting that logout is completed
                            Intent broadcastIntent = new Intent();
                            broadcastIntent.setAction("com.package.ACTION_LOGOUT");
                            genericActivity.sendBroadcast(broadcastIntent);

                            Toast.makeText(genericActivity, "Succesfully logged out.", Toast.LENGTH_SHORT).show();
                            genericActivity.startActivity(loginIntent);
                        }
                    }
                );
                break;
            default :
                cdkOnboardGenericActivity.startActivity(intent);
        }
    }
}
