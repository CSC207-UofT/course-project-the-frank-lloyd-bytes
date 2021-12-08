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
     * If the password change operator is successful than the password will be changed in the database
     * so the next time the user signs in, they have to type the new password
     */
    EditText currPassword, rePassword, newPassword;
    Button btnCancel;
    UserManager myManager;
    UserDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepassword);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");
        currPassword = findViewById(R.id.currpassword);
        newPassword = findViewById(R.id.newpassword);
        rePassword = findViewById(R.id.repassword);
        btnCancel = findViewById(R.id.btcancel);
        DB = new UserDBHelper(this);

        btnCancel.setOnClickListener(view ->{
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
        String rePass = rePassword.getText().toString().trim();

        String updateMessage = myManager.changePassword(oldPass, newPass, rePass);
        Toast.makeText(UpdatePasswordActivity.this, updateMessage, Toast.LENGTH_SHORT).show();
        if (updateMessage.equals("Password successfully changed")){
            DB.updatePassword(myManager.getInfo());
        }
    }

}