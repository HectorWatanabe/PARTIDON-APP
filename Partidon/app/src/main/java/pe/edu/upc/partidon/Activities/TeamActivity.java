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

public class TeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        TextView title = (TextView) findViewById(R.id.teammessage);
        title.setText("Aqui Se Listaran los Equipos");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_news:
                        Intent intent_fields = new Intent(TeamActivity.this, MenuActivity.class);
                        startActivity(intent_fields);
                        break;
                    case R.id.navigation_match:
                        Intent intent_match = new Intent(TeamActivity.this, MatchActivity.class);
                        startActivity(intent_match);
                        break;
                    case R.id.navigation_comments:
                        break;
                    case R.id.navigation_teams:

                        break;
                    case R.id.navigation_fields:
                        Intent intentTeam = new Intent(TeamActivity.this, CourtActivity.class);
                        startActivity(intentTeam);
                        break;
                }


                return false;
            }
        });
    }
}
