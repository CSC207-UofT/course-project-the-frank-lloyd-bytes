package activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
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
    UserDBHelper dB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        dB = new UserDBHelper(this);


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
                Boolean checkUserPass = dB.checkUtorIDPassword(user, pass);
                if (checkUserPass) {
                    Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                    List<String> userInfo = dB.getInfo(user);
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
