package pe.edu.upc.partidon.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Activities.MatchWallActivity;
import pe.edu.upc.partidon.Activities.TeamActivity;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.Match;

import static pe.edu.upc.partidon.models.Match.Type.Basket;

/**
 * Created by Desarrollo Infobox on 24/05/2017.
 */

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
        private Context context;
        private List<Match> matches;
        private List<Match> filteredMatches;



        public MatchAdapter(Context context,@NonNull List<Match> matches){
            this.context = context;
            this.matches = matches;
            this.filteredMatches = matches;
        }

        public void setFilter(Match.Type filter){
            if (filter == Match.Type.None){
                filteredMatches = matches;
            }else{
                filteredMatches = new ArrayList<>();
                for(Match match : matches){
                    if(match.getSport() == filter.getType())
                        filteredMatches.add(match);
                }
            }
            notifyDataSetChanged();
        }

        @Override
        public MatchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MatchAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match,parent,false));
        }

        @Override
        public void onBindViewHolder(MatchAdapter.ViewHolder holder, int position) {
            Match match = filteredMatches.get(position);
            holder.teamOneTextView.setText(match.getTeamOne());
            holder.teamTwoTextView.setText(match.getTeamTwo());
            holder.availableSiteNumberTextView.setText(match.getAvailableSiteAsString());
            holder.matchContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, MatchWallActivity.class);
                    context.startActivity(i);
                           }
            });

            switch (match.getType()){
                case Basket: holder.sportMatchImageView.setImageResource(R.drawable.basketball); break;
                case Soccer: holder.sportMatchImageView.setImageResource(R.drawable.soccer_icon); break;
                case Tennis: holder.sportMatchImageView.setImageResource(R.drawable.tennis_ball_icon); break;
            }

        }

        @Override
        public int getItemCount() {
            return filteredMatches.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView teamOneTextView;
            TextView teamTwoTextView;
            TextView availableSiteNumberTextView;
            View matchContainer;
            ImageView sportMatchImageView;

            public ViewHolder(View itemView) {
                super(itemView);
                teamOneTextView = (TextView) itemView.findViewById(R.id.teamOneTextView);
                teamTwoTextView = (TextView) itemView.findViewById(R.id.teamTwoTextView);
                sportMatchImageView = (ImageView) itemView.findViewById(R.id.sportMatchImageView);
                availableSiteNumberTextView = (TextView) itemView.findViewById(R.id.availableSiteNumberTextView);
                matchContainer = itemView.findViewById(R.id.matchContainer);
            }
        }
    }