package pe.edu.upc.partidon.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

import pe.edu.upc.partidon.Activities.TeamCreatActivity;
import pe.edu.upc.partidon.Activities.TeamSearchActivity;
import pe.edu.upc.partidon.Adapters.TeamAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.TeamsOfPlayerRepository;
import pe.edu.upc.partidon.models.Team;

public class TeamsFragment extends Fragment {
    private static final String TAG = "TeamsFragment";
    private RecyclerView teamsRecyclerView;
    private static final String PARAM_TYPE = "PARAM_TYPE";
    private TeamsOfPlayerRepository teamsOfPlayerRepository;



    public TeamsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TeamsFragment newInstance() {
        TeamsFragment fragment = new TeamsFragment();
        return fragment;
    }

    private Team.Type filter = Team.Type.None;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams,container,false);

        teamsOfPlayerRepository = new TeamsOfPlayerRepository(getContext());

        if (getArguments() != null){
            int type = getArguments().getInt(PARAM_TYPE,-1);
            filter = Team.Type.from(type);
        }

        FloatingActionMenu materialDesignFAM;
        com.github.clans.fab.FloatingActionButton floatingActionButtonTeam;
        com.github.clans.fab.FloatingActionButton floatingActionButtonTeamSearch;


        teamsRecyclerView = (RecyclerView) view.findViewById(R.id.teamsRecyclerView);
        teamsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        //teamsRecyclerView.setAdapter(new TeamAdapter(getContext(),getTeam()));

        materialDesignFAM = (FloatingActionMenu) view.findViewById(R.id.menu);
        floatingActionButtonTeam = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.add_team);
        floatingActionButtonTeamSearch = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.button_team_search);

        floatingActionButtonTeamSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), TeamSearchActivity.class));

            }
        });

        floatingActionButtonTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivityForResult(new Intent(v.getContext(), TeamCreatActivity.class),7);

            }
        });

        loadTeamsOfPlayersAsync();
        return view;
    }


    public void loadTeamsOfPlayersAsync(){
        teamsOfPlayerRepository.getTeamOfPlayer(new TeamsOfPlayerRepository.TeamOfPlayerCallback() {
            @Override
            public void onComplete(List<Team> teams) {
                TeamAdapter adapter = new TeamAdapter(getContext(),teams);
                adapter.setFilter(filter);
                teamsRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 7 && resultCode == Activity.RESULT_OK){
            loadTeamsOfPlayersAsync();
        }
    }
}
