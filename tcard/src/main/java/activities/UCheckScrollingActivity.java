package activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import activities.databinding.ActivityUcheckScrollingBinding;
import controllers.UserManager;

public class UCheckScrollingActivity extends AppCompatActivity {

private ActivityUcheckScrollingBinding binding;
//

    UserManager myManager;
    Button startSelfAssessment, submitResults, backToDashboard,btnsignin;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//     binding = ActivityUcheckScrollingBinding.inflate(getLayoutInflater());
//     setContentView(binding.getRoot());
//
//        Toolbar toolbar = binding.toolbar;
//        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
//        toolBarLayout.setTitle(getTitle());
//
//        FloatingActionButton fab = binding.fab;
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        //the button sends us back to dashboard
//        backToDashboard.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), DashBoardActivity.class);
//            intent.putExtra("manager", myManager);
//            startActivity(intent);
//    });
//    }
}