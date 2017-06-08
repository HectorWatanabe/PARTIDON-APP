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

import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Match;


public class TennisSearchMatchFragment extends Fragment {
        private static final String TAG = "TennisSearchMatchFragment";
        private RecyclerView tennisSearchMatchRecyclerView;



        public TennisSearchMatchFragment() {
            // Required empty public constructor
        }



        // TODO: Rename and change types and number of parameters
        public static TennisSearchMatchFragment newInstance() {
            TennisSearchMatchFragment fragment = new TennisSearchMatchFragment();
            return fragment;
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_tennis_search_score,container,false);



            tennisSearchMatchRecyclerView = (RecyclerView) view.findViewById(R.id.tennisSearchMatchRecyclerView);
            tennisSearchMatchRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            tennisSearchMatchRecyclerView.setAdapter(new MatchAdapter(getContext(),getMatch()));


            return view;
        }


        private List<Match> getMatch(){
            List<Match> results = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Match matches = new Match();
                matches.setTeamOne("Team Name One " + i);
                matches.setTeamTwo("Team Name Two " + i);
                matches.setAvailableSite(i);

                results.add(matches);
            }
            return results;
        }

    }
