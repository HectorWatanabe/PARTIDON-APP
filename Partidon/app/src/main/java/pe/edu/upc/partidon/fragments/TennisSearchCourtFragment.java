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

import pe.edu.upc.partidon.Adapters.BusinessesSportAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.BusinessesSportRepository;
import pe.edu.upc.partidon.models.BusinessesBySport;

public class TennisSearchCourtFragment extends Fragment {
        private static final String TAG = "TennisSearchCourtFragment";
        private RecyclerView tennisSearchCourtRecyclerView;

        private BusinessesSportRepository businessesSportRepository;



        public TennisSearchCourtFragment() {
            // Required empty public constructor
        }



        // TODO: Rename and change types and number of parameters
        public static TennisSearchCourtFragment newInstance() {
            TennisSearchCourtFragment fragment = new TennisSearchCourtFragment();
            return fragment;
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_tennis_search_court,container,false);
            businessesSportRepository = new BusinessesSportRepository(getContext());



            tennisSearchCourtRecyclerView = (RecyclerView) view.findViewById(R.id.tennisSearchCourtRecyclerView);
            tennisSearchCourtRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            loadCourtsAsync();
            return view;
        }


        private void loadCourtsAsync(){
            businessesSportRepository.getBusinessesSport(3,new BusinessesSportRepository.BusinessesSportCallback() {
                @Override
                public void onComplete(List<BusinessesBySport> Businesses) {

                    tennisSearchCourtRecyclerView.setAdapter(new BusinessesSportAdapter(getActivity(),Businesses));

                }

                @Override
                public void onError(String message) {
                    Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
