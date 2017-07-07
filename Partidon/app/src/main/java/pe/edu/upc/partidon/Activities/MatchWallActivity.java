package pe.edu.upc.partidon.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import java.util.List;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.InformationMatchRepository;
import pe.edu.upc.partidon.datasource.MatchesOfPlayerRepository;
import pe.edu.upc.partidon.datasource.RegisterPublicationsRepository;
import pe.edu.upc.partidon.datasource.RegisterScoreRepository;
import pe.edu.upc.partidon.fragments.MatchInformationWallFragment;
import pe.edu.upc.partidon.fragments.MatchScoreFragment;
import pe.edu.upc.partidon.models.Match;
import pe.edu.upc.partidon.views.PostDialog;
import pe.edu.upc.partidon.views.ScoreDialog;

public class MatchWallActivity extends AppCompatActivity {

        private static final String TAG = "MatchWallActivity";

        private SectionsPageAdapter mSectionsPagerAdapter;

        private InformationMatchRepository informationMatchRepository;
        private RegisterPublicationsRepository registerPublicationsRepository;
        private RegisterScoreRepository registerScoreRepository;
        private MatchesOfPlayerRepository matchesOfPlayerRepository;
        private ViewPager mViewPager;
        private FloatingActionMenu menu;
        private TextView titleMatchTextView;
        private TextView titleTeamOneTextView;
        private TextView titleTeamTwoTextView;
        private TextView nameDirecctionTextView;
        private TextView dateNumberTextView;
        Fragment matchInformationWallFragment;
        Fragment matchScoreFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_match_wall);
            registerPublicationsRepository = new RegisterPublicationsRepository(this);
            matchesOfPlayerRepository = new MatchesOfPlayerRepository(this);
            registerScoreRepository = new RegisterScoreRepository(this);

            informationMatchRepository = new InformationMatchRepository(this);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            titleMatchTextView = (TextView) findViewById(R.id.titleMatchTextView);
            titleTeamOneTextView = (TextView) findViewById(R.id.titleTeamOneTextView);
            titleTeamTwoTextView = (TextView) findViewById(R.id.titleTeamTwoTextView);
            nameDirecctionTextView = (TextView) findViewById(R.id.nameDirecctionTextView);
            dateNumberTextView = (TextView) findViewById(R.id.dateNumberTextView);

            mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());

            int idMatch = getIntent().getExtras().getInt("match_id");
            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            setupViewPager(mViewPager,idMatch);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);

            menu = (FloatingActionMenu) findViewById(R.id.menu);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            loadCourtsAsync();
            loadMatchesAsync(idMatch);


        }


    private void loadCourtsAsync(){
        int idMatch = getIntent().getExtras().getInt("match_id");
        informationMatchRepository.getInformationMatch(idMatch ,new InformationMatchRepository.InformationMatchCallback(){
            @Override
            public void onComplete(Match match) {
                titleMatchTextView.setText(match.getTitle());
                titleTeamOneTextView.setText(match.getTeam_red().getTeamName());
                titleTeamTwoTextView.setText(match.getTeam_blue().getTeamName());
                nameDirecctionTextView.setText(match.getLocation());
                dateNumberTextView.setText(match.getDate());
            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }


        private void setupViewPager(ViewPager viewPager, int id) {

            Bundle bundle = new Bundle();
            bundle.putInt("match_id",id);

            SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

            matchInformationWallFragment = new MatchInformationWallFragment();
            matchInformationWallFragment.setArguments(bundle);
            adapter.addFragment(matchInformationWallFragment, "Inicio");

            matchScoreFragment = new MatchScoreFragment();
            matchScoreFragment.setArguments(bundle);
            adapter.addFragment(matchScoreFragment, "Resultados");


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

    private void registerPublicationAsync(String comment){

        final SharedPreferences references = this.getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        int idMatch = getIntent().getExtras().getInt("match_id");
        registerPublicationsRepository.getregisterPublications(comment,Integer.parseInt(references.getString("id",null)),0,idMatch,0,new RegisterPublicationsRepository.RegisterPublicationsCallback(){
            @Override
            public void onComplete() {
                ((MatchInformationWallFragment) matchInformationWallFragment).loadCourtsAsync();

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registerScoreAsync(String red,String blue){

        final SharedPreferences references = this.getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        int idMatch = getIntent().getExtras().getInt("match_id");
        registerScoreRepository.getregisterScore(idMatch,Integer.parseInt(red),Integer.parseInt(blue),new RegisterScoreRepository.RegisterScoreCallback(){
            @Override
            public void onComplete() {
                ((MatchScoreFragment) matchScoreFragment).loadCourtsAsync();

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

        public void createMatchPost(View view){
            PostDialog.show(this, new PostDialog.Callback() {
                @Override
                public void onComplete(String content) {
                    registerPublicationAsync(content);
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
            public void onComplete(String content1,String content2) {

                registerScoreAsync(content1,content2);
                Toast.makeText(getApplicationContext(),content1+"-"+content2,Toast.LENGTH_SHORT).show();
                menu.close(true);
            }

            @Override
            public void onClose() {
                menu.close(true);
            }
        });
    }
    private void loadMatchesAsync(final int idMatch){

        matchesOfPlayerRepository.getMatchesOfPlayer(new MatchesOfPlayerRepository.MatchesOfPlayerCallback() {
            @Override
            public void onComplete(List<Match> matches) {
                int type=0;
                for (Match match :matches) {

                    if(match.getIdMatch()== idMatch){
                        type=1;
                    }
                }
                if(type==0) {
                    menu.hideMenu(true);
                }

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    }
