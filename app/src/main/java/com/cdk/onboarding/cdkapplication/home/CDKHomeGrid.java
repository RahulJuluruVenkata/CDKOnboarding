package com.cdk.onboarding.cdkapplication.home;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;

import com.cdk.onboarding.cdkapplication.R;

public class CDKHomeGrid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHomeBannerText("Edited");
        setContentView(R.layout.activity_grid_cdk_home);
    }

    //This gets called by top fragment when user clicks button
    public void setHomeBannerText(String text){
        //EditText text = (EditText)findViewById(R.id.);
    }
}
