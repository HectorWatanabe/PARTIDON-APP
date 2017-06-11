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
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Match;


public class SearchMatchFragment extends Fragment {
        private static final String TAG = "SearchMatchFragment";
        private RecyclerView SearchMatchRecyclerView;

        private static final String PARAM_TYPE = "PARAM_TYPE";



        public SearchMatchFragment() {
            // Required empty public constructor
        }


        public static SearchMatchFragment newInstance(){
        return newInstance(Match.Type.None);
    }
        // TODO: Rename and change types and number of parameters
        public static SearchMatchFragment newInstance(Match.Type filter) {
            SearchMatchFragment fragment = new SearchMatchFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(PARAM_TYPE,filter.getType());
            fragment.setArguments(bundle);
            return fragment;
        }

         private Match.Type filter = Match.Type.None;

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_search_match,container,false);

            if (getArguments() != null){
                int type = getArguments().getInt(PARAM_TYPE,-1);
                filter = Match.Type.from(type);
            }

            SearchMatchRecyclerView = (RecyclerView) view.findViewById(R.id.searchMatchRecyclerView);
            SearchMatchRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
            MatchAdapter adapter = new MatchAdapter(getContext(),getMatch());
            adapter.setFilter(filter);
            SearchMatchRecyclerView.setAdapter(adapter);

            return view;
        }

    public void onComplete(List<Match> matches){
        MatchAdapter adapter = new MatchAdapter(getContext(),getMatch());
        SearchMatchRecyclerView.setAdapter(adapter);
    }


    private List<Match> getMatch(){
        List<Match> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Match matches = new Match();
            int type = new Random().nextInt(3)+1;

            matches.setTeamOne("Team Name One " + i + " " + type);
            matches.setTeamTwo("Team Name Two " + i);
            matches.setAvailableSite(i);
            matches.setSport(type);
            results.add(matches);
        }
        return results;
    }

}
