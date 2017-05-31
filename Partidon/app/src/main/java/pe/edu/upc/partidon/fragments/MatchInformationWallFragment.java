package pe.edu.upc.partidon.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.partidon.R;


public class MatchInformationWallFragment extends Fragment {

    private static final String TAG = "MatchInformationWallFragment";

    public MatchInformationWallFragment() {
        // Required empty public constructor
    }

    public static MatchInformationWallFragment newInstance() {
        MatchInformationWallFragment fragment = new MatchInformationWallFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_information_wall, container, false);
    }


}
