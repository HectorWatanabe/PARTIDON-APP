package pe.edu.upc.partidon.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.datasource.UserRepository;
import pe.edu.upc.partidon.models.Player;

public class LoginActivity extends AppCompatActivity {
    private final String TAG = "LoginActivity";


    // UI references.
    private AutoCompleteTextView userTextInputEditText;
    private TextInputEditText passwordTextInputEditText;
    private View mProgressView;
    private View mLoginFormView;
    private TextView failedLoginMessage;

    private UserRepository userRepository;

    View focusView = null;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userRepository = new UserRepository(this);
        // Set up the login form.
        userTextInputEditText = (AutoCompleteTextView) findViewById(R.id.userTextInputEditText);

        failedLoginMessage = (TextView)findViewById(R.id.failed_login);

        passwordTextInputEditText = (TextInputEditText) findViewById(R.id.passwordTextInputEditText);
        passwordTextInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.loginButton);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                failedLoginMessage.setText("");
                attemptLogin();
            }
        });

        Button mSignUpButton = (Button) findViewById(R.id.signUpButton);
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterUserActivity.class));
            }
        });
/*
        Button registrationButton = (Button)findViewById(R.id.registration_button);
        registrationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegistration();
            }
        });
        */

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void attemptRegistration(){
        boolean mCancel = this.loginValidation();
        if (mCancel) {
            focusView.requestFocus();
        }
    }

    private void attemptLogin(){
        boolean mCancel = this.loginValidation();
        email = userTextInputEditText.getText().toString();
        password = passwordTextInputEditText.getText().toString();
        if (mCancel) {
            focusView.requestFocus();
        } else {
            loadCourtsAsync(email, password);
        }
    }


    private void loadCourtsAsync(String email, String password){
        userRepository.getlogin(email ,password ,new UserRepository.LoginCallback(){
            @Override
            public void onComplete(Player player) {

                if(player != null) {
                    Intent loginIntent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(loginIntent);
                }else{
                    failedLoginMessage.setText("Usuario o Contraseña Incorrecta");
                }
            }

            @Override
            public void onError(String message) {

                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean loginValidation() {
        // Reset errors.
        userTextInputEditText.setError(null);
        passwordTextInputEditText.setError(null);

        // Store values at the time of the login attempt.
        email = userTextInputEditText.getText().toString();
        password = passwordTextInputEditText.getText().toString();

        boolean cancel = false;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordTextInputEditText.setError(getString(R.string.error_invalid_password));
            focusView = passwordTextInputEditText;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            userTextInputEditText.setError(getString(R.string.error_field_required));
            focusView = userTextInputEditText;
            cancel = true;
        } else if (!isEmailValid(email)) {
            userTextInputEditText.setError(getString(R.string.error_invalid_email));
            focusView = userTextInputEditText;
            cancel = true;
        }
        return cancel;
    }



    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }




}
