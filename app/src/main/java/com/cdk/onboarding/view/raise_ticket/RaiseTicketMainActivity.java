package com.cdk.onboarding.view.raise_ticket;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.model.TicketListData;
import com.cdk.onboarding.model.TicketsListResponse;
import com.cdk.onboarding.networking.services.RaiseTicketService;
import com.cdk.onboarding.view.base.CDKOnboardGenericActivity;
import com.cdk.onboarding.view.sample.HomePresenter;

import javax.inject.Inject;

public class RaiseTicketMainActivity extends CDKOnboardGenericActivity implements RaiseTicketView{
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    private RecyclerView list;
    ProgressBar progressBar;

    @Inject
    public RaiseTicketService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        renderView();
        init();

        RaiseTicketPresenter presenter = new RaiseTicketPresenter(service, this);
        presenter.getTicketsList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_raise_ticket);

        //binding view to objects
        list = (RecyclerView) findViewById(R.id.list);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        spinner = (Spinner)findViewById(R.id.spinner_txt_type) ;

        //code related to spinner
        adapter = ArrayAdapter.createFromResource(this,R.array.ticket_types,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(),adapterView.getItemIdAtPosition(i) + " selected",Toast.LENGTH_LONG);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getListOfTickets(TicketsListResponse ticketsListResponse, String associateId) {
        RaiseTicketAdapter adapter = new RaiseTicketAdapter(getApplicationContext(),ticketsListResponse.getData(),
        new RaiseTicketAdapter.OnItemClickListener(){
            @Override
            public void onClick(TicketListData Item) {
                Toast.makeText(getApplicationContext(), Item.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
