package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Activities.MenuActivity;
import pe.edu.upc.partidon.Adapters.CourtAdapter;
import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;

public class BasketballSearchCourtFragment extends Fragment {
        private static final String TAG = "BasketballSearchCourtFragment";
        private RecyclerView basketballSearchCourtRecyclerView;



        public BasketballSearchCourtFragment() {
            // Required empty public constructor
        }



        // TODO: Rename and change types and number of parameters
        public static BasketballSearchCourtFragment newInstance() {
            BasketballSearchCourtFragment fragment = new BasketballSearchCourtFragment();
            return fragment;
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_basketball_search_court,container,false);



            basketballSearchCourtRecyclerView = (RecyclerView) view.findViewById(R.id.basketballSearchCourtRecyclerView);
            basketballSearchCourtRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            basketballSearchCourtRecyclerView.setAdapter(new CourtAdapter(getActivity(),getCourt()));



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