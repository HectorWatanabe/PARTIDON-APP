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

public class MatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        TextView title = (TextView) findViewById(R.id.matchmessage);
        title.setText("Aqui Se Listaran los Partidos");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_news:
                        Intent intent_fields = new Intent(MatchActivity.this, MenuActivity.class);
                        startActivity(intent_fields);
                        return true;
                    case R.id.navigation_match:
                        break;
                    case R.id.navigation_comments:
                        return true;
                    case R.id.navigation_teams:
                        Intent intentTeam = new Intent(MatchActivity.this, TeamActivity.class);
                        startActivity(intentTeam);
                        return true;
                    case R.id.navigation_fields:

                        Intent intent_match = new Intent(MatchActivity.this, CourtActivity.class);
                        startActivity(intent_match);
                        return true;
                }


                return false;
            }
        });

    }
}
