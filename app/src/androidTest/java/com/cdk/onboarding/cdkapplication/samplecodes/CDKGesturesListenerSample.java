package com.cdk.onboarding.cdkapplication.samplecodes;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cdk.onboarding.cdkapplication.R;

public class CDKGesturesListenerSample extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private Button myMessage;
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_cdk_home);

        //myMessage = (Button) findViewById(R.id.);
        this.gestureDetectorCompat = new GestureDetectorCompat(this, this);
        gestureDetectorCompat.setOnDoubleTapListener(this);
    }

    private void changeBackGroundColorBasedOnMenuItem(MenuItem item){
        RelativeLayout home_view = (RelativeLayout) findViewById(R.id.activity_grid_cdk_home);
        switch (item.getItemId()) {
            case R.id.menu_item_home:
                if (item.isVisible()) {
                    home_view.setBackgroundColor(Color.GREEN);
                }
                break;
            case R.id.menu_item_about_cdk:
                if (item.isVisible()) {
                    home_view.setBackgroundColor(Color.GRAY);
                }
                break;
            case R.id.menu_item_my_details:
                if (item.isVisible()) {
                    home_view.setBackgroundColor(Color.RED);
                }
                break;
            case R.id.menu_item_floor_plan:
                if (item.isVisible()) {
                    home_view.setBackgroundColor(Color.BLUE);
                }
                break;
            case R.id.menu_item_raise_ticket:
                if (item.isVisible()) {
                    home_view.setBackgroundColor(Color.MAGENTA);
                }
                break;
            case R.id.menu_item_logout:
                if (item.isVisible()) {
                    home_view.setBackgroundColor(Color.YELLOW);
                }
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //checks for special type of gestures
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //Begin gestures
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        myMessage.setText(R.string.app_name);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }
}
