package pe.edu.upc.partidon.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

import pe.edu.upc.partidon.Activities.MatchCreateActivity;
import pe.edu.upc.partidon.Activities.MatchSearchActivity;
import pe.edu.upc.partidon.Adapters.MatchAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.MatchesOfPlayerRepository;
import pe.edu.upc.partidon.models.Match;


public class MatchFragment extends Fragment {
    private static final String TAG = "MatchFragment";
    private RecyclerView matchRecyclerView;
    private FloatingActionMenu menu;
    private MatchesOfPlayerRepository matchesOfPlayerRepository;
    private static final String PARAM_TYPE = "PARAM_TYPE";


    public MatchFragment() {
        // Required empty public constructor
    }




    public static MatchFragment newInstance() {
        MatchFragment fragment = new MatchFragment();

        return fragment;
    }

    private Match.Type filter = Match.Type.None;

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

        matchesOfPlayerRepository = new MatchesOfPlayerRepository(getContext());


        if (getArguments() != null){
            int type = getArguments().getInt(PARAM_TYPE,-1);
            filter = Match.Type.from(type);
        }

        FloatingActionMenu materialDesignFAM;
        com.github.clans.fab.FloatingActionButton floatingActionButtonSearch;
        com.github.clans.fab.FloatingActionButton floatingActionButtonCreateMatch;



        matchRecyclerView = (RecyclerView) view.findViewById(R.id.matchesRecyclerView);
        matchRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
      //  matchRecyclerView.setAdapter(new MatchAdapter(getContext(),getMatch()));

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

                startActivityForResult(new Intent(v.getContext(), MatchCreateActivity.class),7);

            }
        });

        setHasOptionsMenu(true);

        loadMatchesAsync();
        return view;
    }


    private void loadMatchesAsync(){
        matchesOfPlayerRepository.getMatchesOfPlayer(new MatchesOfPlayerRepository.MatchesOfPlayerCallback() {
            @Override
            public void onComplete(List<Match> matches) {

                MatchAdapter adapter = new MatchAdapter(getContext(),matches);
                adapter.setFilter(filter);
                matchRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 7 && resultCode == Activity.RESULT_OK){
            loadMatchesAsync();
        }
    }







}
