package acitivies;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import dataBase.UserDBHelper;

public class UpdatePasswordActivity extends AppCompatActivity {
    EditText currpassword, repassword, newpassword;
    Button btchangepassword, btcancel;
    UserDBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepassword);

        currpassword = (EditText) findViewById(R.id.currpassword);
        newpassword = (EditText) findViewById(R.id.newpassword);
        repassword = (EditText) findViewById(R.id.repassword);
        btchangepassword = (Button) findViewById(R.id.btchangepassword);
        btcancel = (Button) findViewById(R.id.btcancel);
        DB = new UserDBHelper(this);

        btchangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldpass = currpassword.getText().toString().trim();
                String newpass = newpassword.getText().toString().trim();
                String repass = repassword.getText().toString().trim();
                if(oldpass.equals("")||newpass.equals("")||repass.equals(""))
                    Toast.makeText(UpdatePasswordActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(newpass.equals(repass)){
                        Boolean checkuser = DB.checkutorid(user); // Check if user exists in DB.
                        if(!checkuser){
                            Toast.makeText(UpdatePasswordActivity.this, "Password update failed.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            DB.changepassword(user,newpass);
                            Toast.makeText(UpdatePasswordActivity.this, "Password Successfully updated.", Toast.LENGTH_SHORT).show();
                        }
                        if (!newpass.equals(repass)){
                        Toast.makeText(UpdatePasswordActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                    }
                } }
        }
    });
}

}
