package com.cdk.onboarding.view.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.util.CDKMenuUtilities;

public class CDKOnboardGenericActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdkgeneric);
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
        CDKMenuUtilities.startActivity(this,i,item);
        return super.onOptionsItemSelected(item);
    }
}
