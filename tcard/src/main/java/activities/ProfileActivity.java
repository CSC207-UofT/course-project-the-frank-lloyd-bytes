package activities;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import controllers.UserManager;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity{
    TextView names, utorID;
    TextInputEditText number, email, status, department, year;
    Button changePassword, backToDashboard;
    UserManager myManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

        names = findViewById(R.id.legalNames);
        number= findViewById(R.id.profileNumber);
        email = findViewById(R.id.profileEmail);
        status = findViewById(R.id.profileStatus);
        department = findViewById(R.id.profileDepartment);
        changePassword = findViewById(R.id.profileChangePassword);
        backToDashboard = findViewById(R.id.profileGoBack);
        year = findViewById(R.id.profileYear);
        utorID = findViewById(R.id.profileUtorID);
        ArrayList<String> info = myManager.getinfo();
        String legalFirstName = info.get(2);
        String legalLastName = info.get(3);
        names.setText(legalFirstName+" "+legalLastName);
        utorID.setText(info.get(0));
        number.setText(info.get(5));
        email.setText(info.get(6));
        status.setText(info.get(4));
        department.setText(info.get(8));
        year.setText(info.get(7));


        backToDashboard.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
            intent.putExtra("manager", myManager);
            startActivity(intent);
        });
    }
}
