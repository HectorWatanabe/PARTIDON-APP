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

public class WallCourtFragment extends Fragment {

    private static final String TAG = "WallCourtFragment";
    private RecyclerView wallCourtRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wall_court,container,false);

        wallCourtRecyclerView = (RecyclerView) view.findViewById(R.id.wallCourtRecyclerView);
        wallCourtRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        wallCourtRecyclerView.setAdapter(new NewsFeedAdapter(getContext(),getCourtCommnets()));



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        wallCourtRecyclerView.setAdapter(new NewsFeedAdapter(getContext(),getCourtCommnets()));

    }

    private List<NewsComments> getCourtCommnets(){
        List<NewsComments> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            NewsComments newsComments = new NewsComments();
            newsComments.setNameUser("Maria Fernanda Segovia Chacón " + i);
            newsComments.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                    "labore et dolore magna aliqua. Un ullamco laboris nisi ut aliquip ex ea commodo consequat. " + i);
            results.add(newsComments);
        }
        return results;
    }


}