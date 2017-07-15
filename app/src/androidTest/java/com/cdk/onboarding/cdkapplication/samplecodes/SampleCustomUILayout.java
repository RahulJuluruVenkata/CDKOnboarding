package com.cdk.onboarding.cdkapplication.samplecodes;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.cdk.onboarding.cdkapplication.R;

public class SampleCustomUILayout extends AppCompatActivity {

    private static final String TAG = "CDKTag_Sample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set this as default view
        RelativeLayout loginLayout = getCustomLayout();
        setContentView(loginLayout);
    }

    private RelativeLayout getCustomLayout(){
        //DIP = Density independent pixels
        Resources res = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200, res.getDisplayMetrics());

        //Layout
        RelativeLayout loginLayout = new RelativeLayout(this);
        loginLayout.setBackgroundColor(Color.WHITE);

        //Elements
        Button loginButton = getLoginButton();
        EditText txtUserName = getUserName();
        txtUserName.setWidth(px);
        loginButton.setWidth(px);

        //Position definitions
        RelativeLayout.LayoutParams buttonDetails = getButtonDetails();
        RelativeLayout.LayoutParams userNameDetails = getUserNameDetails(loginButton.getId());

        //Add widget to layout
        loginLayout.addView(txtUserName,userNameDetails);
        loginLayout.addView(loginButton,buttonDetails);

        return loginLayout;
    }
    private RelativeLayout.LayoutParams getUserNameDetails(int aboveElementId){
        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams (
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Give rules to position widgets
        userNameDetails.addRule(RelativeLayout.ABOVE,aboveElementId);
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0,0,0,50);
        return userNameDetails;
    }

    private RelativeLayout.LayoutParams getButtonDetails(){
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams (
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Give rules to position widgets
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        return buttonDetails;
    }

    private EditText getUserName() {
        EditText txtUserName = new EditText(this);
        txtUserName.setId(Integer.parseInt("2"));
        txtUserName.setText(R.string.place_holder_username);
        return txtUserName;
    }

    private Button getLoginButton(){
        Button loginButton = new Button(this);
        loginButton.setHint(R.string.place_holder_login);
        loginButton.setTextColor(Color.WHITE);
        loginButton.setBackgroundColor(Color.GRAY);
        loginButton.setId(Integer.parseInt("1"));
        return loginButton;
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.i(TAG,"on start of main activity");
    }
}
