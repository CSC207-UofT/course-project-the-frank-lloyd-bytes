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
        setContentView(R.layout.activity_updatepassword); // XML front-end.

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
                String user = username.getText().toString(); // Not sure if I need to access username field?
                if(oldpass.equals("")||newpass.equals("")||repass.equals(""))
                    Toast.makeText(UpdatePasswordActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(newpass.equals(repass)){
                        Boolean checkuser = DB.checkutorid(user); // Check if user exists in DB.
                        if(checkuser==false){// maybe delete
                            Boolean insert = DB.changepassword(user,newpass);// add new user
                            if(insert==true){
                                Toast.makeText(UpdatePasswordActivity.this, "Password successfully updated", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(UpdatePasswordActivity.this, "Password update failed", Toast.LENGTH_SHORT).show();
                            }
                    }else{
                        Toast.makeText(UpdatePasswordActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        };
    });
}

}