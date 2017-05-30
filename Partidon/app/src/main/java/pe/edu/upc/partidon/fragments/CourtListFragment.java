package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.Adapters.SectionCourtAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.CourtSection;
import pe.edu.upc.partidon.models.Match;

public class CourtListFragment extends Fragment {
        private static final String TAG = "CourtListFragment";
        private RecyclerView courtListRecyclerView;


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

            courtListRecyclerView = (RecyclerView) view.findViewById(R.id.courtListRecyclerView);
            courtListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            courtListRecyclerView.setAdapter(new SectionCourtAdapter(getContext(),getCourtSection()));

            return view;
        }


        private List<CourtSection> getCourtSection(){
            List<CourtSection> results = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                CourtSection courts = new CourtSection();
                courts.setId(i);
                courts.setTitle("Cancha de Tenis N° " + i);
                courts.setChair("Si"+i);
                courts.setTipe("Artificial"+i);
                courts.setMetre("10 x "+i);
                courts.setPrice(i);
                courts.setSale(i);

                results.add(courts);
            }
            return results;
        }


    }
