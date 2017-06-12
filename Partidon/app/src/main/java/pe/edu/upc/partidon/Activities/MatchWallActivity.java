package pe.edu.upc.partidon.Activities;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
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

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.fragments.CourtListFragment;
import pe.edu.upc.partidon.fragments.InformationCourtFragment;
import pe.edu.upc.partidon.fragments.MatchInformationWallFragment;
import pe.edu.upc.partidon.fragments.MatchScoreFragment;
import pe.edu.upc.partidon.fragments.WallCourtFragment;
import pe.edu.upc.partidon.views.PostDialog;
import pe.edu.upc.partidon.views.ScoreDialog;

public class MatchWallActivity extends AppCompatActivity {

        private static final String TAG = "MatchWallActivity";

        private SectionsPageAdapter mSectionsPagerAdapter;

        private ViewPager mViewPager;
        private FloatingActionMenu menu;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_match_wall);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            setupViewPager(mViewPager);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);

            menu = (FloatingActionMenu) findViewById(R.id.menu);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }

        private void setupViewPager(ViewPager viewPager) {
            SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
            adapter.addFragment(new MatchInformationWallFragment(), "Inicio");
            adapter.addFragment(new MatchScoreFragment(), "Resultados");
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

        public void createMatchPost(View view){
            PostDialog.show(this, new PostDialog.Callback() {
                @Override
                public void onComplete(String content) {
                    Toast.makeText(getApplicationContext(),content,Toast.LENGTH_SHORT).show();
                    menu.close(true);
                }

                @Override
                public void onClose() {
                    menu.close(true);
                }
            });
        }

    public void createMatchScore(View view){
        ScoreDialog.show(this, new ScoreDialog.Callback() {
            @Override
            public void onComplete(String content) {
                Toast.makeText(getApplicationContext(),content,Toast.LENGTH_SHORT).show();
                menu.close(true);
            }

            @Override
            public void onClose() {
                menu.close(true);
            }
        });
    }

        /**
         * A placeholder fragment containing a simple view.
         */


    }
