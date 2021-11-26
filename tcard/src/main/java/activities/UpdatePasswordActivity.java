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
    /**
     * This page is called by the ProfileActivity to change the password of the user
     * If the password change operator is succesfull than the password will be changed in the database
     * so the next time the user signs in, they have to type the new password
     */
    EditText currPassword, rePassword, newPassword;
    Button btCancel;
    UserManager myManager;
    UserDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepassword);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

        currPassword = findViewById(R.id.currPassword);
        newPassword = findViewById(R.id.newPassword);
        rePassword = findViewById(R.id.rePassword);
        btCancel = findViewById(R.id.btCancel);
        DB = new UserDBHelper(this);

        btCancel.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            intent.putExtra("manager", myManager);
            startActivity(intent);
        });
    }
    /**
     * This checks whether the update password button was clicked
     * If it was clicked it checks whether the inputted data is valid and if it is valid
     * then the password is changed in the database to the new one
     */
    public void update(View view){
        String oldPass = currPassword.getText().toString().trim();
        String newPass = newPassword.getText().toString().trim();
        String repass = rePassword.getText().toString().trim();
        // checks if there are any empty input text boxes
        if(oldPass.equals("")||newPass.equals("")||repass.equals("")){
            Toast.makeText(UpdatePasswordActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        } else{
            if(newPass.equals(oldPass)){
                Toast.makeText(UpdatePasswordActivity.this, "It's same as the current password.", Toast.LENGTH_SHORT).show();
            } else if(!newPass.equals(repass)){
                Toast.makeText(UpdatePasswordActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
            else {
                myManager.changePassword(oldPass, newPass);
                if(DB.updataPassword(myManager.getinfo())){
                    Toast.makeText(UpdatePasswordActivity.this, "Password Successfully updated.", Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

}