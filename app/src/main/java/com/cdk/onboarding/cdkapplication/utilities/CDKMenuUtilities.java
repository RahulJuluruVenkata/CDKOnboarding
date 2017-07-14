package com.cdk.onboarding.cdkapplication.utilities;

/**
 * Created by julurur on 14/07/17.
 */
import android.content.Intent;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.cdkapplication.about_cdk.AboutCDK;
import com.cdk.onboarding.cdkapplication.floormap.CDKFloorMap;
import com.cdk.onboarding.cdkapplication.home.CDKHomeGrid;
import com.cdk.onboarding.cdkapplication.login.MainActivity;
import com.cdk.onboarding.cdkapplication.my_details.MyDetails;
import com.cdk.onboarding.cdkapplication.raise_ticket.RaiseTicket;

public class CDKMenuUtilities {
    public static Intent getIntentByMenuItem(AppCompatActivity activity, MenuItem item){
        Intent i = null;
        switch (item.getItemId()) {
            case R.id.menu_item_home:
                i = new Intent(activity, CDKHomeGrid.class);
                break;
            case R.id.menu_item_about_cdk:
                i = new Intent(activity, AboutCDK.class);
                break;
            case R.id.menu_item_my_details:
                i = new Intent(activity, MyDetails.class);
                break;
            case R.id.menu_item_floor_plan:
                i = new Intent(activity, CDKFloorMap.class);
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
}
