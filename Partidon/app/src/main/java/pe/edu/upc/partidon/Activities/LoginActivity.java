package pe.edu.upc.partidon.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pe.edu.upc.partidon.R;

public class LoginActivity extends AppCompatActivity {
    Button logintButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logintButton = (Button) findViewById(R.id.loginButton);
        logintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MenuActivity.class));
            }
        });
    }
}
