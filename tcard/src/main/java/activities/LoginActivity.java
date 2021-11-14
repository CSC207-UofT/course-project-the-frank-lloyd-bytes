package activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import controllers.UserManager;
import dataBase.UserDBHelper;

import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity{
    EditText username, password;
    Button register, login;
    UserDBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.userNameInput);
        password = findViewById(R.id.passwordInput);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        DB = new UserDBHelper(this);

        register.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
        login.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if (user.equals("")||pass.equals("")){
                Toast.makeText(LoginActivity.this, "Please enter your username and password", Toast.LENGTH_SHORT).show();
            }
            else {
                Boolean checkuserpass = DB.checkutroidpassword(user, pass);
                if (checkuserpass) {
                    Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                    ArrayList<String> userInfo = DB.getInfo(user);
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
