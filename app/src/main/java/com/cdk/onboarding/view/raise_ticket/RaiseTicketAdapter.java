package com.cdk.onboarding.view.raise_ticket;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cdk.onboarding.cdkapplication.R;
import com.cdk.onboarding.model.TicketListData;

import java.util.List;

public class RaiseTicketAdapter extends RecyclerView.Adapter<RaiseTicketAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<TicketListData> data;
    private Context context;

    public RaiseTicketAdapter(Context context, List<TicketListData> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.ticketId.setText(data.get(position).getName());
        holder.ticketDescription.setText(data.get(position).getDescription());

        String images = data.get(position).getBackground();

        Glide.with(context)
                .load(images)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(true)
                .into(holder.background);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(TicketListData Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ticketId, ticketDescription;
        ImageView background;

        public ViewHolder(View itemView) {
            super(itemView);
            ticketId = (TextView) itemView.findViewById(R.id.city);
            ticketDescription = (TextView) itemView.findViewById(R.id.hotel);
            background = (ImageView) itemView.findViewById(R.id.image);

        }

        public void click(final TicketListData ticketListData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(ticketListData);
                }
            });
        }
    }
}
