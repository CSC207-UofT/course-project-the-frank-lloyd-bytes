package activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import activities.databinding.ActivityUcheckScrollingBinding;
import controllers.UserManager;
import controllers.UCheckManager;

import java.util.Date;


public class UCheckScrollingActivity extends AppCompatActivity {

private ActivityUcheckScrollingBinding binding;

    UserManager myManager;
    UCheckManager myUCheckManager;
    //move submitResults into different activity
    Button startSelfAssessment, backToDashboard;
    Date displayTimeText;
    String displayFullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We get the user information from the USER object by using a controller (myManager)
        myManager = (UserManager) getIntent().getSerializableExtra("manager");
        // pass to inflate correct screen updates somehow backend and pass in user id?

        myUCheckManager = new UCheckManager(myManager.getUser().getId());
        displayTimeText = myUCheckManager.getUCheckTime();
        displayFullName = myManager.getFullName();
        int confirmedDisplay = myUCheckManager.getUCheckState();

        setContentView(R.layout.activity_ucheck_scrolling);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        //Display the correct xml layout view to inflater.
        //TODO implement xml with text date on green and username
        int layout;

        if (confirmedDisplay == 1){
            layout = R.layout.ucheck_green_layout_view;
        }
        if (confirmedDisplay == 2) {
            layout = R.layout.ucheck_red_layout_view;
        }
        //default grey display
        else{
            layout = R.layout.ucheck_grey_layout_view;
        }
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(layout, null, false);
        linearLayout.addView(myLayout);

        // send to new activity for questionnaire
     binding = ActivityUcheckScrollingBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());
        startSelfAssessment.setOnClickListener(view -> {
                    Intent intent = new Intent(getApplicationContext(), UCheckQuestionnaireActivity.class);
                    intent.putExtra("manager", myManager);
                    intent.putExtra("ucheck manager", myUCheckManager);
        });
        //the button sends us back to dashboard
        backToDashboard.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
            intent.putExtra("manager", myManager);
            startActivity(intent);
        });
    }
}