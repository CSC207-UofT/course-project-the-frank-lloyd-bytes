package activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import controllers.UserManager;
import dataBase.UserDBHelper;

import java.util.List;
import java.util.Locale;


public class LoginActivity extends AppCompatActivity{
    /**
     * This is the first page the User will see
     * If user logs in successfully they'll be directed to the Dashboard,
     * or they can go to the registration form page to sign up
     */
    EditText username, password;
    Button register, login;
    UserDBHelper DB;
    RadioGroup languageGroup;
    RadioButton checkedButton;
    Locale locale;

    public void onRadioButtonClicked(View view) {
        int radioButtonID = languageGroup.getCheckedRadioButtonId();
        checkedButton = findViewById(radioButtonID);
        String location = "en";

        String language = checkedButton.toString();
        Toast.makeText(LoginActivity.this, language, Toast.LENGTH_SHORT).show();
        if (language.equals(R.string.english)){
                location = "en";
        }
        else if (language.equals(R.string.french)){
            location = "fr";
        }
        locale = new Locale(location);
        Locale.setDefault(locale);
        Configuration configuration = getResources().getConfiguration();
        configuration.locale = locale;
        getApplicationContext().getResources().updateConfiguration(configuration, getApplicationContext().getResources().getDisplayMetrics());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        languageGroup = findViewById(R.id.languageGroup);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        DB = new UserDBHelper(this);


        // Clicking to the register button takes the user to the registration page
        register.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });

        // Clicking the login button will send the user to the dashboard page if the username exists in the database and
        // if the password matches the username
        login.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if (user.equals("")||pass.equals("")){
                Toast.makeText(LoginActivity.this, "Please enter your username and password", Toast.LENGTH_SHORT).show();
            }
            else {
                Boolean checkUserPass = DB.checkUtorIDPassword(user, pass);
                if (checkUserPass) {
                    Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                    List<String> userInfo = DB.getInfo(user);
                    UserManager myManager = new UserManager(userInfo);
                    Intent intent2 = new Intent(getApplicationContext(), DashBoardActivity.class);
                    intent2.putExtra("manager", myManager);
                    startActivity(intent2);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
