package activities;

import android.app.Instrumentation;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.*;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import controllers.UserManager;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity{
    /**
     * This page displays the user's information
     * allows user to change password (profile picture update feature is coming in Phase 2)
     */
    TextView names, utorID;
    ImageView profilePic;
    TextInputEditText number, email, status, department, year;
    Button changePassword, backToDashboard, uploadPicture;
    UserManager myManager;
    ActivityResultLauncher<Intent> activityResultLauncher;

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
        uploadPicture = findViewById(R.id.profileChangePicture);
        department = findViewById(R.id.profileDepartment);
        changePassword = findViewById(R.id.profileChangePassword);
        backToDashboard = findViewById(R.id.profileGoBack);
        year = findViewById(R.id.profileYear);
        utorID = findViewById(R.id.profileUtorID);

        // putting in USER Object information in
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

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>(){
                    public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData()!= null) {
                        Intent data = result.getData();
                        Uri imageUri = Uri.parse(data.getDataString());
                        profilePic.setImageURI(imageUri);
                    }
            }});
        uploadPicture.setOnClickListener(view -> {
            Intent imagePickerIntent = new Intent(Intent.ACTION_OPEN_DOCUMENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            imagePickerIntent.setType("image/*");
            activityResultLauncher.launch(imagePickerIntent);
        });
    }

}
