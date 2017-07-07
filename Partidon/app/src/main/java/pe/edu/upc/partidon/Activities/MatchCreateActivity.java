package pe.edu.upc.partidon.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.RegisterMatchRepository;

public class MatchCreateActivity extends AppCompatActivity {

    RegisterMatchRepository registerMatchRepository;
    TextInputEditText nameMatchTextInputEditText;
    TextInputEditText locationMatchTextInputEditText;
    TextInputEditText distritMatchTextInputEditText;
    TextInputEditText teamOneTextInputEditText;
    TextInputEditText teamTwoTextInputEditText;
    TextInputEditText dateTextInputEditText;
    private RadioGroup matchSportRadioGroup;
    int Sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        registerMatchRepository = new RegisterMatchRepository(this);
        nameMatchTextInputEditText = (TextInputEditText) findViewById(R.id.nameMatchTextInputEditText);
        locationMatchTextInputEditText = (TextInputEditText) findViewById(R.id.locationMatchTextInputEditText);
        distritMatchTextInputEditText = (TextInputEditText) findViewById(R.id.distritMatchTextInputEditText);
        teamOneTextInputEditText = (TextInputEditText) findViewById(R.id.teamOneTextInputEditText);
        teamTwoTextInputEditText = (TextInputEditText) findViewById(R.id.teamTwoTextInputEditText);
        dateTextInputEditText = (TextInputEditText) findViewById(R.id.dateTextInputEditText);

        matchSportRadioGroup = (RadioGroup)  findViewById(R.id.matchSportRadioGroup);
        matchSportRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

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
                loadCreateTeamAsync(nameMatchTextInputEditText.getText().toString(),locationMatchTextInputEditText.getText().toString(),distritMatchTextInputEditText.getText().toString(),dateTextInputEditText.getText().toString(),Sport,Integer.parseInt(teamOneTextInputEditText.getText().toString()),Integer.parseInt(teamTwoTextInputEditText.getText().toString()));
                setResult(RESULT_OK);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadCreateTeamAsync(String name,  String address,String district,  String match_date, int sport_id,  int team_red_id, int team_blue_id ){

        registerMatchRepository.getRegisterMatch(name,address,district,match_date,sport_id,team_red_id,team_blue_id,new RegisterMatchRepository.RegisterMatchCallback(){
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
