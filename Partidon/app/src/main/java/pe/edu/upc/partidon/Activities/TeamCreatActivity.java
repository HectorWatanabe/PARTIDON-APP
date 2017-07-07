package pe.edu.upc.partidon.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.RegisterTeamRepository;

public class TeamCreatActivity extends AppCompatActivity {

    RegisterTeamRepository registerTeamRepository;
    TextInputEditText titleTeamTextInputEditText;
    TextInputEditText numberPlayersTextInputEditText;
    private RadioGroup teamSportRadioGroup;
    int Sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_creat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        registerTeamRepository = new RegisterTeamRepository(this);
        titleTeamTextInputEditText = (TextInputEditText) findViewById(R.id.titleTeamTextInputEditText);
        numberPlayersTextInputEditText = (TextInputEditText) findViewById(R.id.numberPlayersTextInputEditText);
        teamSportRadioGroup = (RadioGroup)  findViewById(R.id.teamSportRadioGroup);

        teamSportRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == R.id.radioFootball){
                    Sport=1;
                }else if (checkedId == R.id.radioBasket){
                    Sport=2;
                }else if (checkedId == R.id.radioTennis){
                    Sport=3;
                }

            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCreateTeamAsync(titleTeamTextInputEditText.getText().toString(),Integer.parseInt(numberPlayersTextInputEditText.getText().toString()),Sport);
                setResult(RESULT_OK);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

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

    private void loadCreateTeamAsync(String name, int players, int sport){

        registerTeamRepository.getRegisterTeam(name,players,sport,new RegisterTeamRepository.RegisterTeamCallback(){
            @Override
            public void onComplete() {


            }

            @Override
            public void onError(String message) {
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
