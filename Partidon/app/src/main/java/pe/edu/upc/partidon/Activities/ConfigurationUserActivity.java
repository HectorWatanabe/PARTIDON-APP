package pe.edu.upc.partidon.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.SpecialityRepository;
import pe.edu.upc.partidon.datasource.UserRepository;
import pe.edu.upc.partidon.models.Specialty;

public class ConfigurationUserActivity extends AppCompatActivity {

    private RadioButton radioFootball;
    private RadioButton radioBasket;
    private RadioButton radioTennis;
    private EditText userNameEditText;
    private EditText userLocationEditText;
    private UserRepository userRepository;
    private SpecialityRepository specialityRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        specialityRepository = new SpecialityRepository(this);

        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        userLocationEditText = (EditText) findViewById(R.id.userLocationEditText);
        radioFootball = (RadioButton) findViewById(R.id.radioFootball);
        radioBasket = (RadioButton) findViewById(R.id.radioBasket);
        radioTennis = (RadioButton) findViewById(R.id.radioTennis);
        userRepository = new UserRepository(this);

        SharedPreferences references = getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        userNameEditText.setText(references.getString("name",null));
        userLocationEditText.setText(references.getString("local",null));
        loadSpecialitysAsync();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public void loadSpecialitysAsync(){
        final SharedPreferences references = this.getSharedPreferences("PARTIDON", Context.MODE_PRIVATE);
        specialityRepository.getSpecialityPlayer(Integer.parseInt(references.getString("id_player",null)), new SpecialityRepository.SpecialityCallback() {
            @Override
            public void onComplete(List<Specialty> specialties) {
                for (Specialty sport :specialties) {

                        switch (sport.getSport())
                        {
                            case 1:
                                radioFootball.setChecked(true);
                                break;
                            case 2:
                                radioBasket.setChecked(true);
                                break;
                            case 3:
                                radioTennis.setChecked(true);
                                break;
                        }

                }

            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
