package activities;

import android.net.Uri;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import controllers.UserManager;

import java.net.URI;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity{
    TextView names, utorID;
    ImageView profilePic;
    TextInputEditText number, email, status, department, year;
    Button changePassword, uploadPic, backToDashboard;
    UserManager myManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

        profilePic = findViewById(R.id.profilePic);
        names = findViewById(R.id.legalNames);
        number= findViewById(R.id.profileNumber);
        email = findViewById(R.id.profileEmail);
        status = findViewById(R.id.profileStatus);
        department = findViewById(R.id.profileDepartment);
        changePassword = findViewById(R.id.profileChangePassword);
        uploadPic = findViewById(R.id.profileUploadPic);
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


        //** uploadPic.setOnClickListener(view -> {
         //   Intent intent1 = new Intent();
         //   intent1.setAction(Intent.ACTION_GET_CONTENT);
         //   intent1.setType("image/*");
          //  startActivity(intent1);
          //      });

        backToDashboard.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
            intent.putExtra("manager", myManager);
            startActivity(intent);
        });
    }

    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    //    super.onActivityResult(requestCode, resultCode, data);
    //    if(data.getData() != null){
    //        Uri profileUri = data.getData();
    //        profilePic.setImageURI(profileUri);
    //    }
    //}
}
