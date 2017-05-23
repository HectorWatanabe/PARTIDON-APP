package pe.edu.upc.partidon.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.CourtAdapter;
import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.NewsComments;


public class CourtFragment extends Fragment {
    private static final String TAG = "NewFragment";
    private RecyclerView courtRecyclerView;


    public CourtFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CourtFragment newInstance() {
        CourtFragment fragment = new CourtFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_court,container,false);

        courtRecyclerView = (RecyclerView) view.findViewById(R.id.courtsRecyclerView);
        courtRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        courtRecyclerView.setAdapter(new CourtAdapter(getContext(),getCourt()));

        return view;
    }


    private List<Court> getCourt(){
        List<Court> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Court courts = new Court();
            courts.setTitle("Title " + i);
            courts.setId(i);
            courts.setPrice(i);
            courts.setDistrit("Distrito"+i);

            results.add(courts);
        }
        return results;
    }


}
