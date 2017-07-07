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
import pe.edu.upc.partidon.datasource.CourtPublicationRepository;
import pe.edu.upc.partidon.models.NewsComments;

public class WallCourtFragment extends Fragment {

    private static final String TAG = "WallCourtFragment";
    private RecyclerView wallCourtRecyclerView;
    private CourtPublicationRepository courtPublicationRepository;

    public WallCourtFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static WallCourtFragment newInstance() {
        WallCourtFragment fragment = new WallCourtFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        courtPublicationRepository = new CourtPublicationRepository(getContext());
        View view = inflater.inflate(R.layout.fragment_wall_court,container,false);

        wallCourtRecyclerView = (RecyclerView) view.findViewById(R.id.wallCourtRecyclerView);
        wallCourtRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        loadCourtsAsync();

        return view;
    }

    private void loadCourtsAsync(){
        int idCourt = getArguments().getInt("user_id");
            courtPublicationRepository.getCourtPublication(idCourt, new CourtPublicationRepository.CourtPublicationCallback() {
                @Override
                public void onComplete(List<NewsComments> courts) {

                    wallCourtRecyclerView.setAdapter(new NewsFeedAdapter(getContext(), courts));
                }

                @Override
                public void onError(String message) {
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            });
        }






}