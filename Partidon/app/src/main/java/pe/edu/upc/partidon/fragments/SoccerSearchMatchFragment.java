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


public class SoccerSearchMatchFragment extends Fragment {
        private static final String TAG = "SoccerSearchMatchFragment";
        private RecyclerView soccerSearchMatchRecyclerView;



        public SoccerSearchMatchFragment() {
            // Required empty public constructor
        }



        // TODO: Rename and change types and number of parameters
        public static SoccerSearchMatchFragment newInstance() {
            SoccerSearchMatchFragment fragment = new SoccerSearchMatchFragment();
            return fragment;
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_soccer_search_match,container,false);



            soccerSearchMatchRecyclerView = (RecyclerView) view.findViewById(R.id.soccerSearchMatchRecyclerView);
            soccerSearchMatchRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            soccerSearchMatchRecyclerView.setAdapter(new MatchAdapter(getContext(),getMatch()));


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
