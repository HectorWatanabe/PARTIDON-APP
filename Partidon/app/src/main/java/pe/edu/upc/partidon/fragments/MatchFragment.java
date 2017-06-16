package pe.edu.upc.partidon.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pe.edu.upc.partidon.Activities.MatchCreateActivity;
import pe.edu.upc.partidon.Activities.MatchSearchActivity;
import pe.edu.upc.partidon.Activities.MenuActivity;
import pe.edu.upc.partidon.Adapters.CourtAdapter;
import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.Match;


public class MatchFragment extends Fragment {
    private static final String TAG = "MatchFragment";
    private RecyclerView matchRecyclerView;
    private FloatingActionMenu menu;


    public MatchFragment() {
        // Required empty public constructor
    }

    public static MatchFragment newInstance(){
        return newInstance(Match.Type.None);
    }

    public static MatchFragment newInstance(Match.Type filter) {
        MatchFragment fragment = new MatchFragment();

        return fragment;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_search){
            //Do whatever you want to do
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match,container,false);
        FloatingActionMenu materialDesignFAM;
        com.github.clans.fab.FloatingActionButton floatingActionButtonSearch;
        com.github.clans.fab.FloatingActionButton floatingActionButtonCreateMatch;



        matchRecyclerView = (RecyclerView) view.findViewById(R.id.matchesRecyclerView);
        matchRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        matchRecyclerView.setAdapter(new MatchAdapter(getContext(),getMatch()));

        materialDesignFAM = (FloatingActionMenu) view.findViewById(R.id.menu);
        floatingActionButtonCreateMatch = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.add_match);
        floatingActionButtonSearch = (com.github.clans.fab.FloatingActionButton) view.findViewById(R.id.button_search);

        floatingActionButtonSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), MatchSearchActivity.class));

            }
        });


        floatingActionButtonCreateMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), MatchCreateActivity.class));

            }
        });

        setHasOptionsMenu(true);

        return view;
    }




    private List<Match> getMatch(){
        List<Match> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Match matches = new Match();
            int type = new Random().nextInt(3)+1;

            matches.setTeamOne("Team Name One " + i + " " + type);
            matches.setTeamTwo("Team Name Two " + i);
            matches.setAvailableSite(i);
            matches.setSport(type);
            results.add(matches);
        }
        return results;
    }




}
