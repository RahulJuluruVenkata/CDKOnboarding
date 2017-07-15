package com.cdk.onboarding.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.model.ticket.TicketModel;

import java.util.List;

public class TicketAdapter<T> extends ArrayAdapter<TicketModel>{
    public TicketAdapter(@NonNull Context context, List<TicketModel> ticketsList) {
        super(context, R.layout.activity_raise_ticket, ticketsList);
    }

    public TicketAdapter(@NonNull Context context, int resource, List<TicketModel> ticketsList) {
        super(context, R.layout.activity_raise_ticket, ticketsList);
    }

    public View getView(int position , View convertView , ViewGroup parent){
        LayoutInflater ticketInflater = LayoutInflater.from(getContext());
        View customTicketView = ticketInflater.inflate(R.layout.activity_raise_ticket,parent,false);

        TicketModel singleTicket = getItem(position);
        //TextView ticketText = (TextView) customTicketView.findViewById(R.id.txtView_ticket_details);
        ImageView ticketImage = (ImageView)customTicketView.findViewById(R.id.image_ticket);

       // ticketText.setText("Updated ticket");
        ticketImage.setImageResource(R.drawable.admin);

        return customTicketView;
    }
}
