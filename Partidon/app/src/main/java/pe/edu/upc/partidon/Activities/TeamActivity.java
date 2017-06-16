package pe.edu.upc.partidon.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.UserRepository;
import pe.edu.upc.partidon.fragments.UserFragment;
import pe.edu.upc.partidon.models.NewsComments;
import pe.edu.upc.partidon.models.User;
import pe.edu.upc.partidon.views.PostDialog;

public class TeamActivity extends AppCompatActivity {


    private static final String TAG = "TeamActivity";
    private RecyclerView teamWallRecyclerView;
    private FloatingActionMenu menu;


    public TeamActivity() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TeamActivity newInstance() {
        TeamActivity fragment = new TeamActivity();
        return fragment;
    }


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);


        com.github.clans.fab.FloatingActionButton floatingActionButtonPlayersTeam;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        menu = (FloatingActionMenu) findViewById(R.id.menuUser);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        teamWallRecyclerView = (RecyclerView) findViewById(R.id.teamWallRecyclerView);
        teamWallRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamWallRecyclerView.setAdapter(new NewsFeedAdapter(this,getUserComment()));

        floatingActionButtonPlayersTeam = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.view_player);

        floatingActionButtonPlayersTeam.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(v.getContext(), PlayerListActivity.class));

            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if( id == android.R.id.home){
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    public void createTeamPost(View view){
        PostDialog.show(this, new PostDialog.Callback() {
            @Override
            public void onComplete(String content) {
                Toast.makeText(getApplicationContext(),content,Toast.LENGTH_SHORT).show();
                menu.close(true);
            }

            @Override
            public void onClose() {
                menu.close(true);
            }
        });
    }


    private List<NewsComments> getUserComment(){
        List<NewsComments> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            NewsComments newsComments = new NewsComments();
            newsComments.setNameUser("Maria Fernanda Segovia Chacón " + i);
            newsComments.setComment("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut " +
                    "labore et dolore magna aliqua. Un ullamco laboris nisi ut aliquip ex ea commodo consequat. " + i);
            results.add(newsComments);
        }
        return results;
    }



}
