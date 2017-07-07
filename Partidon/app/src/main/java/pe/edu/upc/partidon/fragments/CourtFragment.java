package pe.edu.upc.partidon.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import pe.edu.upc.partidon.Activities.CourtSearchActivity;
import pe.edu.upc.partidon.Adapters.CourtAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.BusinessesCompanyRepository;
import pe.edu.upc.partidon.datasource.CompaniesRepository;
import pe.edu.upc.partidon.models.Court;


public class CourtFragment extends Fragment {
    private static final String TAG = "NewFragment";
    private RecyclerView courtRecyclerView;

    private CompaniesRepository courtRepository;
    private BusinessesCompanyRepository businessesCompanyRepository;

    private ImageView futbolImageView;
    private ImageView basketImageView;
    private ImageView tennisImageView;

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

        courtRepository = new CompaniesRepository(getContext());
        businessesCompanyRepository = new BusinessesCompanyRepository(getContext());

        courtRecyclerView = (RecyclerView) view.findViewById(R.id.courtsRecyclerView);
        courtRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.search_button_court);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), CourtSearchActivity.class));
            }
        });

        loadCourtsAsync();
        return view;
    }



    private void loadCourtsAsync(){
        courtRepository.getCourts(new CompaniesRepository.CourtsCallback() {
            @Override
            public void onComplete(List<Court> courts) {
                courtRecyclerView.setAdapter(new CourtAdapter(getActivity(), courts));

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }






}
