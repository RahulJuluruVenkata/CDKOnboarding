package com.cdk.onboarding.cdkapplication.raise_ticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.cdkapplication.utilities.CDKMenuUtilities;
import com.cdk.onboarding.controller.TicketsController;

public class RaiseTicket extends AppCompatActivity {

    private TicketsController ticketsController;

    public RaiseTicket(){
        ticketsController = TicketsController.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_ticket);

//        List<Ticket> ticketsList = ticketsController.getListOfTickets();
//        ListAdapter ticketsAdapter = new ArrayAdapter<Ticket>(this,android.R.layout.activity_list_item,ticketsList);
//        ListView ticketsListView = (ListView)findViewById(R.id.txtView_ticket_details);
//        ticketsListView.setAdapter(ticketsAdapter);
//
//        ticketsListView.setOnItemClickListener(
//            new AdapterView.OnItemClickListener(){
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                    Ticket ticket = (Ticket)adapterView.getItemAtPosition(position);
//                }
//            }
//        );
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
