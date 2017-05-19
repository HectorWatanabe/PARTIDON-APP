package pe.edu.upc.partidon.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.Activities.GoalsFragment;

public class MenuActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_news:
                    FragmentManager news_fn = getFragmentManager();
                    news_fn.beginTransaction().replace(R.id.content, new NewsFragment()).commit();
                    return true;
                case R.id.navigation_match:
                    FragmentManager goals_fn = getFragmentManager();
                    goals_fn.beginTransaction().replace(R.id.content, new GoalsFragment()).commit();

                    break;
                case R.id.navigation_comments:
                    break;
                case R.id.navigation_teams:
                    FragmentManager team_fn = getFragmentManager();
                    team_fn.beginTransaction().replace(R.id.content, new TeamFragment()).commit();
                    break;
                case R.id.navigation_fields:
                    FragmentManager court_fn = getFragmentManager();
                    court_fn.beginTransaction().replace(R.id.content, new CourtFragment()).commit();
                    break;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentManager news_fn = getFragmentManager();
        news_fn.beginTransaction().replace(R.id.content, new NewsFragment()).commit();
    }


}
