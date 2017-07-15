package com.cdk.onboarding.view.raise_ticket;

import android.os.Bundle;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.data.db.dao.helper.TicketsHelper;
import com.cdk.onboarding.view.base.CDKOnboardGenericActivity;

public class RaiseTicket extends CDKOnboardGenericActivity {

    private TicketsHelper ticketsHelper;

    public RaiseTicket(){
        ticketsHelper = TicketsHelper.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raise_ticket);

//        List<TicketModel> ticketsList = ticketsHelper.getListOfTickets();
//        ListAdapter ticketsAdapter = new TicketAdapter<TicketModel>(this,android.R.layout.activity_list_item,ticketsList);
//        ListView ticketsListView = (ListView)findViewById(R.id.txtView_ticket_details);
//        ticketsListView.setAdapter(ticketsAdapter);
//
//        ticketsListView.setOnItemClickListener(
//            new AdapterView.OnItemClickListener(){
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                    TicketModel ticket = (TicketModel)adapterView.getItemAtPosition(position);
//                }
//            }
//        );
    }
}
