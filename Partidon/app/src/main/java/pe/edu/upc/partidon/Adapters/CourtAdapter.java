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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.Activities.WallCourtActivity;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;

/**
 * Created by user on 22/05/2017.
 */

public class CourtAdapter extends RecyclerView.Adapter<CourtAdapter.ViewHolder> {
        private Context context;
        private List<Court> courts;

        public CourtAdapter(Activity context, @NonNull List<Court> courts){
            this.context = context;
            this.courts = courts;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_court,parent,false));
        }

        @Override
        public void onBindViewHolder(CourtAdapter.ViewHolder holder, int position) {
            final Court court = courts.get(position);
            holder.nameTextView.setText(court.getUser().getName());
            holder.locationTextView.setText(court.getDistrict());
            holder.phoneTextView.setText(court.getPhone());

            switch(court.getUser().getIcon_image())
            {
                case "default_companies_1": holder.photoImageView.setImageResource(R.drawable.default_companies_1); break;
                case "default_companies_2": holder.photoImageView.setImageResource(R.drawable.default_companies_2); break;
                case "default_companies_3": holder.photoImageView.setImageResource(R.drawable.default_companies_3); break;
                default: holder.photoImageView.setImageResource(R.drawable.all); break;
            }
            holder.courtContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, WallCourtActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_id",court.getId());
                    bundle.putInt("user_id",court.getUser().getId());
                    i.putExtras(bundle);
                    context.startActivity(i);
                }
            });
        }

        @Override
        public int getItemCount() {
            return courts.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameTextView;
            TextView phoneTextView;
            TextView locationTextView;
            ImageView photoImageView;
            View courtContainer;

            public ViewHolder(View itemView) {
                super(itemView);
                nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
                phoneTextView = (TextView) itemView.findViewById(R.id.phoneTextView);
                locationTextView = (TextView) itemView.findViewById(R.id.locationTextView);
                photoImageView =(ImageView) itemView.findViewById(R.id.photoImageView);
                courtContainer = itemView.findViewById(R.id.courtContainer);
            }
        }
    }