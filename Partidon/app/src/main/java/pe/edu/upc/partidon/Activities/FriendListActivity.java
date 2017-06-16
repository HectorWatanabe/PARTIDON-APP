package pe.edu.upc.partidon.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.PlayerAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Player;

public class FriendListActivity extends AppCompatActivity {

    private static final String TAG = "FriendListActivity";
    private RecyclerView friendListRecyclerView;


    public FriendListActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        friendListRecyclerView = (RecyclerView) findViewById(R.id.friendListRecyclerView);
        friendListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        friendListRecyclerView.setAdapter(new PlayerAdapter(this,getPlayer()));
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
