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
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.fragments.CourtFragment;
import pe.edu.upc.partidon.fragments.MatchFragment;
import pe.edu.upc.partidon.fragments.NewsFragment;
import pe.edu.upc.partidon.fragments.TeamsFragment;
import pe.edu.upc.partidon.fragments.UserFragment;
import pe.edu.upc.partidon.views.PostDialog;

public class MenuActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private TextView mTextMessage;
    private FrameLayout frameLayout;
    private FloatingActionMenu menuUser;


  //  public boolean onCreateOptionsMenu(Menu menu)
  //  {
  //      getMenuInflater().inflate(R.menu.main, menu);
  //      return true;
  //  }

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
                case R.id.navigation_teams:
                    replaceFragment(2);
                    break;
                case R.id.navigation_fields:
                    replaceFragment(3);
                    break;
                case R.id.navigation_user:
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

    public void createUserWallPost(View view){
        menuUser = (FloatingActionMenu) findViewById(R.id.menuUser);
        PostDialog.show(this, new PostDialog.Callback() {
            @Override
            public void onComplete(String content) {

                Toast.makeText(getApplicationContext(),content,Toast.LENGTH_SHORT).show();
                menuUser.close(true);
            }

            @Override
            public void onClose() {

                menuUser.close(true);
            }
        });
    }





    private List<Fragment> mFragments;
    private List<Fragment> getFragments(){
        if(mFragments == null){
            mFragments = new ArrayList<Fragment>();
            mFragments.add(NewsFragment.newInstance());
            mFragments.add(MatchFragment.newInstance());
            mFragments.add(TeamsFragment.newInstance());
            mFragments.add(CourtFragment.newInstance());
            mFragments.add(UserFragment.newInstance( ));
        }
        return mFragments;
    }

}
