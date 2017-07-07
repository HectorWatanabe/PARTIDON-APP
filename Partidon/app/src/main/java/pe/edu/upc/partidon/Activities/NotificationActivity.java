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

import pe.edu.upc.partidon.Adapters.NotificationAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.NotificationRepository;
import pe.edu.upc.partidon.models.Notification;

public class NotificationActivity extends AppCompatActivity {


    private static final String TAG = "NotificationActivity";
    private RecyclerView notificationUserRecyclerView;

    private NotificationRepository notificationRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        notificationRepository = new NotificationRepository(this);

        notificationUserRecyclerView = (RecyclerView) findViewById(R.id.notificationUserRecyclerView);
        notificationUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadCourtsAsync();
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

    private void loadCourtsAsync(){
        SharedPreferences references = getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);

        notificationRepository.getNotifications(Integer.parseInt(references.getString("id_player",null)) ,new NotificationRepository.NotificationsCallback(){
            @Override
            public void onComplete(List<Notification> notifications) {


                notificationUserRecyclerView.setAdapter(new NotificationAdapter(getApplicationContext(),notifications));

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
