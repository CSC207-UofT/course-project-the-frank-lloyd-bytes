package activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import activities.databinding.ActivityUcheckScrollingBinding;
import controllers.UserManager;
import controllers.UCheckManager;
import java.util.Date;

/**
 * This is the main dashboard for UCheck. This will display a UI interface for UCheck containing the status of UCheck,
 * and a webpage for additional resources.
 */
public class UCheckScrollingActivity extends AppCompatActivity {

private ActivityUcheckScrollingBinding binding;

    UserManager myManager;
    UCheckManager myUCheckManager;
    Date displayTimeText;
    String displayFullName;
    int confirmedDisplay;

    /**
     * @param savedInstanceState for any information that was saved previously.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We get the user information from the USER object by using a controller (myManager)
        myManager = (UserManager) getIntent().getSerializableExtra("manager");
        myUCheckManager = new UCheckManager(myManager.getUser().getId());
        displayFullName = myManager.getFullName();

        // send to new activity for questionnaire.
        binding = ActivityUcheckScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //This button brings USER into the questionnaire activity.
        binding.startSelfAssessment.setOnClickListener(view -> {
                    Intent intent = new Intent(getApplicationContext(), UCheckQuestionnaireActivity.class);
                    startActivityForResult(intent,001);
        });
        //the button sends us back to dashboard.
        binding.imgBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
            startActivity(intent);
        });
        // Prompts UofT external website for USER.
        binding.imageViewBtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.utoronto.ca/utogether"));
            startActivity(intent);
        });
        showScreen();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 001) {
            if(resultCode == RESULT_OK) {
                assert data != null;
                boolean isAllowed = data.getBooleanExtra("isAllowed", false);
                confirmedDisplay = isAllowed?1:2;
                showScreen();
            }
        }
    }

    private void showScreen() {

        //Display the correct xml layout view to inflater.
        //TODO implement xml with text date on green and username
        int layout;


        if (confirmedDisplay == 1){
            layout = R.layout.ucheck_green_layout_view;
            myUCheckManager.setUCheckStatus(true);

        }
        else
        if (confirmedDisplay == 2){
            layout = R.layout.ucheck_red_layout_view;
            myUCheckManager.setUCheckStatus(false);
        }
        //default grey display
        else{
            layout = R.layout.ucheck_grey_layout_view;
        }
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(layout, binding.linearLayout, false);
        binding.linearLayout.removeAllViews();
        binding.linearLayout.addView(myLayout);
    }
}