package com.cdk.onboarding.cdkapplication.home;

import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.view.MotionEvent;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.cdkapplication.about_cdk.AboutCDK;
import com.cdk.onboarding.cdkapplication.floormap.CDKFloorMap;
import com.cdk.onboarding.cdkapplication.login.MainActivity;
import com.cdk.onboarding.cdkapplication.my_details.MyDetails;
import com.cdk.onboarding.cdkapplication.raise_ticket.RaiseTicket;
import com.cdk.onboarding.cdkapplication.utilities.CDKMenuUtilities;

import android.content.Intent;

public class CDKHomeGrid extends AppCompatActivity {

    ViewGroup cdkHomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_cdk_home);

        //demo of motion events and gestures
        cdkHomeLayout = (ViewGroup) findViewById(R.id.activity_grid_cdk_home);
        cdkHomeLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent motionEvent) {
                        moveBanner(v);
                        return true;
                    }
                }
        );
    }

    private void moveBanner(View v) {
        View homeBanner = findViewById(R.id.txt_cdk_home_banner);

        //Change the position of banner
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        homeBanner.setLayoutParams(positionRules);

        //Change the size of banner
        ViewGroup.LayoutParams sizeRules = homeBanner.getLayoutParams();
        sizeRules.height = 300;
        sizeRules.width = 450;
        homeBanner.setLayoutParams(sizeRules);
    }

    //Logic related to different actions related to contextual menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CDKMenuUtilities.preProcessContentByMenuItem(this, item);
        Intent i = CDKMenuUtilities.getIntentByMenuItem(this, item);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}
