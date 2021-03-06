package activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import activities.databinding.ActivityUcheckScrollingBinding;
import controllers.UCheckManager;
import controllers.UserManager;

/**
 * This is the main dashboard for UCheck. This will display a UI interface for UCheck containing the status of UCheck,
 * and a webpage for additional resources.
 */
public class UCheckScrollingActivity extends AppCompatActivity {

private ActivityUcheckScrollingBinding binding;
    UserManager myManager;
    UCheckManager myUCheckManager;
    /**
     * @param savedInstanceState for any information that was saved previously.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We get the user information from the USER object by using a controller (myManager)
        myManager = (UserManager) getIntent().getSerializableExtra("manager");
        binding = ActivityUcheckScrollingBinding.inflate(getLayoutInflater());
        myUCheckManager = new UCheckManager();
        setContentView(binding.getRoot());
        // The launcher with the Intent you want to start for self-assessment questionnaire.
        binding.startSelfAssessment.setOnClickListener(v ->
                mStartForResult.launch(new Intent(this, UCheckQuestionnaireActivity.class)));
        //the button sends us back to dashboard.
        binding.imgBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, DashBoardActivity.class);
            intent.putExtra("manager", myManager);
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

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                /**
                 * @param result Result of activity UCheckQuestionnaireActivity.class.
                 */
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        // Handle the Intent
                        assert intent != null;
                        boolean isAllowed = intent.getBooleanExtra("isAllowed", false);
                        // This updates from the results of next activity.
                        myUCheckManager.setResult(UCheckScrollingActivity.this, myManager.getId(), isAllowed?1:2);
                        showScreen();
                    }
                }
            });

    /**
     * Display correct screen from the questionnaire with time completed and USER full name.
     */
    private void showScreen() {
        //Name of current USER.
        String legalFullName = myManager.getFullName();
        // Once a questionnaire is completed, this method sets the UCheck results
        myUCheckManager.populateResult(this, myManager.getId());
        //UCheck of questionnaire of USER.
        int layout = myUCheckManager.getLayout();
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(layout, binding.linearLayout, false);
        TextView txtName = myLayout.findViewById(R.id.txtName);
        txtName.setText(legalFullName);
        if(myUCheckManager.getState()!= 0) {
            TextView txtDate = myLayout.findViewById(R.id.txtDate);
            txtDate.setText(myUCheckManager.getDate());
        }
        binding.linearLayout.removeAllViews();
        binding.linearLayout.addView(myLayout);
}
}