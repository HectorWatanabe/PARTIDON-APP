package pe.edu.upc.partidon.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.MatchPublicationsRepository;
import pe.edu.upc.partidon.models.NewsComments;

public class MatchInformationWallFragment extends Fragment {

        private static final String TAG = "MatchInformationWallFragment";
        private RecyclerView matchInformationWallsRecyclerView;
        private MatchPublicationsRepository matchPublicationsRepository;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            matchPublicationsRepository = new MatchPublicationsRepository(getContext());
            View view = inflater.inflate(R.layout.fragment_match_information_wall,container,false);

            matchInformationWallsRecyclerView = (RecyclerView) view.findViewById(R.id.matchInformationWallsRecyclerView);
            matchInformationWallsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



            loadCourtsAsync();
            return view;
        }


    public void loadCourtsAsync(){
        int idMatch = getArguments().getInt("match_id");
        matchPublicationsRepository.getMatchPublications(idMatch, new MatchPublicationsRepository.MatchPublicationsCallback() {
            @Override
            public void onComplete(List<NewsComments> comments) {

                matchInformationWallsRecyclerView.setAdapter(new NewsFeedAdapter(getContext(),comments));
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }


    }