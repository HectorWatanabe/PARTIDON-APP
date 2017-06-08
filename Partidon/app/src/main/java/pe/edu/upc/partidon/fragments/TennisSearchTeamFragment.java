package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.Adapters.TeamAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.Team;

public class TennisSearchTeamFragment extends Fragment {
        private static final String TAG = "TennisSearchTeamFragment";
        private RecyclerView tennisSearchTeamRecyclerView;



        public TennisSearchTeamFragment() {
            // Required empty public constructor
        }



        // TODO: Rename and change types and number of parameters
        public static TennisSearchTeamFragment newInstance() {
            TennisSearchTeamFragment fragment = new TennisSearchTeamFragment();
            return fragment;
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_tennis_search_team,container,false);



            tennisSearchTeamRecyclerView = (RecyclerView) view.findViewById(R.id.tennisSearchTeamRecyclerView);
            tennisSearchTeamRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            tennisSearchTeamRecyclerView.setAdapter(new TeamAdapter(getContext(),getTeam()));


            return view;
        }


    private List<Team> getTeam(){
        List<Team> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Team teams = new Team();
            teams.setTeamName("Team Name One " + i);
            teams.setAvailableSiteTeam(i);

            results.add(teams);
        }
        return results;
    }

    }
