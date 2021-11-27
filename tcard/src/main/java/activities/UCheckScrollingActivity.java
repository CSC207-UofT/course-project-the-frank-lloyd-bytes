package activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import activities.databinding.ActivityUcheckScrollingBinding;
import controllers.UserManager;
import controllers.UCheckManager;
import dataBase.UCheckDBHelper;


public class UCheckScrollingActivity extends AppCompatActivity {

private ActivityUcheckScrollingBinding binding;

    UCheckFragmentFactory fragmentFactory;
    UserManager myManager;
    Button startSelfAssessment, submitResults, backToDashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ucheck_scrolling);
        myManager = (UserManager) getIntent().getSerializableExtra("manager");

     binding = ActivityUcheckScrollingBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());
        startSelfAssessment.setOnClickListener(view ->
                Intent intent = new Intent());
        //the button sends us back to dashboard
        backToDashboard.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
            intent.putExtra("manager", myManager);
            startActivity(intent);
    });
        }
}