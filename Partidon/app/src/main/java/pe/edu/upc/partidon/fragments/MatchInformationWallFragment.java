package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.NewsComments;

public class MatchInformationWallFragment extends Fragment {

        private static final String TAG = "MatchInformationWallFragment";
        private RecyclerView matchInformationWallsRecyclerView;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_match_information_wall,container,false);

            matchInformationWallsRecyclerView = (RecyclerView) view.findViewById(R.id.matchInformationWallsRecyclerView);
            matchInformationWallsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            matchInformationWallsRecyclerView.setAdapter(new NewsFeedAdapter(getContext(),getCourtCommnets()));



            return view;
        }

        @Override
        public void onResume() {
            super.onResume();
            matchInformationWallsRecyclerView.setAdapter(new NewsFeedAdapter(getContext(),getCourtCommnets()));

        }

        private List<NewsComments> getCourtCommnets(){
            List<NewsComments> results = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                NewsComments newsComments = new NewsComments();
                newsComments.setNameUser("Hector Chumpitaz Watanabe " + i);
                newsComments.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                        "labore et dolore magna aliqua. Un ullamco laboris nisi ut aliquip ex ea commodo consequat. " + i);
                results.add(newsComments);
            }
            return results;
        }


    }