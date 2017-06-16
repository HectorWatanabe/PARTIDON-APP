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

import pe.edu.upc.partidon.Adapters.NotificationAdapter;
import pe.edu.upc.partidon.Adapters.PlayerAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Notification;
import pe.edu.upc.partidon.models.Player;

public class NotificationActivity extends AppCompatActivity {


    private static final String TAG = "NotificationActivity";
    private RecyclerView notificationUserRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        notificationUserRecyclerView = (RecyclerView) findViewById(R.id.notificationUserRecyclerView);
        notificationUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notificationUserRecyclerView.setAdapter(new NotificationAdapter(this,getNotification()));
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

    private List<Notification> getNotification(){
        List<Notification> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Notification notifications = new Notification();
            notifications.setUserName("Maria Fernanda Segovia Chacón " + i);
            notifications.setUserNotification("Se a unido a uno de tus grupos " + i);
            results.add(notifications);
        }
        return results;
    }
}
