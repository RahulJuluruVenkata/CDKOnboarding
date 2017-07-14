package com.cdk.onboarding.cdkapplication.about_cdk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.cdkapplication.utilities.CDKMenuUtilities;

public class AboutCDK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_cdk);
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
