package pe.edu.upc.partidon.Activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.fragments.SearchTeamFragment;
import pe.edu.upc.partidon.fragments.MatchScoreFragment;
import pe.edu.upc.partidon.models.Team;

public class TeamSearchActivity extends AppCompatActivity {


        private static final String TAG = "TeamSearchActivity";

        private SectionsPageAdapter mSectionsPagerAdapter;

        private ViewPager mViewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_team_search);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            setupViewPager(mViewPager);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);

            tabLayout.getTabAt(0).setIcon(R.drawable.soccer_item);
            tabLayout.getTabAt(1).setIcon(R.drawable.tennis_ball_item);
            tabLayout.getTabAt(2).setIcon(R.drawable.basketball_item);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }

        private void setupViewPager(ViewPager viewPager) {
            SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
            adapter.addFragment(SearchTeamFragment.newInstance(Team.Type.Soccer), "");
            adapter.addFragment(SearchTeamFragment.newInstance(Team.Type.Tennis), "");
            adapter.addFragment(SearchTeamFragment.newInstance(Team.Type.Basket), "");
            viewPager.setAdapter(adapter);
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

        /**
         * A placeholder fragment containing a simple view.
         */


    }