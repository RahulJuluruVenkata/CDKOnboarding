package com.cdk.onboarding.view.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cdk.onboarding.cdkapplication.R;

public class Home extends CDKOnboardGenericActivity {

    ViewGroup cdkHomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_cdk_home);

        //get login details from login screen
        TextView userName = (TextView)findViewById(R.id.txt_google_username);
        TextView userMail = (TextView)findViewById(R.id.txt_google_user_email) ;
        ImageView userImage = (ImageView)findViewById(R.id.prof_pic) ;

        Intent i = this.getIntent();
        Bundle bundle = i.getExtras();
        userName.setText(bundle.getString("username"));
        userMail.setText(bundle.getString("email"));
        //Glide.with(this).load(bundle.getString("photoUrl")).into(userImage);

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
}
