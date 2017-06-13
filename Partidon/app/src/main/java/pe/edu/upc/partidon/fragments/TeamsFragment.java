package pe.edu.upc.partidon.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pe.edu.upc.partidon.Activities.MatchSearchActivity;
import pe.edu.upc.partidon.Activities.TeamSearchActivity;
import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.Adapters.TeamAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.Team;

public class TeamsFragment extends Fragment {
    private static final String TAG = "NewFragment";
    private RecyclerView teamsRecyclerView;


    public TeamsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TeamsFragment newInstance() {
        TeamsFragment fragment = new TeamsFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams,container,false);
        FloatingActionMenu materialDesignFAM;
        com.github.clans.fab.FloatingActionButton floatingActionButtonTeam;
        com.github.clans.fab.FloatingActionButton floatingActionButtonTeamSearch;


        teamsRecyclerView = (RecyclerView) view.findViewById(R.id.teamsRecyclerView);
        teamsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        teamsRecyclerView.setAdapter(new TeamAdapter(getContext(),getTeam()));

        materialDesignFAM = (FloatingActionMenu) view.findViewById(R.id.menu);
        floatingActionButtonTeam = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.add_team);
        floatingActionButtonTeamSearch = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.button_team_search);

        floatingActionButtonTeamSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), TeamSearchActivity.class));

            }
        });

        return view;
    }


    private List<Team> getTeam(){
        List<Team> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Team teams = new Team();
            int type = new Random().nextInt(3)+1;
            teams.setTeamName("Team Name One " + i);
            teams.setAvailableSiteTeam(i);
            teams.setSport(type);
            results.add(teams);
        }
        return results;
    }


}
