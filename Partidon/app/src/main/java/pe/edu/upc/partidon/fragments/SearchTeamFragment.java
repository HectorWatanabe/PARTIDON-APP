package pe.edu.upc.partidon.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.CourtAdapter;
import pe.edu.upc.partidon.Adapters.TeamAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.CompaniesRepository;
import pe.edu.upc.partidon.datasource.TeamRepository;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.Team;

public class SearchTeamFragment extends Fragment {
        private static final String TAG = "SearchTeamFragment";
        private RecyclerView searchTeamRecyclerView;
        private TeamRepository teamRepository;

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

            teamRepository = new TeamRepository(getContext());

            if (getArguments() != null){
                int type = getArguments().getInt(PARAM_TYPE,-1);
                filter = Team.Type.from(type);
            }

            searchTeamRecyclerView = (RecyclerView) view.findViewById(R.id.searchTeamRecyclerView);
            searchTeamRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));



            loadCourtsAsync();

            return view;
        }


    private void loadCourtsAsync(){
        teamRepository.getTeams(new TeamRepository.TeamsCallback() {
            @Override
            public void onComplete(List<Team> teams) {
                TeamAdapter adapter = new TeamAdapter(getContext(),teams);
                adapter.setFilter(filter);
                searchTeamRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    }