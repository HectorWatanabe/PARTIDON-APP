package pe.edu.upc.partidon.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.partidon.R;



public class CourtFragment extends Fragment {

    public CourtFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CourtFragment newInstance() {
        CourtFragment fragment = new CourtFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_court, container, false);
    }

}
