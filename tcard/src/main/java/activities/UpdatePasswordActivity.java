package activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import controllers.UserManager;
import dataBase.UserDBHelper;

public class UpdatePasswordActivity extends AppCompatActivity {
    EditText currpassword, repassword, newpassword;
    Button btcancel;
    UserManager myManager;
    UserDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepassword);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

        currpassword = findViewById(R.id.currpassword);
        newpassword = findViewById(R.id.newpassword);
        repassword = findViewById(R.id.repassword);
        btcancel = findViewById(R.id.btcancel);
        DB = new UserDBHelper(this);

        btcancel.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            intent.putExtra("manager", myManager);
            startActivity(intent);
        });
    }
    public void update(View view){
        String oldpass = currpassword.getText().toString().trim();
        String newpass = newpassword.getText().toString().trim();
        String repass = repassword.getText().toString().trim();
        if(oldpass.equals("")||newpass.equals("")||repass.equals(""))
            Toast.makeText(UpdatePasswordActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        else{
            if(newpass.equals(oldpass)){
                Toast.makeText(UpdatePasswordActivity.this, "It's same as the current password.", Toast.LENGTH_SHORT).show();
            } else if(!newpass.equals(repass)){
                Toast.makeText(UpdatePasswordActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
            else {
                myManager.changePassword(oldpass, newpass);
                Toast.makeText(UpdatePasswordActivity.this, "Password Successfully updated.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}