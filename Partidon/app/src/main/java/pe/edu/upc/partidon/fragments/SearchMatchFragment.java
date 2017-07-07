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

import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.Adapters.TeamAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.MatchesRepository;
import pe.edu.upc.partidon.datasource.TeamRepository;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.models.Team;


public class SearchMatchFragment extends Fragment {
        private static final String TAG = "SearchMatchFragment";
        private RecyclerView SearchMatchRecyclerView;
        private MatchesRepository matchesRepository;

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

            matchesRepository = new MatchesRepository(getContext());

            if (getArguments() != null){
                int type = getArguments().getInt(PARAM_TYPE,-1);
                filter = Match.Type.from(type);
            }

            SearchMatchRecyclerView = (RecyclerView) view.findViewById(R.id.searchMatchRecyclerView);
            SearchMatchRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));


            loadCourtsAsync();

            return view;
        }


    private void loadCourtsAsync(){
        matchesRepository.getMatches(new MatchesRepository.MatchesCallback() {
            @Override
            public void onComplete(List<Match> matches) {

                MatchAdapter adapter = new MatchAdapter(getContext(),matches);
                adapter.setFilter(filter);
                SearchMatchRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
