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

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.CourtAdapter;
import pe.edu.upc.partidon.Adapters.SectionCourtAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.CompaniesRepository;
import pe.edu.upc.partidon.datasource.CourtSectionRepository;
import pe.edu.upc.partidon.datasource.TeamRepository;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.CourtSection;

public class CourtListFragment extends Fragment {
        private static final String TAG = "CourtListFragment";
        private RecyclerView courtListRecyclerView;
        private CourtSectionRepository courtSectionRepository;


        public CourtListFragment() {
            // Required empty public constructor
        }

        // TODO: Rename and change types and number of parameters
        public static CourtListFragment newInstance() {
            CourtListFragment fragment = new CourtListFragment();
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_court_list,container,false);

            courtSectionRepository = new CourtSectionRepository(getContext());

            courtListRecyclerView = (RecyclerView) view.findViewById(R.id.courtListRecyclerView);
            courtListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            loadCourtsAsync();


            return view;
        }


         private void loadCourtsAsync(){
             int idCourt = getArguments().getInt("key_id");
            courtSectionRepository.getCourtSection(idCourt,new CourtSectionRepository.CourtSectionCallback() {
            @Override
            public void onComplete(List<CourtSection> courtSection) {
                courtListRecyclerView.setAdapter(new SectionCourtAdapter(getContext(), courtSection));
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
          });

         }

    }
