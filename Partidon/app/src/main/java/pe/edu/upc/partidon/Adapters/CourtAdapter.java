package pe.edu.upc.partidon.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.NewsComments;

/**
 * Created by user on 22/05/2017.
 */

public class CourtAdapter extends RecyclerView.Adapter<CourtAdapter.ViewHolder> {
        private Context context;
        private List<Court> courts;

        public CourtAdapter(Context context,@NonNull List<Court> courts){
            this.context = context;
            this.courts = courts;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_court,parent,false));
        }

        @Override
        public void onBindViewHolder(CourtAdapter.ViewHolder holder, int position) {
            Court court = courts.get(position);
            holder.nameTextView.setText(court.getTitle());
            holder.locationTextView.setText(court.getDistrit());
            holder.priceTextView.setText(court.getPriceAsString());
        }

        @Override
        public int getItemCount() {
            return courts.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nameTextView;
            TextView priceTextView;
            TextView locationTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
                priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
                locationTextView = (TextView) itemView.findViewById(R.id.locationTextView);
            }
        }
    }