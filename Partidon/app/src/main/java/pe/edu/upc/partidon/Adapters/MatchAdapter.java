package pe.edu.upc.partidon.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.Match;

/**
 * Created by Desarrollo Infobox on 24/05/2017.
 */

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
        private Context context;
        private List<Match> matches;

        public MatchAdapter(Context context,@NonNull List<Match> matches){
            this.context = context;
            this.matches = matches;
        }

        @Override
        public MatchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MatchAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match,parent,false));
        }

        @Override
        public void onBindViewHolder(MatchAdapter.ViewHolder holder, int position) {
            holder.teamOneTextView.setText(matches.get(position).getTeamOne());
            holder.teamTwoTextView.setText(matches.get(position).getTeamTwo());
            holder.availableSiteNumberTextView.setText(matches.get(position).getAvailableSiteAsString());
        }

        @Override
        public int getItemCount() {
            return matches.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView teamOneTextView;
            TextView teamTwoTextView;
            TextView availableSiteNumberTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                teamOneTextView = (TextView) itemView.findViewById(R.id.teamOneTextView);
                teamTwoTextView = (TextView) itemView.findViewById(R.id.teamTwoTextView);
                availableSiteNumberTextView = (TextView) itemView.findViewById(R.id.availableSiteNumberTextView);
            }
        }
    }