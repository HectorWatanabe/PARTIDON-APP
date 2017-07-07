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
import pe.edu.upc.partidon.datasource.RegisterUserRepository;

public class RegisterUserActivity extends AppCompatActivity {


    RegisterUserRepository registerUserRepository;
    TextInputEditText nameUserTextInputEditText;
    TextInputEditText emailuserTextInputEditText;
    TextInputEditText passwordTextInputEditText;
    TextInputEditText locationTextInputEditText;
    private RadioGroup userSportRadioGroup;
    int Sport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        registerUserRepository = new RegisterUserRepository(this);

        nameUserTextInputEditText = (TextInputEditText) findViewById(R.id.nameUserTextInputEditText);
        emailuserTextInputEditText = (TextInputEditText) findViewById(R.id.emailuserTextInputEditText);
        passwordTextInputEditText = (TextInputEditText) findViewById(R.id.passwordTextInputEditText);
        locationTextInputEditText = (TextInputEditText) findViewById(R.id.locationTextInputEditText);

        userSportRadioGroup = (RadioGroup)  findViewById(R.id.userSportRadioGroup);
        userSportRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

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
                loadCreateUserAsync(nameUserTextInputEditText.getText().toString(),emailuserTextInputEditText.getText().toString(),passwordTextInputEditText.getText().toString(),locationTextInputEditText.getText().toString());
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadCreateUserAsync(String name,  String email,String password,  String address   ){

        registerUserRepository.getRegisterUser( name,   email, password,   address,new RegisterUserRepository.RegisterUserCallback(){
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
