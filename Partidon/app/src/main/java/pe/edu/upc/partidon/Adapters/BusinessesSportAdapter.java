package pe.edu.upc.partidon.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.Activities.WallCourtActivity;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.BusinessesBySport;

/**
 * Created by Hector on 04/07/2017.
 */

public class BusinessesSportAdapter extends RecyclerView.Adapter<BusinessesSportAdapter.ViewHolder> {
    private Context context;
    private List<BusinessesBySport> businessesBySports;

    public BusinessesSportAdapter(Activity context, @NonNull List<BusinessesBySport> businessesBySports){
        this.context = context;
        this.businessesBySports = businessesBySports;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_court,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final BusinessesBySport businesses = businessesBySports.get(position);
        holder.nameTextView.setText(businesses.getCourt().getUser().getName());
        holder.locationTextView.setText(businesses.getCourt().getDistrict());
        holder.phoneTextView.setText(businesses.getCourt().getPhone());
        holder.courtContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, WallCourtActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("key_id",businesses.getCourt().getId());
                bundle.putInt("user_id",businesses.getCourt().getUser().getId());
                i.putExtras(bundle);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return businessesBySports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView phoneTextView;
        TextView locationTextView;
        View courtContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            phoneTextView = (TextView) itemView.findViewById(R.id.phoneTextView);
            locationTextView = (TextView) itemView.findViewById(R.id.locationTextView);
            courtContainer = itemView.findViewById(R.id.courtContainer);
        }
    }
}