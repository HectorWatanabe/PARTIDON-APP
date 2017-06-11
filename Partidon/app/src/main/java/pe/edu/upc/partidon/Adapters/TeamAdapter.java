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

import pe.edu.upc.partidon.Activities.TeamActivity;
import pe.edu.upc.partidon.Activities.WallCourtActivity;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.Team;

/**
 * Created by Desarrollo Infobox on 24/05/2017.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private Context context;
    private List<Team> teams;
    private List<Team> filteredTeams;

    public TeamAdapter(Context context,@NonNull List<Team> teams){
        this.context = context;
        this.teams = teams;
        this.filteredTeams = teams;
    }

    public void setFilter(Team.Type filter){
        if (filter == Team.Type.None){
            filteredTeams = teams;
        }else{
            filteredTeams = new ArrayList<>();
            for(Team team : teams){
                if(team.getSport() == filter.getType())
                    filteredTeams.add(team);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TeamAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent,false));
    }

    @Override
    public void onBindViewHolder(TeamAdapter.ViewHolder holder, int position) {
        Team team = filteredTeams.get(position);
        holder.teamNameTextView.setText(team.getTeamName());
        holder.availableSiteNumberTeamTextView.setText(team.getAvailableSiteTeamAsString());
        holder.teamContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TeamActivity.class);
                context.startActivity(i);
            }
        });
        switch (team.getType()){
            case Basket: holder.sportTeamImageView.setImageResource(R.drawable.basketball); break;
            case Soccer: holder.sportTeamImageView.setImageResource(R.drawable.soccer_icon); break;
            case Tennis: holder.sportTeamImageView.setImageResource(R.drawable.tennis_ball_icon); break;
        }
       }
    @Override
    public int getItemCount() {
        return filteredTeams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teamNameTextView;
        TextView availableSiteNumberTeamTextView;
        ImageView sportTeamImageView;
        View teamContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            teamNameTextView = (TextView) itemView.findViewById(R.id.teamNameTextView);
            availableSiteNumberTeamTextView = (TextView) itemView.findViewById(R.id.availableSiteNumberTeamTextView);
            sportTeamImageView = (ImageView) itemView.findViewById(R.id.sportTeamImageView);
            teamContainer = itemView.findViewById(R.id.teamContainer);
        }
    }
}