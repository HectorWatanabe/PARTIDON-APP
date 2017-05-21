package pe.edu.upc.partidon.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.fragments.CourtFragment;
import pe.edu.upc.partidon.fragments.MatchFragment;
import pe.edu.upc.partidon.fragments.NewsFragment;
import pe.edu.upc.partidon.fragments.TeamsFragment;

public class MenuActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private TextView mTextMessage;
    private FrameLayout frameLayout;


    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onFragmentInteraction(Uri uri){

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_news:
                    replaceFragment(0);
                    break;
                case R.id.navigation_match:
                    replaceFragment(1);
                    break;
                case R.id.navigation_comments:
                    replaceFragment(2);
                    break;
                case R.id.navigation_teams:
                    replaceFragment(3);
                    break;
                case R.id.navigation_fields:
                    replaceFragment(4);
                    break;
            }
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        replaceFragment(0);

    }

    private void replaceFragment(int position){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, getFragments().get(position)); // f1_container is your FrameLayout container
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }


    private List<Fragment> mFragments;
    private List<Fragment> getFragments(){
        if(mFragments == null){
            mFragments = new ArrayList<Fragment>();
            mFragments.add(NewsFragment.newInstance());
            mFragments.add(TeamsFragment.newInstance());
            mFragments.add(TeamsFragment.newInstance());
            mFragments.add(MatchFragment.newInstance());
            mFragments.add(CourtFragment.newInstance());
        }
        return mFragments;
    }

}
