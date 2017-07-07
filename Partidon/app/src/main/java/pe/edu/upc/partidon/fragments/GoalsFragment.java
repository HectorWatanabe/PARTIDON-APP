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
import pe.edu.upc.partidon.Adapters.ScoreAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.NewsComments;
import pe.edu.upc.partidon.models.Score;


public class GoalsFragment extends Fragment {
    private static final String TAG = "GoalsFragment";
    private RecyclerView goalsGeneralRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goals,container,false);

        goalsGeneralRecyclerView = (RecyclerView) view.findViewById(R.id.goalsGeneralRecyclerView);
        goalsGeneralRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        goalsGeneralRecyclerView.setAdapter(new ScoreAdapter(getContext(),getGoals()));



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        goalsGeneralRecyclerView.setAdapter(new ScoreAdapter(getContext(),getGoals()));

    }

    private List<Score> getGoals(){
        List<Score> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Score scores = new Score();
            results.add(scores);
        }
        return results;
    }
}