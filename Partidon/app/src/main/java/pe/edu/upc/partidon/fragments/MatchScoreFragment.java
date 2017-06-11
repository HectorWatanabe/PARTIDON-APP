package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.Adapters.ScoreAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Score;


public class MatchScoreFragment extends Fragment {

    private static final String TAG = "MatchScoreFragment";
    private RecyclerView matchScoreRecyclerView;

    public MatchScoreFragment() {
        // Required empty public constructor
    }

    public static MatchScoreFragment newInstance() {
        MatchScoreFragment fragment = new MatchScoreFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_score, container, false);

        matchScoreRecyclerView = (RecyclerView) view.findViewById(R.id.matchScoreRecyclerView);
        matchScoreRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        matchScoreRecyclerView.setAdapter(new ScoreAdapter(getContext(),getGoals()));
        return view;
    }

    private List<Score> getGoals(){
        List<Score> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Score scores = new Score();
            scores.setUser_name("Maria Fernanda Segovia Chacón " + i);
            scores.setTitle_match("Universidad Vs Instituto " + i);
            results.add(scores);
        }
        return results;
    }


}
