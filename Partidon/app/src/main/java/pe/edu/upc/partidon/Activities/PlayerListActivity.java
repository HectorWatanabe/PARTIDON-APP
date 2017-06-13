package pe.edu.upc.partidon.Activities;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.NewsFeedAdapter;
import pe.edu.upc.partidon.Adapters.PlayerAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.NewsComments;
import pe.edu.upc.partidon.models.Player;
import pe.edu.upc.partidon.views.PostDialog;


public class PlayerListActivity extends AppCompatActivity {

    private static final String TAG = "PlayerListActivity";
    private RecyclerView playerListRecyclerView;


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


        playerListRecyclerView = (RecyclerView) findViewById(R.id.playerListRecyclerView);
        playerListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        playerListRecyclerView.setAdapter(new PlayerAdapter(this,getPlayer()));


    }




     private List<Player> getPlayer(){
        List<Player> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Player players = new Player();
            players.setName("Maria Fernanda Segovia Chacón " + i);
            results.add(players);
        }
        return results;
    }


}
