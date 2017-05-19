package pe.edu.upc.partidon.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.partidon.R;

public class CourtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court);


        TextView title = (TextView) findViewById(R.id.courtmessage);
        title.setText("Aqui Se Listaran las Canchas");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(5);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_news:
                        Intent intent_fields = new Intent(CourtActivity.this, MenuActivity.class);
                        startActivity(intent_fields);
                        return true;
                    case R.id.navigation_match:
                        Intent intent_match = new Intent(CourtActivity.this, MatchActivity.class);
                        startActivity(intent_match);
                        break;
                    case R.id.navigation_comments:
                        return true;
                    case R.id.navigation_teams:
                        Intent intentTeam = new Intent(CourtActivity.this, TeamActivity.class);
                        startActivity(intentTeam);
                        return true;
                    case R.id.navigation_fields:

                        return true;
                }


                return false;
            }
        });


    }
}
