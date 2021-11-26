package activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import controllers.UserManager;

import java.util.List;

public class ProfileActivity extends AppCompatActivity{
    /**
     * This page displays the user's information
     * allows user to change password (profile picture update feature is coming in Phase 2)
     */
    TextView names, utorID;
    ImageView profilePic;
    TextInputEditText number, email, status, department, year;
    Button changePassword, backToDashboard;
    UserManager myManager;
    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        // We get the user information from the USER object by using a controller (myManager)
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

        profilePic = findViewById(R.id.profilePic);
        names = findViewById(R.id.legalNames);
        number= findViewById(R.id.profileNumber);
        email = findViewById(R.id.profileEmail);
        status = findViewById(R.id.profileStatus);
        department = findViewById(R.id.profileDepartment);
        changePassword = findViewById(R.id.profileChangePassword);
        backToDashboard = findViewById(R.id.profileGoBack);
        year = findViewById(R.id.profileYear);
        utorID = findViewById(R.id.profileUtorID);

        // putting in USER Object information in
        List<String> info = myManager.getinfo();
        String legalFirstName = info.get(2);
        String legalLastName = info.get(3);
        names.setText(legalFirstName+" "+legalLastName);
        utorID.setText(info.get(0));
        number.setText(info.get(5));
        email.setText(info.get(6));
        status.setText(info.get(4));
        department.setText(info.get(8));
        year.setText(info.get(7));

        // the button sends us back to dashboard
        backToDashboard.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
            intent.putExtra("manager", myManager);
            startActivity(intent);
        });

        // the button sends us to the password update page
        changePassword.setOnClickListener(view -> {
            Intent intent2 = new Intent(getApplicationContext(), UpdatePasswordActivity.class);
            intent2.putExtra("manager", myManager);
            startActivity(intent2);
        });
    }

}
