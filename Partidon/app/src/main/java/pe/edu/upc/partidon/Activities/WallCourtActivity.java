package pe.edu.upc.partidon.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import pe.edu.upc.partidon.Adapters.SectionsPageAdapter;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.fragments.CourtListFragment;
import pe.edu.upc.partidon.fragments.InformationCourtFragment;
import pe.edu.upc.partidon.fragments.WallCourtFragment;

public class WallCourtActivity extends AppCompatActivity {

    private static final String TAG = "WallCourtActicity";

    private SectionsPageAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_court);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int id = getIntent().getExtras().getInt("key_id");
        int idUser = getIntent().getExtras().getInt("user_id");

        mSectionsPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager, id,idUser);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    private void setupViewPager(ViewPager viewPager, int id,int idUser) {
        Bundle bundle = new Bundle();
        bundle.putInt("key_id",id);
        bundle.putInt("user_id",idUser);

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        Fragment information = new InformationCourtFragment();
        information.setArguments(bundle);
        adapter.addFragment(information, "Inicio");

        Fragment wallCourtFragment = new WallCourtFragment();
        wallCourtFragment.setArguments(bundle);
        adapter.addFragment(wallCourtFragment, "Muro");

        Fragment courtListFragment = new CourtListFragment();
        courtListFragment.setArguments(bundle);
        adapter.addFragment(courtListFragment, "Canchas");
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
