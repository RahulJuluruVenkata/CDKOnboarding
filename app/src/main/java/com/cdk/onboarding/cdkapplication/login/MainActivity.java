package com.cdk.onboarding.cdkapplication.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import android.graphics.Color;

import android.widget.ImageView;
import android.content.res.Resources;
import android.util.TypedValue;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cdk.onboarding.cdkapplication.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CDKTag_Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Listening to button click event
        Button loginButton = (Button)findViewById(R.id.btn_login);
//        loginButton.setOnClickListener(
//                new Button.OnClickListener(){
//                    public void onClick(View v){
//                        EditText textWelcome = (EditText) findViewById(R.id.txt_login);
//                        Log.i(TAG,"into click event");
//                        textWelcome.setText("Click event!!");
//                        setContentView(R.layout.activity_grid_cdk_home);
//                    }
//                }
//        );

        //Listening to button on long click listener
        loginButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        TextView textWelcome = (TextView)findViewById(R.id.txt_login);
                        Log.i(TAG,"into long click event");
                        textWelcome.setText("Long click event!!");
                        return true;
                    }
                }
        );
    }
}
