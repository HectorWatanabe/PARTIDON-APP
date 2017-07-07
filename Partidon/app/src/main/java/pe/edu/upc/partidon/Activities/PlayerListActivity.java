package pe.edu.upc.partidon.Activities;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.PlayerAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.MembersTeamRepository;
import pe.edu.upc.partidon.datasource.PlayerRepository;
import pe.edu.upc.partidon.models.MemberTeam;
import pe.edu.upc.partidon.models.Player;

import android.view.MenuItem;
import android.widget.Toast;


public class PlayerListActivity extends AppCompatActivity {

    private static final String TAG = "PlayerListActivity";
    private RecyclerView playerListRecyclerView;
    private MembersTeamRepository membersTeamRepository;


    public PlayerListActivity() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        membersTeamRepository = new MembersTeamRepository(this);

        playerListRecyclerView = (RecyclerView) findViewById(R.id.playerListRecyclerView);
        playerListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadCourtsAsync();
    }

    private void loadCourtsAsync(){
        int idTeam = getIntent().getExtras().getInt("team_id");
        membersTeamRepository.getMembersTeam(idTeam ,new MembersTeamRepository.MembersTeamCallback(){
            @Override
            public void onComplete(List<MemberTeam> membersTeam) {

                playerListRecyclerView.setAdapter(new PlayerAdapter(getApplicationContext(),membersTeam));

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
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




}
