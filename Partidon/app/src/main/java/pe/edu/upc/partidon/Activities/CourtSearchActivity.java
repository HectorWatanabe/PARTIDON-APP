package pe.edu.upc.partidon.Activities;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.fragments.BasketballSearchCourtFragment;
import pe.edu.upc.partidon.fragments.BasketballSearchMatchFragment;
import pe.edu.upc.partidon.fragments.MatchScoreFragment;
import pe.edu.upc.partidon.fragments.SearchLessMoneyCourtFragment;
import pe.edu.upc.partidon.fragments.SearchMoreMoneyCourtFragment;
import pe.edu.upc.partidon.fragments.SoccerSearchCourtFragment;
import pe.edu.upc.partidon.fragments.SoccerSearchMatchFragment;
import pe.edu.upc.partidon.fragments.TennisSearchCourtFragment;
import pe.edu.upc.partidon.fragments.TennisSearchMatchFragment;

public class CourtSearchActivity extends AppCompatActivity {


        private static final String TAG = "CourtSearchActivity";

        private SectionsPageAdapter mSectionsPagerAdapter;

        private ViewPager mViewPager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_court_search);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            setupViewPager(mViewPager);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);

            tabLayout.getTabAt(0).setIcon(R.drawable.ic_search_white_24dp);
            tabLayout.getTabAt(1).setIcon(R.drawable.soccer_item);
            tabLayout.getTabAt(2).setIcon(R.drawable.tennis_ball_item);
            tabLayout.getTabAt(3).setIcon(R.drawable.basketball_item);
            tabLayout.getTabAt(4).setIcon(R.drawable.ic_arrow_downward_white_24dp);
            tabLayout.getTabAt(5).setIcon(R.drawable.ic_arrow_upward_white_24dp);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }

        private void setupViewPager(ViewPager viewPager) {
            SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
            adapter.addFragment(new MatchScoreFragment(), "");

            adapter.addFragment(new SoccerSearchCourtFragment(), "");

            adapter.addFragment(new TennisSearchCourtFragment(), "");

            adapter.addFragment(new BasketballSearchCourtFragment(), "");
            adapter.addFragment(new SearchLessMoneyCourtFragment(), "");
            adapter.addFragment(new SearchMoreMoneyCourtFragment(), "");

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

}

