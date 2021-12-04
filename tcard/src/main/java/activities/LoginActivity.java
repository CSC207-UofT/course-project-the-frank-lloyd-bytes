package activities;

import android.content.SharedPreferences;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import controllers.UserManager;
import dataBase.UserDBHelper;

import java.util.List;


public class LoginActivity extends AppCompatActivity{
    /**
     * This is the first page the User will see
     * If user logs in successfully they'll be directed to the Dashboard,
     * or they can go to the registration form page to sign up
     */
    EditText username, password;
    Button register, login;
    Switch viewMode;
    UserDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        login = findViewById(R.id.login);
        viewMode = findViewById(R.id.moodSwitcher);
        register = findViewById(R.id.register);
        DB = new UserDBHelper(this);
        SharedPreferences sharedPreferences = null;

        sharedPreferences = getSharedPreferences("AppSettingPrefs", 0);
        Boolean booleanValue = sharedPreferences.getBoolean("nightMode", false);
        if (booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            viewMode.setChecked(true);
        }

        SharedPreferences finalSharedPreferences = sharedPreferences;
        viewMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                viewMode.setChecked(true);
                SharedPreferences.Editor editor = finalSharedPreferences.edit();
                editor.putBoolean("nightMode", true);
                editor.apply();

            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                viewMode.setChecked(false);
                SharedPreferences.Editor editor = finalSharedPreferences.edit();
                editor.putBoolean("nightMode", false);
                editor.apply();
            }
        });

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
