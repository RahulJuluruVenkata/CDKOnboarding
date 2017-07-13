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

public class CDKHomeGrid extends AppCompatActivity {

    ViewGroup cdkHomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_cdk_home);

        //demo of motion events and gestures
        cdkHomeLayout = (ViewGroup)findViewById(R.id.activity_grid_cdk_home);
        cdkHomeLayout.setOnTouchListener(
            new RelativeLayout.OnTouchListener(){
                public boolean onTouch(View v,MotionEvent motionEvent){
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
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);

        homeBanner.setLayoutParams(positionRules);

        //Change the size of banner
        ViewGroup.LayoutParams sizeRules = homeBanner.getLayoutParams();
        sizeRules.height = 300;
        sizeRules.width = 450;
        homeBanner.setLayoutParams(sizeRules);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //This gets called by top fragment when user clicks button
    public void setHomeBannerText(String text){
        RelativeLayout home_view = (RelativeLayout)findViewById(R.id.activity_grid_cdk_home);
        EditText textControl = (EditText)home_view.findViewById(R.id.txt_cdk_home_banner);
        textControl.setText(text);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout home_view = (RelativeLayout)findViewById(R.id.activity_grid_cdk_home);
        switch (item.getItemId()){
            case R.id.menu_item_home:
                if(item.isVisible()){
                    home_view.setBackgroundColor(Color.GREEN);
                }
                break;
            case R.id.menu_item_about_cdk:
                if(item.isVisible()){
                    home_view.setBackgroundColor(Color.GRAY);
                }
                break;
            case R.id.menu_item_my_details:
                if(item.isVisible()){
                    home_view.setBackgroundColor(Color.RED);
                }
                break;
            case R.id.menu_item_floor_plan:
                if(item.isVisible()){
                    home_view.setBackgroundColor(Color.BLUE);
                }
                break;
            case R.id.menu_item_raise_ticket:
                if(item.isVisible()){
                    home_view.setBackgroundColor(Color.MAGENTA);
                }
                break;
            case R.id.menu_item_logout:
                if(item.isVisible()){
                    home_view.setBackgroundColor(Color.YELLOW);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
