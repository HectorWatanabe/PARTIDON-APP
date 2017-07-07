package pe.edu.upc.partidon.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import pe.edu.upc.partidon.Adapters.FriendAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.FriendsRepository;
import pe.edu.upc.partidon.models.Friend;

public class FriendListActivity extends AppCompatActivity {

    private static final String TAG = "FriendListActivity";
    private RecyclerView friendListRecyclerView;
    private FriendsRepository friendsRepository;


    public FriendListActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        friendsRepository = new FriendsRepository(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        friendListRecyclerView = (RecyclerView) findViewById(R.id.friendListRecyclerView);
        friendListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadCourtsAsync();
    }

    private void loadCourtsAsync(){
        SharedPreferences references = getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        friendsRepository.getFriends(Integer.parseInt(references.getString("id_player",null)) ,new FriendsRepository.FriendsCallback(){
            @Override
            public void onComplete(List<Friend> friends) {

                friendListRecyclerView.setAdapter(new FriendAdapter(getApplicationContext(),friends));

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
