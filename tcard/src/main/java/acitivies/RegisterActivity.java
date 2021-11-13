package acitivies;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import dataBase.UserDBHelper;

public class RegisterActivity extends AppCompatActivity{
        EditText username, password, repassword;
        Button btnsignup, btnsignin;
        UserDBHelper DB;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            username = (EditText) findViewById(R.id.username1);
            password = (EditText) findViewById(R.id.password1);
            repassword = (EditText) findViewById(R.id.repassword);
            btnsignup = (Button) findViewById(R.id.btnsignup1);
            btnsignin = (Button) findViewById(R.id.btnsignin1);
            DB = new UserDBHelper(this);

            btnsignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String user = username.getText().toString();
                    String pass = password.getText().toString();
                    String repass = repassword.getText().toString();

                    if(user.equals("")||pass.equals("")||repass.equals(""))
                        Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    else{
                        if(pass.equals(repass)){
                            Boolean checkuser = DB.checkutorid(user);
                            if(!checkuser){
                                Boolean insert = DB.insertData(user, pass);
                                if(insert){
                                    Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                        }
                    } }
            });
        }
}

