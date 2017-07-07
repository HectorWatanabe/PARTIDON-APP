package pe.edu.upc.partidon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import pe.edu.upc.partidon.Adapters.ScoreAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.ScoreRepository;
import pe.edu.upc.partidon.models.Score;


public class MatchScoreFragment extends Fragment {

    private static final String TAG = "MatchScoreFragment";
    private RecyclerView matchScoreRecyclerView;
    private ScoreRepository scoreRepository;

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

        scoreRepository = new ScoreRepository(getContext());

        matchScoreRecyclerView = (RecyclerView) view.findViewById(R.id.matchScoreRecyclerView);
        matchScoreRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadCourtsAsync();

        return view;
    }

    public void loadCourtsAsync(){
        int idMatch = getArguments().getInt("match_id");
        scoreRepository.getScoresMatch(idMatch, new ScoreRepository.ScoresCallback() {
            @Override
            public void onComplete(List<Score> scores) {

                matchScoreRecyclerView.setAdapter(new ScoreAdapter(getContext(),scores));
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
