package com.cdk.onboarding.cdkapplication.raise_ticket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.cdkapplication.utilities.CDKMenuUtilities;

public class RaiseTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_ticket);
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
