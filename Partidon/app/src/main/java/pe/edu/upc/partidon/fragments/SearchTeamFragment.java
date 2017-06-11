package pe.edu.upc.partidon.fragments;

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
import java.util.Random;

import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.Adapters.TeamAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.Team;

public class SearchTeamFragment extends Fragment {
        private static final String TAG = "SearchTeamFragment";
        private RecyclerView searchTeamRecyclerView;

        private static final String PARAM_TYPE = "PARAM_TYPE";

        public SearchTeamFragment() {
            // Required empty public constructor
        }


         public static SearchTeamFragment newInstance(){
        return newInstance(Team.Type.None);
    }
        // TODO: Rename and change types and number of parameters
        public static SearchTeamFragment newInstance(Team.Type filter) {
            SearchTeamFragment fragment = new SearchTeamFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(PARAM_TYPE,filter.getType());
            fragment.setArguments(bundle);
            return fragment;
        }

        private Team.Type filter = Team.Type.None;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_search_team,container,false);

            if (getArguments() != null){
                int type = getArguments().getInt(PARAM_TYPE,-1);
                filter = Team.Type.from(type);
            }

            searchTeamRecyclerView = (RecyclerView) view.findViewById(R.id.searchTeamRecyclerView);
            searchTeamRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            TeamAdapter adapter = new TeamAdapter(getContext(),getTeam());
            adapter.setFilter(filter);
            searchTeamRecyclerView.setAdapter(adapter);


            return view;
        }

    public void onComplete(List<Match> matches){
        TeamAdapter adapter = new TeamAdapter(getContext(),getTeam());
        searchTeamRecyclerView.setAdapter(adapter);
    }

    private List<Team> getTeam(){
        List<Team> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Team teams = new Team();
            int type = new Random().nextInt(3)+1;
            teams.setTeamName("Team Name One " + i);
            teams.setSport(type);
            teams.setAvailableSiteTeam(i);

            results.add(teams);
        }
        return results;
    }

    }